<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MainForm.aspx.cs" Inherits="AppClient.MainForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td style="text-align: left"">
                        <asp:Label ID="lblSearch" runat="server" Text="ІПН або Прізвище"></asp:Label>
                        <asp:TextBox ID="txtSearch" runat="server"></asp:TextBox>
                        <asp:Button ID="BtnSearch" runat="server" Text="знайти" OnClick="btnSearch_Click" />
                        <asp:Button ID="BtnAdd" runat="server" Text="додати" OnClick="btnAdd_Click" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <asp:GridView ID="dgUsers" AutoGenerateColumns="False" runat="server" Width="100%" OnRowCommand="dgUsers_RowCommand">
                            <Columns>
                                <asp:BoundField HeaderText="ІПН" HeaderStyle-BackColor="LightGray" DataField="Inn" />
                                <asp:BoundField HeaderText="Прізвище" HeaderStyle-BackColor="LightGray" DataField="Surname" />
                                <asp:BoundField HeaderText="І'мя" HeaderStyle-BackColor="LightGray" DataField="Firstname" />
                                <asp:BoundField HeaderText="По батькові" HeaderStyle-BackColor="LightGray" DataField="Patronymic" />
                                <asp:BoundField HeaderText="Дата народження" HeaderStyle-BackColor="LightGray" DataField="Birthdate" DataFormatString="{0:dd.MM.yyyy}" />
                                <asp:BoundField HeaderText="Серія паспорту" HeaderStyle-BackColor="LightGray" DataField="Passport_ser" />
                                <asp:BoundField HeaderText="Номер паспорту" HeaderStyle-BackColor="LightGray" DataField="Passport_num" />
                                <asp:BoundField HeaderText="Адреса прописки" HeaderStyle-BackColor="LightGray" DataField="Address" />
                                <asp:ButtonField ButtonType = "button" Text = "відкрити" />
                            </Columns>
                        </asp:GridView>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
