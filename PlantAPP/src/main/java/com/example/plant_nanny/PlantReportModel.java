package com.example.plant_nanny;

public class PlantReportModel {

    private int Id;
    private string Name;
    private string Sci_Name;
    private string Region;
    private int Water_Frequency;
    private int Water_Amount;
    private string Fertilizer;
    private string Fert_Description;
    private int Fert_Frequency;
    private int Fert_Amount;


    public PlantReportModel(
        int Id,
        string Name,
        string Sci_Name,
        string Region,
        int Water_Frequency,
        int Water_Amount,
        string Fertilizer,
        string Fert_Description,
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

    public PlantReportModel() {
    }

    @Override
    public String toString() {
        return  common + "genus" + genus +
                " species: " + species +
                " cultivar: " + cultivar +
                " common: " + common;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
