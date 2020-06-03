using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppClient
{
    public class AppClients
    {
        public static AppGetUsers.AppUser[] GetUsers()
        {
            using (AppGetUsers.AppServiceClient cl = new AppGetUsers.AppServiceClient())
            {
                string sprotocolVersion = "4.0";
                string sid = Guid.NewGuid().ToString();
                string sUserId = "user1";

                AppGetUsers.XRoadServiceIdentifierType service = new AppGetUsers.XRoadServiceIdentifierType
                {
                    objectType = AppGetUsers.XRoadObjectType.SERVICE,
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeService"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppGetUsers"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeService"]
                };

                AppGetUsers.XRoadClientIdentifierType client = new AppGetUsers.XRoadClientIdentifierType
                {
                    objectType = AppGetUsers.XRoadObjectType.SUBSYSTEM,
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeClient"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppGetUsers"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeClient"]
                };

                return cl.GetUsers(ref sprotocolVersion, ref sid, ref sUserId, ref service, ref client);
            }
        }
        public static AppGetByFilter.AppUser[] GetByFilter(string Filter)
        {
            using (AppGetByFilter.AppServiceClient cl = new AppGetByFilter.AppServiceClient())
            {
                string sprotocolVersion = "4.0";
                string sid = Guid.NewGuid().ToString();
                string sUserId = "user1";

                AppGetByFilter.XRoadServiceIdentifierType service = new AppGetByFilter.XRoadServiceIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeService"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppGetByFilter"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeService"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    objectType = AppGetByFilter.XRoadObjectType.SERVICE
                };

                AppGetByFilter.XRoadClientIdentifierType client = new AppGetByFilter.XRoadClientIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeClient"],
                    objectType = AppGetByFilter.XRoadObjectType.SUBSYSTEM,
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppGetByFilter"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeClient"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"]
                };

                return cl.GetByFilter(ref sprotocolVersion, ref sid, ref sUserId, ref service, ref client, Filter);
            }
        }
        public static void AddUser(string Inn, string Surname, string Firstname, string Patronymic, string Passport_ser, string Passport_num, DateTime Birthdate, string Address)
        {
            string sprotocolVersion = "4.0";
            string sid = Guid.NewGuid().ToString();
            string sUserId = "user1";
            using (AppAddUser.AppServiceClient cl = new AppAddUser.AppServiceClient())
            {
                AppAddUser.XRoadServiceIdentifierType service = new AppAddUser.XRoadServiceIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeService"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppAddUser"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeService"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    objectType = AppAddUser.XRoadObjectType.SERVICE
                };

                AppAddUser.XRoadClientIdentifierType client = new AppAddUser.XRoadClientIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeClient"],
                    objectType = AppAddUser.XRoadObjectType.SUBSYSTEM,
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppAddUser"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeClient"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"]
                };

                AppAddUser.AppUser user = new AppAddUser.AppUser()
                {
                    Inn = Inn,
                    Surname = Surname,
                    Firstname = Firstname,
                    Patronymic = Patronymic,
                    Passport_ser = Passport_ser,
                    Passport_num = Passport_num,
                    Address = Address,
                    Birthdate = Birthdate,
                    BirthdateSpecified = true
                };
                cl.AddUser(ref sprotocolVersion, ref sid, ref sUserId, ref service, ref client, user);
            }
        }
        public static void UploadDocument(string inn, string name, byte[] data)
        {
            string sprotocolVersion = "4.0";
            string sid = Guid.NewGuid().ToString();
            string sUserId = "user1";
            using (AppUploadDocument.AppServiceClient cl = new AppUploadDocument.AppServiceClient())
            {
                AppUploadDocument.XRoadServiceIdentifierType service = new AppUploadDocument.XRoadServiceIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeService"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppUploadDocument"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeService"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    objectType = AppUploadDocument.XRoadObjectType.SERVICE
                };

                AppUploadDocument.XRoadClientIdentifierType client = new AppUploadDocument.XRoadClientIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeClient"],
                    objectType = AppUploadDocument.XRoadObjectType.SUBSYSTEM,
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppUploadDocument"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeClient"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"]
                };

                AppUploadDocument.File file = new AppUploadDocument.File() { Name = name, Content = data };

                cl.UploadDocument(ref sprotocolVersion, ref sid, ref sUserId, ref service, ref client, inn, file);
            }
        }
        public static byte[] DownloadDocument(string inn, out string name)
        {
            string sprotocolVersion = "4.0";
            string sid = Guid.NewGuid().ToString();
            string sUserId = "user1";
            using (AppDownloadDocument.AppServiceClient cl = new AppDownloadDocument.AppServiceClient())
            {
                AppDownloadDocument.XRoadServiceIdentifierType service = new AppDownloadDocument.XRoadServiceIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeService"],
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppDownloadDocument"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeService"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"],
                    objectType = AppDownloadDocument.XRoadObjectType.SERVICE
                };

                AppDownloadDocument.XRoadClientIdentifierType client = new AppDownloadDocument.XRoadClientIdentifierType
                {
                    memberClass = System.Configuration.ConfigurationManager.AppSettings["memberClass"],
                    memberCode = System.Configuration.ConfigurationManager.AppSettings["memberCodeClient"],
                    objectType = AppDownloadDocument.XRoadObjectType.SUBSYSTEM,
                    serviceCode = System.Configuration.ConfigurationManager.AppSettings["serviceCodeAppDownloadDocument"],
                    subsystemCode = System.Configuration.ConfigurationManager.AppSettings["subsystemCodeClient"],
                    xRoadInstance = System.Configuration.ConfigurationManager.AppSettings["xRoadInstance"]
                };
                AppDownloadDocument.File file = cl.DownloadDocument(ref sprotocolVersion, ref sid, ref sUserId, ref service, ref client, inn);

                if (file != null)
                {
                    name = file.Name;
                    return file.Content;
                }
                else
                {
                    name = null;
                }
                return null;

            }
        }
    }
}
