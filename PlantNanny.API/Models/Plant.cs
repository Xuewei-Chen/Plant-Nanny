namespace PlantNanny.API.Models
{
    public class Plant
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Sci_Name { get; set; }
        public string Region { get; set; }
        public int Water_Frequency { get; set; }
        public int Water_Amount { get; set; }
        public string Fertilizer { get; set; }
        public string Fert_Description { get; set; }
        public int Fert_Frequency { get; set; }
        public int Fert_Amount { get; set; }

    }
}
