<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AddUserForm.aspx.cs" Inherits="AppClient.AddUserForm" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 59%;
        }

        .auto-style2 {
            height: 23px;
        }

        .auto-style3 {
            height: 24px;
            font-size: large;
        }

        .auto-style4 {
            height: 26px;
        }

        .auto-style5 {
            height: 23px;
            width: 264px;
        }

        .auto-style6 {
            width: 264px;
        }

        .auto-style7 {
            height: 26px;
            width: 264px;
        }

        .auto-style8 {
            height: 24px;
            font-size: large;
            width: 264px;
        }

        .auto-style9 {
            height: 24px;
            font-size: large;
            text-align: right;
        }

        .auto-style10 {
            text-align: left;
        }

        .auto-style11 {
            margin-bottom: 0px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style8"><strong>Додання нового користувача</strong></td>
                    <td class="auto-style9">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3" colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style5">ІПН:</td>
                    <td class="auto-style2">
                        <asp:TextBox ID="txtInn" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">Прізвище:</td>
                    <td>
                        <asp:TextBox ID="txtSurname" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">І&#39;мя:</td>
                    <td>
                        <asp:TextBox ID="txtFirstname" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">По батькові:</td>
                    <td>
                        <asp:TextBox ID="txtPatronymic" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">Дата народження:</td>
                    <td>
                        <asp:Calendar ID="clnBirthdate" runat="server" SelectedDate="1965-05-17" VisibleDate="1965-05-17"></asp:Calendar>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">Серія паспорту:</td>
                    <td>
                        <asp:TextBox ID="txtPassport_ser" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style7">Номер паспорту:</td>
                    <td class="auto-style4">
                        <asp:TextBox ID="txtPassport_num" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">Адреса прописки:</td>
                    <td>
                        <asp:TextBox ID="txtAddress" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <hr />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="Додати" />
                        <asp:Button ID="btnCancel" runat="server" OnClick="btnCancel_Click" Text="Відміна" CssClass="auto-style11" />
                    </td>
                    <td class="auto-style10">&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
