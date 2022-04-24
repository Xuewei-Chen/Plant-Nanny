package com.example.plant_nanny;

public class CustomizeReportModel {

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

    public CustomizeReportModel(int id, String name, String sci_Name, String region, int water_Frequency, int water_Amount, String fertilizer, String fert_Description, int fert_Frequency, int fert_Amount) {
        Id = id;
        Name = name;
        Sci_Name = sci_Name;
        Region = region;
        Water_Frequency = water_Frequency;
        Water_Amount = water_Amount;
        Fertilizer = fertilizer;
        Fert_Description = fert_Description;
        Fert_Frequency = fert_Frequency;
        Fert_Amount = fert_Amount;
    }

    public CustomizeReportModel(){
    }

    @Override
    public String toString() {
        return  "Name" + Name + "Science Name" + Sci_Name +
                " Region: " + Region +
                " Water Frequency: " + Water_Frequency +
                " Water Amount: " + Water_Amount+
                " Fertilizer: " + Fertilizer+
                " Fertilize Description: " + Fert_Description+
                " Fertilize Frequency: " + Fert_Frequency+
                " Fertilize Amount: " + Fert_Amount;
    }

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
}
