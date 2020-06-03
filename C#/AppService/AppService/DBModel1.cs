namespace AppService
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class DBModel1 : DbContext
    {
        public DBModel1()
            : base("name=DBModel1")
        {
        }

        public virtual DbSet<address> Address { get; set; }
        public virtual DbSet<people> People { get; set; }
        public virtual DbSet<documents> Documents { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
        }
    }
}
