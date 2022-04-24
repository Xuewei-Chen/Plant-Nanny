package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SearchPlantActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_add_plant_form);

        Button BackButton = (Button) this.findViewById(R.id.BackButton);
//        EditText region = (EditText) this.findViewById(R.id.Region);
//        EditText WaterFreq = (EditText) this.findViewById(R.id.Water);
//        EditText FertilizeFreq = (EditText) this.findViewById(R.id.Fertilize);

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
