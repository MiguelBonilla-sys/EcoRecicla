package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Models.Users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class RegisterLog extends AppCompatActivity {
    private static final String USER_DATA_FILE = "userData.txt";

    Button register, backbtn;
    EditText name, email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_log);
        register=findViewById(R.id.RegisterButton);
        name=findViewById(R.id.editTextText3);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass= findViewById(R.id.editTextTextPassword2);
        backbtn=findViewById(R.id.backInicio);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RegisterLog.this, mainApp.class);
                startActivity(intent2);
            }
        });

        Intent login= new Intent(this, loginApp.class);

        register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!name.getText().toString().isEmpty() &&
                    !email.getText().toString().isEmpty() &&
                    !pass.getText().toString().isEmpty()){
                if(checkUser(email.getText().toString(),name.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Este usuario ya esta registrado",Toast.LENGTH_LONG).show();
                } else{
                    Users users= new Users(
                            name.getText().toString(),
                            email.getText().toString(),
                            pass.getText().toString() );

                    saveUser(users);
                    Toast.makeText(getApplicationContext(), "Ya fue registrado", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(login);
                        }
                    }, 5000);
                }
            }else{
                Toast.makeText(getApplicationContext(), "Diligencie todos los campos", Toast.LENGTH_LONG).show();
            }
        }
    });

    }

    public void saveUser(Users users){
        try{
            FileOutputStream fos = openFileOutput(USER_DATA_FILE, MODE_APPEND);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(users.getName()+ ","+ users.getEmail() + "," + users.getPassword());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkUser (String email, String user){
        File file = new File(getFilesDir(), "user.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            List<String> emailList = new ArrayList<>();
            List<String> passwordList= new ArrayList<>();
            while((line =bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                emailList.add(data[1]);
                passwordList.add(data[2]);
            }

            return emailList.contains(email) || passwordList.contains(user) ;

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}