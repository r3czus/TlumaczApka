package com.example.firebasetranslateapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnZapisz,btnTlumacz,btnLista;
        btnLista=findViewById(R.id.btnShow);








        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListaActivity = new Intent(MainActivity.this, listOfwords.class );
                startActivity(ListaActivity);


            }
        });
    }




}