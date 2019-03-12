package com.example.loginv1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginv1.R;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private static final int READ_BLOCK_SIZE = 100;
    private EditText userid, password;
    private Button Login;
    private FirebaseAuth mauth;
    public int counter = 3, flag = 0;
    int Stor_permission = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password1);
        Login = findViewById(R.id.login);
        mauth = FirebaseAuth.getInstance();


        TextView textview = findViewById(R.id.SignupLink);
        String text = "Not a Member yet? Signup now";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View V) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        };


        ss.setSpan(clickableSpan1, 17, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(ss);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(LoginActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    String user = userid.getText().toString();
                    String pass = password.getText().toString();
                    if (user.isEmpty() || pass.isEmpty()) {
                        showMessage("please enter valid userid and password");
                    } else
                        readDataByColumn(user, pass);

                } else {
                    requestStoragePermissions();
                    String user = userid.getText().toString();
                    String pass = password.getText().toString();
                    if (user.isEmpty() || pass.isEmpty()) {
                        showMessage("please enter valid userid and password");
                    } else
                        readDataByColumn(user, pass);

                }
            }


        });

    }

    private void requestStoragePermissions() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("permission needed").setMessage("Storage permission needed")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        } else
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Stor_permission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Stor_permission) {
            if (grantResults.length > 0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
                showMessage("permission Granted");

            } else {
                showMessage("permission Denied");
            }
        }
    }


    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


    private void readDataByColumn(String user, String pass) {


        File root = Environment.getExternalStorageDirectory();
        File file = new File(root, "mydata.txt");
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                // If buffer is not empty
                while ((line = br.readLine()) != null) {

                    String[] cols = line.split(",");


                    if (user.equals(cols[4]) && pass.equals(cols[5])) {
                        showMessage("login succesful");
                        Intent i = new Intent(LoginActivity.this, UserDataActivity.class);
                        startActivity(i);
                        flag = 1;
                    }

                    //PRINT IN CONSOLE
                    System.out.println("Column 0 = '" + cols[0] + "', Column 1 = '" + cols[1] + "', Column 2: '" + cols[2] + "'," + "Column 3='" + cols[3] + "', Column 4 = " + cols[4] + ", Column 5 = " + cols[5]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (flag == 0) {
                counter--;
                showMessage("username or password  incorrect\n number of attempt remaing:" + counter);

                if (counter == 0) {
                    finish();
                    moveTaskToBack(true);
                }
            }
        } else {
            showMessage("there is no users in file, create new users");

        }
    }
}





