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
            var plant_delete = await plantRepository.GetbyID(id);
            if (plant_delete == null)
                return NotFound();

            await plantRepository.Delete(plant_delete.Id);
            return NoContent();
        }


        /* HTTP Gets methods */

        [HttpGet]
        public async Task<IEnumerable<Plant>> GetPlants()
        {
            return await plantRepository.Get();
        }

        /* 
         * ActionResult return will provide flexibility
         */
        [HttpGet("byID")]
        public async Task<ActionResult<IEnumerable<Plant>>> GetById([FromQuery] int id)
        {
            return Ok(await plantRepository.GetbyID(id));
        }

      
        [HttpGet("byName")]
        public async Task<ActionResult<IEnumerable<Plant>>> GetByName([FromQuery] string name)
        {
            return Ok(await plantRepository.GetbyName(name));
        }

        [HttpGet("bySciname")]
        public async Task<ActionResult<IEnumerable<Plant>>> GetBySciName([FromQuery] string sci_name)
        {
            return Ok(await plantRepository.GetbySciName(sci_name));
        }

        [HttpGet("byRegion")]
        public async Task<ActionResult<IEnumerable<Plant>>> GetByRegion([FromQuery] string region)
        {
            return Ok(await plantRepository.GetbyRegion(region));
        }

        [HttpGet("search")]
        public async Task<ActionResult<IEnumerable<Plant>>> GetBySearch(string? name = null, string? sciname = null, string? region = null)
        {
            return Ok(await plantRepository.GetbySearch(name, sciname, region));
        }


    }
}
