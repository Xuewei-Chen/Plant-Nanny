package com.example.plant_nanny;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlantsDataService {

    public static final String QUERY_FOR_Plant_Name = "https://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=";

    Context context;

    public PlantsDataService(Context context) {
        this.context = context;
    }

    public interface GetPlantInfoByNameResponse{
        void onError(String message);

        void onResponse(List<PlantReportModel> plantReportModels);
    }

    public void getPlantInfoByName(String plantName, GetPlantInfoByNameResponse getPlantInfoByNameResponse){
        List<PlantReportModel> plantReportModels = new ArrayList<>();

        String url = QUERY_FOR_Plant_Name + plantName;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){

                try {
                    JSONArray plant_info_list = response.getJSONArray("plants");

                    for(int i = 0; i < plant_info_list.length(); i++) {

                        PlantReportModel plant_info = new PlantReportModel();
                        JSONObject plant_info_from_api = (JSONObject) plant_info_list.get(i);

                        plant_info.setId(plant_info_from_api.getInt("id"));
                        plant_info.setGenus(plant_info_from_api.getString("genus"));
                        plant_info.setSpecies(plant_info_from_api.getString("species"));
                        plant_info.setCultivar(plant_info_from_api.getString("cultivar"));
                        plant_info.setCommon(plant_info_from_api.getString("common"));


                        plantReportModels.add(plant_info);
                    }


                    getPlantInfoByNameResponse.onResponse(plantReportModels);

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
    }

}
