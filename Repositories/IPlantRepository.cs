using PlantNanny.API.Models;

namespace PlantNanny.API.Repositories
{
    /*
     * Operations that can be perform on the database
     */ 
    public interface IPlantRepository
    {
        Task<IEnumerable<Plant>> Get();
        /* Getter functions */
        //Task<Plant> Get(Plant plant);
        Task<Plant> GetbyID(int Id);
        //Task<IEnumerable<Plant>> GetbyID(int Id);
        Task<IEnumerable<Plant>> GetbyName(string Name);
        Task<IEnumerable<Plant>> GetbySciName(string Sci_Name);
        Task<IEnumerable<Plant>> GetbyRegion(string Region);
        Task<IEnumerable<Plant>> GetbyName_Region(string _Name, string _Region);
        Task<IEnumerable<Plant>> GetbySciName_Region(string _SciName, string _Region);
        Task<IEnumerable<Plant>> GetbySearch(string? _Name, string? _SciName, string? _Region);



        Task<Plant> Create(Plant plant);
        Task Update(Plant plant);
        Task Delete(int Id);

    }
}
