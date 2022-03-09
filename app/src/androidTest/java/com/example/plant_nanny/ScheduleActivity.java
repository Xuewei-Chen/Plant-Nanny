package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ScheduleActivity extends Activity {
    // 调用Actvity
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
                        // 跳转到注册界面
                        Intent intent = new Intent(ScheduleActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
        // Plant_add按钮监听器
        Plant_add.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(ScheduleActivity.this, AddPlantActivity.class);
                        startActivity(intent);
                    }
                }
        );
        // all_plant按钮监听器
        Plant_repo.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(ScheduleActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
        //notes按钮监听器
        notes.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(ScheduleActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
