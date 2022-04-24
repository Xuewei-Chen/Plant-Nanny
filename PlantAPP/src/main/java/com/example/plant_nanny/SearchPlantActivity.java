package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

import java.util.List;

public class SearchPlantActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_add_plant);

        Button BackButton = (Button) this.findViewById(R.id.BackButton);
        ListView plantReports = (ListView) this.findViewById(R.id.lv_plantReports);
        EditText PlantSearch = (EditText) this.findViewById(R.id.PlantSearch) ;

        PlantsDataService plantsDataService = new PlantsDataService(SearchPlantActivity.this);

        PlantSearch.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        plantsDataService.getPlantInfoByName(PlantSearch.getText().toString(), new PlantsDataService.GetPlantInfoByNameResponse() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(SearchPlantActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(List<PlantReportModel> plantReportModels) {
                                //put the entire list into the listview control

                                ArrayAdapter arrayAdapter = new ArrayAdapter(SearchPlantActivity.this, android.R.layout.simple_list_item_1, plantReportModels);
                                plantReports.setAdapter(arrayAdapter);
                            }
                        });
                    }
                }
        );

        BackButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to schedule page
                        Intent intent = new Intent(SearchPlantActivity.this, ScheduleActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }
}
