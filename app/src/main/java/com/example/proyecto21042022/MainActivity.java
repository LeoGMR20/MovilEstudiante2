package com.example.proyecto21042022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos -> Componentes visuales
    private EditText etNombre, etApellido, etCelular, etEmail, etCodigo;
    private Button btnRegistrar;
    private Switch swEstudiante;
    private TextView tvResultado;

    //Atributos generales

    private Estudiante estudiante;
    private String nombre, apellido, celular, email, codigo;
    private boolean esEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        etCodigo.setVisibility(View.GONE);
        //Toast.makeText(this,"Creando...", Toast.LENGTH_SHORT).show();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
                pasarOtraPantalla();
            }
        });

        //Evento cambio de marcado para checkboxes y switches
        //Listener para estar atento al cambio de estado del Switch
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gestionarCodigoView(b);
            }
        });
    }

    //Manejo del componente llamado INTENT
    private void pasarOtraPantalla() {
        /*
        Cuando se quiere navegar de una pantalla A a otra pantalla B
        se debe hacer uso del componenete llamado INTENT
        el mismo se comporta como el criterio de querer responder
        a una intención o deseo en términos simples.
        Si la intención se puede resolver pues logramos el objetivo
        y un método en específico lanzará la siguiente pantalla.
        Para configurar un INTENT en este sentido, se debe crear
        una instancia de la clase Intent y en su constructor
        indicarle de donde a donde quieren ir, pero deben ser referenciadas
        en conceptos del contexto de la clase que representa a esa pantalla
        */
        Intent intencion = new Intent(this, HomeActivity.class);
        //Paso 1: mandar datos
        /*
        Quieren pasar datos a otra pantalla
        Usar el Intent
        en el Intent -> configurar un archivo temporal
        archivo temporal -> guarda registro en un formato.
        ese formato se conoce como: CLAVE(key) -> VALOR(value)
        ejemplo: .putExtra("Llave"(clave), valor(primitiva))
        El archivo pueden entenderlo que se llama extras
        y cada registro que crean es un EXTRA
        La llave debe ser una cadena string única
         */
        nombre = etNombre.getText().toString();
        apellido = etApellido.getText().toString();
        celular = etCelular.getText().toString();
        email = etEmail.getText().toString();
        codigo = etCodigo.getText().toString();
        esEstudiante = swEstudiante.isChecked();
        intencion.putExtra("nombre_persona",nombre);
        intencion.putExtra("apellido_persona",apellido);
        intencion.putExtra("celular_persona",celular);
        intencion.putExtra("email_persona",email);
        intencion.putExtra("codigo_persona",codigo);
        intencion.putExtra("esEstudiante_persona",esEstudiante);
        startActivity(intencion);
    }

    private void gestionarCodigoView(boolean marcado){
        if (marcado){
            etCodigo.setVisibility(View.VISIBLE);
        }
        else{
            etCodigo.setVisibility(View.GONE);
        }
    }

    private void mostrarMensaje(boolean b) {
        String mensaje = "No estoy marcado";
        if (b){
            mensaje = "Estoy marcado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this,"Estoy corriendo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this,"Empezando", Toast.LENGTH_SHORT).show();
    }

    private void inicializarVistas(){
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCelular = findViewById(R.id.etCelular);
        etEmail = findViewById(R.id.etEmail);
        etCodigo = findViewById(R.id.etCodigo);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        swEstudiante = findViewById(R.id.swEstudiante);
        tvResultado = findViewById(R.id.tvResultado);
    }

    private void obtenerInformacion(){
        //Primero obtenemos los valores de los tb como tal, para validar si son null o no.
        //Luego, si no es el caso lo asignamos a las variables para llamar a la clase e imprimir
        if(etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() ||
                etCelular.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() ||
                etCodigo.getText().toString().isEmpty()){
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
            nombre = etNombre.getText().toString();
            apellido = etApellido.getText().toString();
            String email = etApellido.getText().toString();
            int celular = Integer.parseInt(etCelular.getText().toString());
            int codigo = Integer.parseInt(etCodigo.getText().toString());
            //En el switch o checkbox ustedes quieren obtener el valor
            //cuando el elemento ha sdo marcado y eso es un atributo
            //llamdo checked
            //en valores booleanos el get cambia por is por temas de lenguaje
            boolean esEstudiante = swEstudiante.isChecked();
            estudiante = new Estudiante(nombre,apellido,celular, email, esEstudiante);
            tvResultado.setText(estudiante.toString());
        }
    }
}