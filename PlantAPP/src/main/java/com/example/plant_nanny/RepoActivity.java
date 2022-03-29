package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RepoActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_repo);
        // 关联按钮
        Button back = (Button) this.findViewById(R.id.RepoBackButton);
        EditText rose = (EditText) this.findViewById(R.id.Var1);
        EditText daisy = (EditText) this.findViewById(R.id.Var2);
        EditText orchid = (EditText) this.findViewById(R.id.Var3);

        back.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // convert to today
                        Intent intent_RepoBack = new Intent(RepoActivity.this, ScheduleActivity.class);
                        startActivity(intent_RepoBack);
                    }
                }
        );
    }
}
