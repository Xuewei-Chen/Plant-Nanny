package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ScheduleActivity extends Activity {
    // 调用Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_schedule);
        // 关联按钮
        Button Cur_schedule = (Button) this.findViewById(R.id.Cur_schedule);
        Button Plant_repo = (Button) this.findViewById(R.id.Plant_Repo);
        Button Plant_add = (Button) this.findViewById(R.id.Plant_add);
        Button notes = (Button) this.findViewById(R.id.notes);
        // Cur_schedule按钮监听器
        Cur_schedule.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to today
                        Intent intent_today = new Intent(ScheduleActivity.this, TodayActivity.class);
                        startActivity(intent_today);
                    }
                }
        );
        // Plant_add按钮监听器
        Plant_add.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to add plant
                        Intent intent_add = new Intent(ScheduleActivity.this, AddPlantActivity.class);
                        startActivity(intent_add);
                    }
                }
        );
        // all_plant按钮监听器
        Plant_repo.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // convert to repo
                        Intent intent_repo = new Intent(ScheduleActivity.this, RepoActivity.class);
                        startActivity(intent_repo);
                    }
                }
        );
        //notes按钮监听器
        notes.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent_notes = new Intent(ScheduleActivity.this, SignUpActivity.class);
                        startActivity(intent_notes);
                    }
                }
        );

    }
}
