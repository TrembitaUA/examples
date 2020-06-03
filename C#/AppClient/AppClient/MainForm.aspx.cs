using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AppClient
{
    public partial class MainForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            var users = AppClients.GetUsers();
            dgUsers.DataSource = users;
            dgUsers.DataBind();
        }
        protected void dgUsers_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int a = Convert.ToInt32(e.CommandArgument);
            string sInn = dgUsers.Rows[a].Cells[0].Text;
            Response.Redirect("ViewForm.aspx?SInn=" + sInn);
        }
        protected void btnSearch_Click(object sender, EventArgs e)
        {
            dgUsers.DataSource = AppClients.GetByFilter(txtSearch.Text);
            dgUsers.DataBind();
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            Response.Redirect("AddUserForm.aspx");
        }
    }
}