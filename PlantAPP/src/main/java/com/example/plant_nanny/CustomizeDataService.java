package com.example.plant_nanny;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomizeDataService {

    public static final String QUERY_FOR_Plant_Name = "https://plantnannyapi20220329180847.azurewebsites.net/api/Plants/byName?name=";

    Context context;

    public CustomizeDataService(Context context) {
        this.context = context;
    }

    public interface GetPlantInfoByNameResponse{
        void onError(String message);

        void onResponse(List<CustomizeReportModel> customizeReportModels);
    }

    public void getPlantInfoByName(String plantName, GetPlantInfoByNameResponse getPlantInfoByNameResponse){
        List<CustomizeReportModel> customizeReportModels = new ArrayList<>();

        String url = QUERY_FOR_Plant_Name + plantName;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){

                try {
                    JSONObject plant_info_list = response.getJSONObject(0);
                    JSONObject plant_info_from_api = (JSONObject) plant_info_list;
                    CustomizeReportModel plants_info = new CustomizeReportModel();

                    plants_info.setName(plant_info_from_api.getString("name"));
                    plants_info.setId(plant_info_from_api.getInt("id"));
                    plants_info.setName(plant_info_from_api.getString("name"));
                    plants_info.setSci_Name(plant_info_from_api.getString("sci_Name"));
                    plants_info.setRegion(plant_info_from_api.getString("region"));
                    plants_info.setWater_Frequency(plant_info_from_api.getInt("water_Frequency"));
                    plants_info.setWater_Amount(plant_info_from_api.getInt("water_Amount"));
                    plants_info.setFertilizer(plant_info_from_api.getString("fertilizer"));
                    plants_info.setFert_Description(plant_info_from_api.getString("fert_Description"));
                    plants_info.setFert_Frequency(plant_info_from_api.getInt("fert_Frequency"));
                    plants_info.setFert_Amount(plant_info_from_api.getInt("fert_Amount"));
                    customizeReportModels.add(plants_info);

                    getPlantInfoByNameResponse.onResponse(customizeReportModels);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
        //return a NULL. problem!
        //return cityID;
    }

}
