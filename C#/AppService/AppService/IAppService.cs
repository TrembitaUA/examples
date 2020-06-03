
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
namespace AppService
{
    [ServiceContract]
    public interface IAppService
    {
        [OperationContract]
        List<AppUser> GetUsers();
        [OperationContract]
        List<AppUser> GetByFilter(string Filter);
        [OperationContract]
        bool AddUser(AppUser User);
        [OperationContract]
        void UploadDocument(string Inn, File file);
        [OperationContract]
        File DownloadDocument(String Inn);
    }
    [DataContract]
    public class AppUser
    {
        [DataMember]
        public string Inn { get; set; }
        [DataMember]
        public string Surname { get; set; }
        [DataMember]
        public string Firstname { get; set; }
        [DataMember]
        public string Patronymic { get; set; }
        [DataMember]
        public DateTime? Birthdate { get; set; }
        [DataMember]
        public string Passport_ser { get; set; }
        [DataMember]
        public string Passport_num { get; set; }
        [DataMember]
        public string Address { get; set; }
    }

    [DataContract]
    public class File
    {
        [DataMember]
        public string Name { get; set; }
        [DataMember]
        public byte[] Content { get; set; }
    }

}
