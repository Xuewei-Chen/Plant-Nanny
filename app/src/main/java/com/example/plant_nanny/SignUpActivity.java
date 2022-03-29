package com.example.plant_nanny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
    DBHelper db_user;
    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联activity_register.xml
        setContentView(R.layout.activity_sign_up);
        // 关联用户名、密码、确认密码、邮箱和注册、返回登录按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        EditText passWordAgain = (EditText) this.findViewById(R.id.PassWordAgainEdit);
        EditText email = (EditText) this.findViewById(R.id.EmailEdit);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        Button backLoginButton = (Button) this.findViewById(R.id.BackLoginButton);

        db_user = new DBHelper(this);

        // 立即注册按钮监听器
        signUpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();
                        String strPassWordAgain = passWordAgain.getText().toString().trim();
                        String strPhoneNumber = email.getText().toString().trim();

                        //check if fields are empty or not, if it empty show Toast message Else checkUsername, if it is
                        //false insert data else registration failed
                        //if checkUsername true, Toast user Already exist
                        if(TextUtils.isEmpty(strUserName) || TextUtils.isEmpty(strPassWord)){
                            Toast.makeText(SignUpActivity.this,"All fields Required", Toast.LENGTH_SHORT).show();
                        }else{
                            if(strPassWord.equals(strPassWordAgain)){
                                Boolean checkuser = db_user.checkUsername(strUserName);
                                if(checkuser == false){
                                    Boolean insert = db_user.insertData(strUserName, strPassWord);
                                    if(insert == true){
                                        Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignUpActivity.this, ScheduleActivity.class);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(SignUpActivity.this, "User already Exists", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(SignUpActivity.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                }
        );
        // 返回登录按钮监听器
        backLoginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到登录界面
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
