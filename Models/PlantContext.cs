using Microsoft.EntityFrameworkCore;

namespace PlantNanny.API.Models
{
    public class PlantContext : DbContext
    {
        public PlantContext(DbContextOptions<PlantContext> options) : base(options)
        {
            Database.EnsureCreated();
        }

        public DbSet<Plant> Plants { get; set; }
    }
}
