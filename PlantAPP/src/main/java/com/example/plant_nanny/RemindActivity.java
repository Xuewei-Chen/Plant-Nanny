package com.example.plant_nanny;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RemindActivity extends Activity implements View.OnClickListener{

    private  int notificationId = 1;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat Hour = new SimpleDateFormat("hh");
    SimpleDateFormat Min = new SimpleDateFormat("mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // connect with activity.xml
        setContentView(R.layout.activity_add_plant_form);
        //connect with the button
        findViewById(R.id.setBtn).setOnClickListener((OnClickListener) this);
        findViewById(R.id.cancelBtn).setOnClickListener((OnClickListener) this);
        createNotificationChannel();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view){


        EditText remind = (EditText) this.findViewById(R.id.SetReminds);
        TimePicker timePicker = findViewById(R.id.timePicker);

        //set notificationId & text
        Intent intent = new Intent(RemindActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", remind.getText().toString());

        //getBroadcast(context, requestCode, intent, flags)
        PendingIntent alarmIntent = PendingIntent.getBroadcast(RemindActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        @SuppressLint("ServiceCast") AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch(view.getId()){
            case R.id.setBtn:
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();;

                //Create time
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "RReminderChannel";
            String description = "Channel for alarm manager";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("R", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
