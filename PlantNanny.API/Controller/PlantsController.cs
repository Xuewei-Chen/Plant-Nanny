using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PlantNanny.API.Models;
using PlantNanny.API.Repositories;

namespace PlantNanny.API.Controller
{
    [Route("api/[controller]")] // api/plants
    [ApiController]
    public class PlantsController : ControllerBase
    {
        private readonly IPlantRepository plantRepository;
        public PlantsController(IPlantRepository _plantRepository)
        {
            plantRepository = _plantRepository;
        }

        [HttpGet]
        public async Task<IEnumerable<Plant>> GetPlants()
        {
            return await plantRepository.Get();

        }

        /* 
         * ActionResult return will provide flexibility
         */
        [HttpGet("{id}")]
        public async Task<ActionResult<Plant>> GetPlants(int id)
        {
            return await plantRepository.Get(id);
        }

        [HttpGet("{name}")]
        public async Task<ActionResult<Plant>> GetPlants(string name)
        {
            return await plantRepository.Get(name);
        }


        [HttpPost]
        public async Task<ActionResult<Plant>> PostPlants([FromBody] Plant plant)
        {
            var newPlant = await plantRepository.Create(plant);
            return CreatedAtAction(nameof(GetPlants), new { id = newPlant.Id }, newPlant);
        }

        [HttpPut]
        public async Task<ActionResult> PostPlants(int id, [FromBody] Plant plant)
        {
            if (id != plant.Id)
            {
                return BadRequest();
            }

            await plantRepository.Update(plant);

            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult> Delete(int id)
        {
            var plant_delete = await plantRepository.Get(id);
            if (plant_delete == null)
                return NotFound();

            await plantRepository.Delete(plant_delete.Id);
            return NoContent();
        }
    }
}
