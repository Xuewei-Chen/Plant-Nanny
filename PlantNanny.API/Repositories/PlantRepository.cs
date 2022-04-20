using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PlantNanny.API.Models;

namespace PlantNanny.API.Repositories
{
    public class PlantRepository : IPlantRepository
    {
        private readonly PlantContext context;
        public PlantRepository(PlantContext _context)
        {
            context = _context;
        }

        public async Task<Plant> Create(Plant plant)
        {
            context.Plants.Add(plant);
            await context.SaveChangesAsync();

            return plant;
        }

        public async Task Delete(int Id)
        {
            var plant_delete = await context.Plants.FindAsync(Id);
            if(plant_delete != null)
                context.Plants.Remove(plant_delete);
            await context.SaveChangesAsync();
        }

        public async Task Update(Plant plant)
        {
            context.Entry(plant).State = EntityState.Modified;
            await context.SaveChangesAsync();
        }


        // Returns all plants from database
        public async Task<IEnumerable<Plant>> Get()
        {
            return await context.Plants.ToListAsync();
        }

        // Returns all plants with matching Id
        public async Task<Plant> GetbyID(int _Id)
        {
            return await context.Plants.FindAsync(_Id);
        }

        // Returns all plants with matching Name
        public async Task<IEnumerable<Plant>> GetbyName(string _Name)
        {
            return await context.Plants.Where(c => c.Name.ToLower().Contains(_Name.ToLower())).ToListAsync();
        }

        // Returns all plants with matching Scientific Name
        public async Task<IEnumerable<Plant>> GetbySciName(string _SciName)
        {
            return await context.Plants.Where(c => c.Sci_Name.ToLower().Contains(_SciName.ToLower())).ToListAsync();
        }

        // Returns all plants with matching Region
        public async Task<IEnumerable<Plant>> GetbyRegion(string _Region)
        {
            return await context.Plants.Where(c => c.Region.ToLower().Contains(_Region.ToLower())).ToListAsync();
        }

        // Returns all plants with matching Name AND Region
        public async Task<IEnumerable<Plant>> GetbyName_Region(string _Name, string _Region)
        {
            return await context.Plants.Where(c => c.Region.ToLower().Contains(_Region.ToLower())
            && c.Name.ToLower().Contains(_Name.ToLower())).ToListAsync();
        }

        // Returns all plants with matching Scientific Name AND Region
        public async Task<IEnumerable<Plant>> GetbySciName_Region(string _SciName, string _Region)
        {
            return await context.Plants.Where(c => c.Region.ToLower().Contains(_Region.ToLower())
            && c.Sci_Name.ToLower().Contains(_SciName.ToLower())).ToListAsync();
        }

        public async Task<IEnumerable<Plant>> GetbySearch(string? _Name = null, string? _SciName = null, string? _Region = null)
        {
            if (string.IsNullOrWhiteSpace(_Name) && string.IsNullOrWhiteSpace(_SciName) && string.IsNullOrWhiteSpace(_Region))
            {
                return await Get();
            }

            else if (!string.IsNullOrWhiteSpace(_Name) && !string.IsNullOrWhiteSpace(_SciName) && string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c =>
                c.Name.ToLower().Contains(_Name.ToLower()) &&
                c.Sci_Name.ToLower().Contains(_SciName.ToLower())).ToListAsync();
            }

            else if (!string.IsNullOrWhiteSpace(_Name) && string.IsNullOrWhiteSpace(_SciName) && !string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c =>
                c.Name.ToLower().Contains(_Name.ToLower()) &&
                c.Region.ToLower().Contains(_Region.ToLower())).ToListAsync();
            }

            else if (string.IsNullOrWhiteSpace(_Name) && !string.IsNullOrWhiteSpace(_SciName) && !string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c =>
                c.Region.ToLower().Contains(_Region.ToLower()) &&
                c.Sci_Name.ToLower().Contains(_SciName.ToLower())).ToListAsync();
            }

            else if (!string.IsNullOrWhiteSpace(_Name) && string.IsNullOrWhiteSpace(_SciName) && string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c => c.Name.ToLower().Contains(_Name.ToLower())).ToListAsync();
            }

            else if (string.IsNullOrWhiteSpace(_Name) && !string.IsNullOrWhiteSpace(_SciName) && string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c => c.Sci_Name.ToLower().Contains(_SciName.ToLower())).ToListAsync();
            }

            else if (string.IsNullOrWhiteSpace(_Name) && string.IsNullOrWhiteSpace(_SciName) && !string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c => c.Region.ToLower().Contains(_Region.ToLower())).ToListAsync();
            }
            
            else // if (!string.IsNullOrWhiteSpace(_Name) && !string.IsNullOrWhiteSpace(_SciName) && !string.IsNullOrWhiteSpace(_Region))
            {
                return await context.Plants.Where(c =>
                c.Name.ToLower().Contains(_Name.ToLower()) &&
                c.Sci_Name.ToLower().Contains(_SciName.ToLower()) &&
                c.Region.ToLower().Contains(_Region.ToLower())).ToListAsync();
            }
        }
    }
}
