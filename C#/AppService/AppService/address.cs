namespace AppService
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("address")]
    public partial class address
    {
        [Key]
        [StringLength(10)]
        public string Inn { get; set; }

        [Column("Address")]
        [StringLength(128)]
        public string Address1 { get; set; }
    }
}
