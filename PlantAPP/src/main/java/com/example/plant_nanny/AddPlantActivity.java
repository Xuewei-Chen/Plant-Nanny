package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.List;

public class AddPlantActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect with activity.xml
        setContentView(R.layout.activity_customize_add_plant);

        Button BackButton = (Button) this.findViewById(R.id.BackBtn);
        ListView plantsReports = (ListView) this.findViewById(R.id.lv_customizeReports);
        EditText CuzSearch = (EditText) this.findViewById(R.id.CusPlantSearch) ;

        CustomizeDataService customizeDataService = new CustomizeDataService(AddPlantActivity.this);

        CuzSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        customizeDataService.getPlantInfoByName(CuzSearch.getText().toString(), new CustomizeDataService.GetPlantInfoByNameResponse() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(AddPlantActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(List<CustomizeReportModel> customizeReportModels) {
                                //put the entire list into the listview control

                                ArrayAdapter arrayAdapter = new ArrayAdapter(AddPlantActivity.this, android.R.layout.simple_list_item_1, customizeReportModels);
                                plantsReports.setAdapter(arrayAdapter);
                            }
                        });
                    }
                }
        );

        BackButton.setOnClickListener(
                new View.OnClickListener() {
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
