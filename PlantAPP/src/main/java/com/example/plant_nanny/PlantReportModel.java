package com.example.plant_nanny;

public class PlantReportModel {

    private int Id;
    private String Name;
    private String Sci_Name;
    private String Region;
    private int Water_Frequency;
    private int Water_Amount;
    private String Fertilizer;
    private String Fert_Description;
    private int Fert_Frequency;
    private int Fert_Amount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSci_Name() {
        return Sci_Name;
    }

    public void setSci_Name(String sci_Name) {
        Sci_Name = sci_Name;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getWater_Frequency() {
        return Water_Frequency;
    }

    public void setWater_Frequency(int water_Frequency) {
        Water_Frequency = water_Frequency;
    }

    public int getWater_Amount() {
        return Water_Amount;
    }

    public void setWater_Amount(int water_Amount) {
        Water_Amount = water_Amount;
    }

    public String getFertilizer() {
        return Fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        Fertilizer = fertilizer;
    }

    public String getFert_Description() {
        return Fert_Description;
    }

    public void setFert_Description(String fert_Description) {
        Fert_Description = fert_Description;
    }

    public int getFert_Frequency() {
        return Fert_Frequency;
    }

    public void setFert_Frequency(int fert_Frequency) {
        Fert_Frequency = fert_Frequency;
    }

    public int getFert_Amount() {
        return Fert_Amount;
    }

    public void setFert_Amount(int fert_Amount) {
        Fert_Amount = fert_Amount;
    }

    public PlantReportModel(
            int Id,
            String Name,
            String Sci_Name,
            String Region,
            int Water_Frequency,
            int Water_Amount,
            String Fertilizer,
            String Fert_Description,
            int Fert_Frequency,
            int Fert_Amount)
    {
        this.Id = Id;
        this.Name = Name;
        this.Sci_Name = Sci_Name;
        this.Region = Region;
        this.Water_Frequency = Water_Frequency;
        this.Water_Amount = Water_Amount;
        this.Fertilizer = Fertilizer;
        this.Fert_Description = Fert_Description;
        this.Fert_Frequency = Fert_Frequency;
        this.Fert_Amount = Fert_Amount;
    }

    public PlantReportModel() {}

    @Override
    public String toString() {
        String str = "Id: " + Id;
        str += "\nname: " + Name;
        str += "\nSci_Name: " + Sci_Name;
        str += "\nRegion: " + Region;
        str += "\nWater Frequency: " + Water_Frequency;
        str += "\nWater Amount: " + Water_Amount;
        str += "\nFertilizer: " + Fertilizer;
        str += "\nFertilizer Description: " + Fert_Description;
        str += "\nFertilizer Frequency: " + Fert_Frequency;
        str += "\nFertilizer Amount: " + Fert_Amount;

        return str;
    }
}
