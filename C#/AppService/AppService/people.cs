namespace AppService
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class people
    {
        [Key]
        [StringLength(10)]
        public string Inn { get; set; }

        [StringLength(64)]
        public string Surname { get; set; }

        [StringLength(64)]
        public string Firstname { get; set; }

        [StringLength(64)]
        public string Patronymic { get; set; }

        [Column(TypeName = "date")]
        public DateTime? Birthdate { get; set; }

        [StringLength(5)]
        public string Passport_ser { get; set; }

        [StringLength(10)]
        public string Passport_num { get; set; }
    }
}
