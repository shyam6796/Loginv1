package com.example.loginv1.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.loginv1.R;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SignupActivity extends AppCompatActivity {
    private EditText Firstname, Lastname, Email, Age, Username, Password, ConfirmPassword;
    private Button cancel, save;
    private FirebaseAuth mauth;
    int number = 0;
    boolean a;
    int Stor_permission = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Firstname = findViewById(R.id.FirstName);
        Lastname = findViewById(R.id.LastName);
        Email = findViewById(R.id.Email);
        Username = findViewById(R.id.userid1);
        Age = findViewById(R.id.Age);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.ConfirmPassword);

        cancel = findViewById(R.id.Cancel);
        save = findViewById(R.id.Save);
        mauth = FirebaseAuth.getInstance();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname = Firstname.getText().toString();
                final String lastname = Lastname.getText().toString();
                final String username = Username.getText().toString();
                final String email = Email.getText().toString();
                String age = Age.getText().toString();
                final String password = Password.getText().toString();
                final String confirmPassword = ConfirmPassword.getText().toString();
                try {
                    number = Integer.parseInt(Age.getText().toString());
                } catch (NumberFormatException e) {
                    showMessage(e.toString());
                }


                if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || email.isEmpty() || age.isEmpty() || password.isEmpty()) {

                    showMessage("please enetr  All  valid fields");
                } else if (firstname.isEmpty()) {

                    showMessage("please enter first name");


                } else if (lastname.isEmpty()) {
                    showMessage("please enter last name");


                } else if (email.isEmpty()) {
                    showMessage("please enter email id");

                } else if (a == isEmailValid(email)) {
                    showMessage("please enter  valid email id");

                } else if (username.isEmpty()) {
                    showMessage("please enter   userid");
                } else if (username.length() < 8) {
                    showMessage("please enter valid  userid of 8 characters");
                } else if (age.isEmpty()) {
                    showMessage("please enter valid age");
                } else if (number < 1) {
                    showMessage("please enter valid age between 1 to 99");
                } else if (number > 99) {
                    showMessage("please enter valid age between 1 to 99");
                } else if (password.isEmpty()) {
                    showMessage("please enter valid password of length 8");
                } else if (password.length() < 8) {
                    showMessage("please enter valid password of length 8");
                } else if (!password.equals(confirmPassword)) {
                    Password.setText("");
                    ConfirmPassword.setText("");
                    showMessage("please enter both password same");
                } else {
                    /* showMessage("All filed are valid");*/
                    writeDataByColumn(firstname, lastname, age, email, username, password);
                }
            }
        });


    }


    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }

    private void writeDataByColumn(String f_name, String l_name, String age, String email, String user, String pass) {

        if (ContextCompat.checkSelfPermission(SignupActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            try {
                FileWriter writer;
                String line = String.format("%s,%s,%s,%s,%s,%s\n", f_name, l_name, age, email, user, pass);
                //DATA WILL BE STORED AS FIRSTNAME,LASTNAME,AGE,EMAIL,USERID,PASSWORD IN A LINE
                File root = Environment.getExternalStorageDirectory();
                //FILE SAVE IN ITERNAL STORAGE OUTISDE IN MAIN DIRCT
                File file = new File(root, "mydata.txt");
                if (file.exists()) {
                    BufferedWriter bw =
                            new BufferedWriter(new FileWriter(file, true));
                    bw.append(line);
                    bw.flush();
                    System.out.println("done well");
                    showMessage("user created");
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                } else {
                    writer = new FileWriter(file);
                   /* String line1 = String.format("Fisrtname,Lastname,age,email,userid,password\n");
                    writer.append(line1);*/
                    writer.append(line);
                    writer.flush();
                    writer.close();
                    System.out.println("done");
                    showMessage("user created");
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            requestStoragePermissions();
            try {
                FileWriter writer;
                String line = String.format("%s,%s,%s,%s,%s,%s\n", f_name, l_name, age, email, user, pass);
                //DATA WILL BE STORED AS FIRSTNAME,LASTNAME,AGE,EMAIL,USERID,PASSWORD IN A LINE
                File root = Environment.getExternalStorageDirectory();
                //FILE SAVE IN ITERNAL STORAGE OUTISDE IN MAIN DIRCT
                File file = new File(root, "mydata.txt");
                if (file.exists()) {
                    BufferedWriter bw =
                            new BufferedWriter(new FileWriter(file, true));
                    bw.append(line);
                    bw.flush();
                    System.out.println("done well");
                    showMessage("user created");
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                } else {
                    writer = new FileWriter(file);
                   /* String line1 = String.format("Fisrtname,Lastname,age,email,userid,password\n");
                    writer.append(line1);*/
                    writer.append(line);
                    writer.flush();
                    writer.close();
                    System.out.println("done");
                    showMessage("user created");
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

    private void requestStoragePermissions() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
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
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Stor_permission);
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
}



