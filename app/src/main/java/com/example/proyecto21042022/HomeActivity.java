package com.example.proyecto21042022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private TextView txtResultado, txtResultadoSP;
    private Spinner spOpciones;
    private Button btnCalcular;

    private String nombre, apellido, celular, email, codigo;
    private boolean esEstudiante;
    private Estudiante estudiante;

    //En esta estructura vamos a contener los valores de cada opción del combo box
    private ArrayList<String> opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosPantallaA();
        mostrarDatos();
        popularSpinner();
        btnCalcular.setOnClickListener(view -> {
            obtenerValoresSpinner();
        });
    }

    private void obtenerValoresSpinner() {
        //Información que pueden obtener del elemento
        //seleccionado en un spinner
        String valor = spOpciones.getSelectedItem().toString();
        int posicion = spOpciones.getSelectedItemPosition();
        switch (valor){
            case "Notas":
                //procedimientos
                break;
            case "Faltas":
                //Procedimiento
                calcularFaltas();
                break;
        }
    }

    private void calcularFaltas() {
        Random random = new Random();
        int numRandom = random.nextInt(11);
        int faltas = 0;
        int a = 0, b = 1;
        for (int i = 0; i < numRandom; i++) {
            a = b;
            b = faltas;
            faltas = a + b;
        }

        if(faltas > 11){
            txtResultadoSP.setText("Random: " + numRandom +
                    "\nCantidad de faltas: " + faltas +
                    "\nEstado: Reprobado");
        }
        else{
            txtResultadoSP.setText("Random: " + numRandom +
                    "\nCantidad de faltas: " + faltas +
                    "\nEstado: Aprobado");
        }
    }

    private void popularSpinner() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Notas","Faltas"));
        opciones.add("Nueva opción");
        //Necesitan un adaptador para convertir una fuente de datos primitivos
        //en un componenete visual que pueda ser desplegado en pantalla.
        //Adaptador = puente que convierte fuentes de datos en elementos visuales
        /*
        Parámetros que necesita un adaptador ya fabricado por defecto
        en este caso, ese adpatador se denomina ArrayAdapter
        1: Contexto de la pantalla donde se va a dibujar el componente visual.
        2: La representación del componente visual o recurso visual que va a dibujar por cada elemento
        3: Indiquen la fuente de datos, o la estructura que contiene sus datos primitivos
         */
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
                );
        spOpciones.setAdapter(adaptador);
    }

    private void mostrarDatos() {
        txtResultado.setText("Nombre: "+estudiante.getNombre()+
                "\nApellido: "+estudiante.getApellido()+
                "\nCelular: "+estudiante.getCelular()+
                "\nEmail: "+estudiante.getEmail()+
                "\nCodigo: "+estudiante.getCodigoEstudiante()+
                "\n¿Es estudiante?: "+estudiante.isEstudiante());
    }

    private void inicializarVistas() {
        //findViewById solo busca los elementos de la pantalla actual
        txtResultado = findViewById(R.id.txtResultado);
        spOpciones = findViewById(R.id.spOpciones);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultadoSP = findViewById(R.id.txtResultadoSP);
    }

    private void recibirDatosPantallaA(){
        //Paso 2: Recibir datos
        /*
        Para recibir los datos, las pantallas involucradas en el INTENT
        saben o conocen la referencia de este...
        entonces la idea es obtener ese Intent, de ese intnt obtener
        elmarchivo EXTRAS, y de ese archivo obtener un registro en particular
        al obtener tienen que indicar que tipo de dato es ej: getString, getInt
        y como parámetro le pasan la llave del registro.
         */
        /*nombre = this.getIntent().getExtras().getString("nombre_persona","");
        apellido = this.getIntent().getExtras().getString("apellido_persona","");
        celular = this.getIntent().getExtras().getString("celular_persona","");
        email = this.getIntent().getExtras().getString("email_persona","");
        codigo = this.getIntent().getExtras().getString("codigo_persona","");
        esEstudiante = this.getIntent().getExtras().getBoolean("esEstudiante_persona",false);*/

        //Paso 2: forma alternativa Objeto Estudiante en formato bytes
        estudiante = (Estudiante) this.getIntent().getExtras().getSerializable("objeto_estudiante");
    }
}