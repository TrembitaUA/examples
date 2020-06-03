using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AppClient
{
    public partial class AddUserForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            AppClients.AddUser(txtInn.Text, txtSurname.Text, txtFirstname.Text, txtPatronymic.Text, txtPassport_ser.Text, txtPassport_num.Text, clnBirthdate.SelectedDate, txtAddress.Text);
            Response.Redirect("MainForm.aspx");

        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainForm.aspx");
        }
    }
}