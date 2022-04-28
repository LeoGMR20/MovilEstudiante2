package com.example.proyecto21042022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos -> Componentes visuales
    private EditText etNombre, etApellido,etCelular;
    private Button btnRegistrar;
    private Switch swEstudiante;
    private TextView tvResultado;

    //Atributos generales

    private Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
    }

    private void inicializarVistas(){
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCelular = findViewById(R.id.etCelular);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        swEstudiante = findViewById(R.id.swEstudiante);
        tvResultado = findViewById(R.id.tvResultado);
    }

    private void obtenerInformacion(){
        //Primero obtenemos los valores de los tb como tal, para validar si son null o no.
        //Luego, si no es el caso lo asignamos a las variables para llamar a la clase e imprimir
        if(etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() ||
                etCelular.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe ingresar todos los datos",Toast.LENGTH_LONG).show();
        }
        else if(etNombre.getText().toString().length() < 3){
            Toast.makeText(this,"El nombre ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else if(etApellido.getText().toString().length() < 3){
            Toast.makeText(this,"El apellido ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else if(etCelular.getText().toString().length() < 7){
            Toast.makeText(this,"El número de celular ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else{
            String nombre = etNombre.getText().toString();
            String apellido = etApellido.getText().toString();
            int celular = Integer.parseInt(etCelular.getText().toString());
            //En el switch o checkbox ustedes quieren obtener el valor
            //cuando el elemento ha sdo marcado y eso es un atributo
            //llamdo checked
            //en valores booleanos el get cambia por is por temas de lenguaje
            boolean esEstudiante = swEstudiante.isChecked();
            estudiante = new Estudiante(nombre,apellido,celular,esEstudiante);
            tvResultado.setText(estudiante.toString());
        }
    }
}