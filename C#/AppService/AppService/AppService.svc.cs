using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace AppService
{
    // ПРИМЕЧАНИЕ. Команду "Переименовать" в меню "Рефакторинг" можно использовать для одновременного изменения имени класса "Service1" в коде, SVC-файле и файле конфигурации.
    // ПРИМЕЧАНИЕ. Чтобы запустить клиент проверки WCF для тестирования службы, выберите элементы Service1.svc или Service1.svc.cs в обозревателе решений и начните отладку.
    public class AppService : IAppService
    {
        public List<AppUser> GetUsers()
        {
            List<AppUser> lstUsers = new List<AppUser>();
            using (DBModel1 cm = new DBModel1())
            {
                var qResult = (
                    from p in cm.People
                    join a in cm.Address on p.Inn equals a.Inn
                    select new
                    {
                        p.Birthdate,
                        p.Firstname,
                        p.Inn,
                        p.Passport_num,
                        p.Passport_ser,
                        p.Patronymic,
                        p.Surname,
                        a.Address1
                    });
                foreach (var res in qResult)
                {
                    lstUsers.Add(new AppUser()
                    {
                        Address = res.Address1,
                        Birthdate = res.Birthdate,
                        Firstname = res.Firstname,
                        Inn = res.Inn,
                        Passport_num = res.Passport_num,
                        Passport_ser = res.Passport_ser,
                        Patronymic = res.Patronymic,
                        Surname = res.Surname
                    });
                }
                return lstUsers;
            }
        }
        public List<AppUser> GetByFilter(string Filter)
        {
            List<AppUser> lstUsers = new List<AppUser>();
            using (DBModel1 cm = new DBModel1())
            {
                var qResult = (
                    from p in cm.People
                    join a in cm.Address on p.Inn equals a.Inn
                    where p.Surname.Contains(Filter) || p.Inn.Contains(Filter)
                    select new
                    {
                        p.Birthdate,
                        p.Firstname,
                        p.Inn,
                        p.Passport_num,
                        p.Passport_ser,
                        p.Patronymic,
                        p.Surname,
                        a.Address1
                    });
                foreach (var res in qResult)
                {
                    lstUsers.Add(new AppUser()
                    {
                        Address = res.Address1,
                        Birthdate = res.Birthdate,
                        Firstname = res.Firstname,
                        Inn = res.Inn,
                        Passport_num = res.Passport_num,
                        Passport_ser = res.Passport_ser,
                        Patronymic = res.Patronymic,
                        Surname = res.Surname
                    });
                }
            }
            return lstUsers;
        }

        public bool AddUser(AppUser User)
        {
            using (DBModel1 cm = new DBModel1())
            {
                address adr = new address()
                {
                    Address1 = User.Address,
                    Inn = User.Inn
                };
                cm.Address.Add(adr);
                cm.SaveChanges();
                people p = new people()
                {
                    Birthdate = User.Birthdate,
                    Firstname = User.Firstname,
                    Inn = User.Inn,
                    Passport_num = User.Passport_num,
                    Passport_ser = User.Passport_ser,
                    Patronymic = User.Patronymic,
                    Surname = User.Surname
                };
                cm.People.Add(p);
                cm.SaveChanges();
                return true;
            }
        }
        public void UploadDocument(string Inn, File file)
        {
            using (DBModel1 cm = new DBModel1())
            {
                var doc = cm.Documents.FirstOrDefault(f => f.Inn == Inn);
                if (doc != null)
                {
                    cm.Documents.Remove(doc);
                    cm.SaveChanges();
                }
                doc = new documents();
                doc.FileName = file.Name;
                doc.Data = file.Content;
                doc.Inn = Inn;
                cm.Documents.Add(doc);
                cm.SaveChanges();
            }
        }
        public File DownloadDocument(string Inn)
        {
            File file = null;
            using (DBModel1 cm = new DBModel1())
            {
                documents doc = cm.Documents.FirstOrDefault(f => f.Inn == Inn);
                if (doc != null)
                {
                    file = new File() { Name = doc.FileName, Content = doc.Data };
                }
            }
            return file;
        }
    }
}
