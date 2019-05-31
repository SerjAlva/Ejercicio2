package com.example.ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class segundoActivity extends AppCompatActivity {

    private ArrayList<Alumno> listaAlumnos;
    private ListView lvListaAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        listaAlumnos = new ArrayList<Alumno>();
        lvListaAlumnos = (ListView) findViewById(R.id.lvListaAlumnos);

        try{
            Bundle listaAlumnosEnviada = getIntent().getExtras();
            ArrayList listaAlumnos = null;

            if(listaAlumnosEnviada != null){
                listaAlumnos = (ArrayList) listaAlumnosEnviada.getSerializable("alumnos");
                Toast toast1 = Toast.makeText(getApplicationContext(),"Se han agregado " + listaAlumnos.size() + " alumnos", Toast.LENGTH_SHORT);
                toast1.show();
            }
            //ArrayAdapter <Alumno> adaptador = new ArrayAdapter<Alumno>(this, R.layout.list_item_alumno, listaAlumnos);
            Adapatador adaptador = new Adapatador(this, listaAlumnos, R.drawable.male, getResources().getString(R.string.masculino), R.drawable.female, getResources().getString(R.string.femenino));
            lvListaAlumnos.setAdapter(adaptador);

        } catch (Exception ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_LONG);
            toast1.show();
        }
    }

    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
