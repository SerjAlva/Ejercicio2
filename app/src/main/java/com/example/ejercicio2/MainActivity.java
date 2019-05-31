package com.example.ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellidos;
    private EditText etMatricula;
    private RadioGroup rgGenero;
    private ArrayList<Alumno> listaAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etMatricula = findViewById(R.id.etCuenta);

        rgGenero = findViewById(R.id.rgGenero);
        listaAlumnos = new ArrayList<Alumno>();
    }

    public void validarNombre(String nombre) throws ExceptionNombreInvalido{
        if(nombre.contains("0")||nombre.contains("1")||nombre.contains("2")||nombre.contains("3")||nombre.contains("4")||nombre.contains("5")||nombre.contains("6")||nombre.contains("7")||nombre.contains("8")||nombre.contains("9")||nombre.length()==0)
            throw new ExceptionNombreInvalido(getResources().getString(R.string.NombreInvaido));
    }

    public void validarMatricula(String matricula) throws ExceptionMatriculaInvalida{
        if(matricula.length()!=9){
            throw new ExceptionMatriculaInvalida(getResources().getString(R.string.MatriculaInvalida));
        }
    }

    public String obtenerGenero() throws ExceptionGeneroInvalido{
        int activoID = rgGenero.getCheckedRadioButtonId();
        String genero="";

        switch (activoID){
            case R.id.rbMasculino:
                genero = getResources().getString(R.string.masculino);
                break;
            case R.id.rbFemenino:
                genero = getResources().getString(R.string.femenino);
                break;
            default:
                genero = null;
                break;
        }
        if(genero==null){
            throw new ExceptionGeneroInvalido(getResources().getString(R.string.generoInvalido));
        } else{
            return genero;
        }
    }

    public void AgregarAlumnos(View view){
        try{
            String nombre = etNombre.getText().toString();
            validarNombre(nombre);
            String apellidos = etApellidos.getText().toString();
            validarNombre(apellidos);
            String matricula = etMatricula.getText().toString();
            validarMatricula(matricula);
            String genero = obtenerGenero();

            listaAlumnos.add(new Alumno(nombre, apellidos, matricula, genero));


            etNombre.setText("");
            etApellidos.setText("");
            etMatricula.setText("");

            Toast toast1 = Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.AlumnoAgregado)+nombre+" "+apellidos+", "+genero, Toast.LENGTH_SHORT);
            toast1.show();

        }catch(ExceptionNombreInvalido ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }catch(ExceptionMatriculaInvalida ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }catch(ExceptionGeneroInvalido ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }catch(Exception ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    public void Siguiente(View view){
        try{

            Intent enviarAlumno = new Intent(this, segundoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("alumnos",listaAlumnos);
            enviarAlumno.putExtras(bundle);
            startActivity(enviarAlumno);

        }catch(Exception ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}
