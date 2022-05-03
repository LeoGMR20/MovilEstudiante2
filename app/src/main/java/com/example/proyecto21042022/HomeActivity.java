package com.example.proyecto21042022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView txtResultado;

    private String nombre, apellido, celular, email, codigo;
    private boolean esEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosPantallaA();
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtResultado.setText("Nombre: "+nombre+
                "\nApellido: "+apellido+
                "\nCelular: "+celular+
                "\nEmail: "+email+
                "\nCodigo: "+codigo+
                "\n¿Es estudiante?: "+esEstudiante);
    }

    private void inicializarVistas() {
        //findViewById solo busca los elementos de la pantalla actual
        txtResultado = findViewById(R.id.txtResultado);
    }

    private void recibirDatosPantallaA(){
        //Paso 2: Recibir datos
        /*
        Para recibir los datos, las pantallas involicaradas en el INTENT
        saben o conocen la referencia de este...
        entonces la idea es obtener ese Intent, de ese intnt obtener
        elmarchivo EXTRAS, y de ese archivo obtener un registro en particular
        al obtener tienen que indicar que tipo de dato es ej: getString, getInt
        y como parámetro le pasan la llave del registro.
         */
        nombre = this.getIntent().getExtras().getString("nombre_persona","");
        apellido = this.getIntent().getExtras().getString("apellido_persona","");
        celular = this.getIntent().getExtras().getString("celular_persona","");
        email = this.getIntent().getExtras().getString("email_persona","");
        codigo = this.getIntent().getExtras().getString("codigo_persona","");
        esEstudiante = this.getIntent().getExtras().getBoolean("esEstudiante_persona",false);
    }
}