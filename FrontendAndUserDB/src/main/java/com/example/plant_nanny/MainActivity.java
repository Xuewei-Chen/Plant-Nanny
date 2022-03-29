package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {

    DBHelper db_user;

    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_main);
        // 关联用户名、密码和登录、注册按钮
        EditText username = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText password = (EditText) this.findViewById(R.id.PassWordEdit);
        Button signInButton = (Button) this.findViewById(R.id.LoginButton);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        db_user = new DBHelper(this);

        // 登录按钮监听器
        signInButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 获取用户名和密码

                        String strUserName = username.getText().toString().trim();
                        String strPassWord = password.getText().toString().trim();



                        // 判断如果用户名为"123456"密码为"123456"则登录成功
                        if (TextUtils.isEmpty(strUserName) || TextUtils.isEmpty(strPassWord)) {
                            Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                        } else {
                            Boolean checkuserpass = db_user.checkUsernamePassword(strUserName, strPassWord);
                            if(checkuserpass == true){

                                Toast.makeText(MainActivity.this, "Successful！", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
