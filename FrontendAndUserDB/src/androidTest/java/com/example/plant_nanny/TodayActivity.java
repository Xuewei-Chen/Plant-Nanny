package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TodayActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_today);

        Button BackButton = (Button) this.findViewById(R.id.BackAccountButton);
        EditText WaterFreq = (EditText) this.findViewById(R.id.Watering_Freq_Edit);
        EditText FertilizeFreq = (EditText) this.findViewById(R.id.Fertilize_Freq_Edit);

        BackButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to schedule page
                        Intent intent = new Intent(TodayActivity.this, ScheduleActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
