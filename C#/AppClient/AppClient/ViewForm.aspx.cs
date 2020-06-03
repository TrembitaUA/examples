using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
namespace AppClient
{

    public partial class ViewForm : System.Web.UI.Page
    {
        string sInn;
        protected void Page_Load(object sender, EventArgs e)
        {
            sInn = Request.QueryString["sInn"];
            AppGetUsers.AppUser usr = AppClients.GetUsers().FirstOrDefault(f => f.Inn == sInn);
            if (usr != null)
            {
                lblInn.Text = usr.Inn;
                lblSurname.Text = usr.Surname;
                lblFirstname.Text = usr.Firstname;
                lblPatronymic.Text = usr.Patronymic;
                lblPassport_ser.Text = usr.Passport_ser;
                lblPassport_num.Text = usr.Passport_num;
                lblAddress.Text = usr.Address;

                if (usr.Birthdate.HasValue)
                    lblBirthdate.Text = usr.Birthdate.Value.ToString("dd.MM.yyyy");
            }
        }
        protected void btnOK_Click(object sender, EventArgs e)
        {
            if (FileUpload.HasFile)
            {
                AppClients.UploadDocument(sInn, FileUpload.FileName, FileUpload.FileBytes);
                Response.Redirect("MainForm.aspx");
            }
        }
        protected void btnDownload_Click(object sender, EventArgs e)
        {
            string name = string.Empty;
            byte[] data = AppClients.DownloadDocument(sInn, out name);
            if (data != null)
            {
                Response.ContentType = "application / force-download";
                Response.AppendHeader("Content-Disposition", "attachment; filename = " + name);
                Response.BinaryWrite(data);
                Response.End();
            }
            else
            {
                string script = "alert(\"Документ не знайдено!\")";
                ScriptManager.RegisterStartupScript(this, GetType(), "ServerControlScript", script, true);
            }
        }
        protected void btnClose_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainForm.aspx");
        }
    }
}
