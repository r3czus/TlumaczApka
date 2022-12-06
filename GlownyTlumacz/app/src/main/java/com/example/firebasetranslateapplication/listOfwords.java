package com.example.firebasetranslateapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class listOfwords extends AppCompatActivity {

    Button  btnLoad;

    TextView tvLoad;
    // Define some String variables, initialized with empty string
    String filename = "";
    String filepath = "";
    String fileContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ofwords);
        filename = "myFile.txt";
        filepath = "MyFileDir";
        tvLoad= findViewById(R.id.tvOutput);
        fileContent = "szybko";


        FileReader fr = null;
        File myExternalFile = new File(getExternalFilesDir(filepath), filename);

        StringBuilder stringBuilder = new StringBuilder();
        try {

            fr = new FileReader(myExternalFile);

            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while(line != null){

                stringBuilder.append(line).append('\n');
                line = br.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            String fileContents =  stringBuilder.toString()+"\n";
            tvLoad.setText(fileContents);
        }




    }
    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {

                return true;
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else {

            return true;
        }
    }
    private boolean isExternalStorageAvailableForRW() {

        String extStorageState = Environment.getExternalStorageState();
        if(extStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
}