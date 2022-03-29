package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

import java.util.List;

public class AddPlantActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_add_plant);

        Button BackButton = (Button) this.findViewById(R.id.BackButton);
        Button AddButton = (Button) this.findViewById(R.id.AddButton);
        ListView plantReports = (ListView) this.findViewById(R.id.lv_plantReports);
        EditText PlantSearch = (EditText) this.findViewById(R.id.PlantSearch) ;

        PlantDataService plantDataService = new PlantDataService(AddPlantActivity.this);

        PlantSearch.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        plantDataService.getCityForecastByName(PlantSearch.getText().toString(), new PlantDataService.GetCityForecastByNameCallBack() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(AddPlantActivity.this, "something wrong", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onResponse(List<WeatherReportModel> weatherReportModels) {
                                //put the entire list into the listview control

                                ArrayAdapter arrayAdapter = new ArrayAdapter(AddPlantActivity.this, android.R.layout.simple_list_item_1, weatherReportModels);
                                plantReports.setAdapter(arrayAdapter);
                            }
                        });
//                        RequestQueue queue = Volley.newRequestQueue(AddPlantActivity.this);
//                        String url ="https://www.metaweather.com/api/location/search/?query=" + PlantSearch.getText().toString();
//
//                        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
//                            @Override
//                            public void onResponse(JSONArray response){
//                                String cityID = "";
//
//                                try {
//                                    JSONObject cityInfo = response.getJSONObject(0);
//                                    cityID = cityInfo.getString("woeid");
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                                Toast.makeText(AddPlantActivity.this, "City ID" + cityID, Toast.LENGTH_SHORT).show();
//
//                            }
//                        }, new Response.ErrorListener(){
//                            @Override
//                            public void onErrorResponse(VolleyError error){
//                                Toast.makeText(AddPlantActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        MySingleton.getInstance(AddPlantActivity.this).addToRequestQueue(request);
                        //queue.add(request);

//                        // Request a string response from the provided URL.
//                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(ScheduleActivity.this, response, Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                Toast.makeText(ScheduleActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        //Add the request to the RequestQueue
//                        queue.add(stringRequest);
                    }
                }
        );

        BackButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to schedule page
                        Intent intent = new Intent(AddPlantActivity.this, ScheduleActivity.class);
                        startActivity(intent);
                    }
                }
        );
        AddButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // convert to schedule page
                       Intent intent = new Intent(AddPlantActivity.this, ScheduleActivity.class);
                       startActivity(intent);
                    }
                }
        );

    }
}
