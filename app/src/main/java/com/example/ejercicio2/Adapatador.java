package com.example.ejercicio2;

import android.content.Context;
import android.content.pm.FeatureGroupInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapatador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private ArrayList<Alumno> listaAlumnos;
    private static int MALE;
    private static String masculino;
    private static int FEMALE;
    private static String femenino;

    public Adapatador(Context contexto, ArrayList<Alumno> listaAlumnos, int MALE, String masculino, int FEMALE, String femenino) {
        this.contexto = contexto;
        this.listaAlumnos = listaAlumnos;
        this.MALE=MALE;
        this.masculino=masculino;
        this.FEMALE=FEMALE;
        this.femenino=femenino;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listaAlumnos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.list_item_masculino, null);
        TextView tvNombre = (TextView) vista.findViewById(R.id.tviNombre);
        TextView tvApellidos = (TextView) vista.findViewById(R.id.tviApellidos);
        TextView tvMatricula = (TextView) vista.findViewById(R.id.tviMatricula);
        ImageView ivGenero = (ImageView) vista.findViewById(R.id.ivGenero);

        final Alumno alumno = listaAlumnos.get(position);
        tvNombre.setText(alumno.getNombre());
        tvApellidos.setText(alumno.getApellidos());
        tvMatricula.setText(alumno.getMatricula());

        if(alumno.getGenero().equals(masculino)){
            ivGenero.setImageResource(MALE);
        } else{
            ivGenero.setImageResource(FEMALE);
        }

        ivGenero.setTag(position);

        ivGenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(contexto, alumno.getNombre() +" " +  vista.getResources().getString(R.string.AlumnoToast) + Integer.toString(position), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        return vista;
    }
}
