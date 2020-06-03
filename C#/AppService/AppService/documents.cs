namespace AppService
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class documents
    {
        [Key]
        [StringLength(10)]
        public string Inn { get; set; }

        [StringLength(50)]
        public string FileName { get; set; }

        public byte[] Data { get; set; }
    }
}
