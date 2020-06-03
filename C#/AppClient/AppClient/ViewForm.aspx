<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ViewForm.aspx.cs" Inherits="AppClient.ViewForm" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 67%;
            margin-right: 0px;
        }

        .auto-style2 {
            height: 23px;
            width: 628px;
        }

        .auto-style3 {
            height: 23px;
            width: 500px;
        }

        .auto-style4 {
            width: 500px;
        }

        .auto-style5 {
            font-size: large;
        }

        .auto-style6 {
            height: 30px;
        }

        .auto-style7 {
            height: 30px;
            width: 500px;
        }

        .auto-style8 {
            font-size: large;
            text-align: right;
            width: 628px;
        }

        .auto-style9 {
            width: 628px;
        }

        .auto-style10 {
            height: 30px;
            width: 628px;
        }

        .auto-style11 {
            font-size: large;
            width: 500px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style11"><strong>Дані користувача</strong></td>
                    <td class="auto-style8">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" class="auto-style5">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3">ІПН:</td>
                    <td class="auto-style2">
                        <asp:Label ID="lblInn" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">Прізвище:</td>
                    <td class="auto-style2">
                        <asp:Label ID="lblSurname" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">І&#39;мя:</td>
                    <td class="auto-style2">
                        <asp:Label ID="lblFirstname" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">По батькові:</td>
                    <td class="auto-style9">
                        <asp:Label ID="lblPatronymic" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Дата народження:</td>
                    <td class="auto-style9">
                        <asp:Label ID="lblBirthdate" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Серія паспорту:</td>
                    <td class="auto-style9">
                        <asp:Label ID="lblPassport_ser" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Номер паспорту:</td>
                    <td class="auto-style9">
                        <asp:Label ID="lblPassport_num" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Адреса прописки:</td>
                    <td class="auto-style9">
                        <asp:Label ID="lblAddress" runat="server" Font-Bold="True"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style9">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3"><strong>Документи</strong></td>
                    <td class="auto-style2">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3">Отимати документи користувача з реєстру:</td>
                    <td class="auto-style2">Передати документи користувача до реєстру:</td>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:Button ID="btnDownload" runat="server" Text="Завантажити" OnClick="btnDownload_Click" />
                    </td>
                    <td class="auto-style10">
                        <asp:FileUpload ID="FileUpload" runat="server" Width="225px" />
                        <asp:Button ID="btnOK" runat="server" Text="Передати" OnClick="btnOK_Click" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6" colspan="2">
                        <hr />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:Button ID="btnClose" runat="server" Text="Закрити" OnClick="btnClose_Click" />
                    </td>
                    <td class="auto-style10">&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
