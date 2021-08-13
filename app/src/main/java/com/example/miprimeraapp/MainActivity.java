package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numero_uno;
    private EditText numero_dos;
    private TextView res;

    //raiz
    private EditText valNumARaiz;
    private TextView resRaizCua;
    private RadioButton rbRaiz;

    //exponentes
    private CheckBox checExpo;

    //logaritmo
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.*/

        numero_uno = findViewById(R.id.numero_uno);
        numero_dos = findViewById(R.id.numero_dos);
        res = findViewById(R.id.respuesta);

        //raiz
        valNumARaiz = findViewById(R.id.txt_num_raiz);
        resRaizCua = findViewById(R.id.txt_resultado);
        rbRaiz = findViewById(R.id.rb_raiz);

        //exponente
        checExpo = findViewById(R.id.check_exponente);

        //logaritmo
        spinner = findViewById(R.id.spinnerLn);

        String [] opciones = {"logaritmo","otras"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.speener_item_ejemplo, opciones);
        spinner.setAdapter(adapter);

        /*@Override;
        protected void onStart() {
            super.onStart();
            Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
            // La actividad está a punto de hacerse visible.
        }
        @Override
        protected void onResume() {
            super.onResume();
            Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
            // La actividad se ha vuelto visible (ahora se "reanuda").
        }
        @Override
        protected void onPause() {
            super.onPause();
            Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
            // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
        }
        @Override
        protected void onStop() {
            super.onStop();
            Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
            // La actividad ya no es visible (ahora está "detenida")
        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
            Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
            // La actividad está a punto de ser destruida.
        }*/
    }

    public void calcularLn(View view)
    {
        Integer valor = Integer.parseInt(valNumARaiz.getText().toString());
        String seleccion = spinner.getSelectedItem().toString();

        if(seleccion.equals("logaritmo"))
        {
            if(valor > 0)
            {
                Double reslog = Math.log(valor);
                res.setText(String.valueOf(reslog));
            }
            else
            {
                Toast.makeText(this, "Numero INVALIDO!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Elija una opcion!", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularExponente(View view)
    {
        Integer nume = Integer.parseInt(numero_uno.getText().toString());
        Integer numEx = Integer.parseInt(numero_dos.getText().toString());

        if(checExpo.isChecked() == true)
        {
            //Integer resultE = (Integer) Math.pow(nume, numEx);

            Integer resultE = 1;
            for (int i = 1; i <= numEx; i++)
            {
                resultE = resultE * nume;
            }
            res.setText(String.valueOf(resultE));
        }
    }

    public void calcularRaiz(View view)
    {
          Integer valor = Integer.parseInt(valNumARaiz.getText().toString());

          if(rbRaiz.isChecked() == true)
          {
              if(valor == 0)
              {
                  Toast.makeText(this, "Numero Invalido", Toast.LENGTH_LONG).show();
              }
              else
              {
                  Double resultR = Math.sqrt(valor);
                  resRaizCua.setText(String.valueOf(resultR));
              }
          }
    }

    public void sumar(View view)
    {

        Integer resNum = Integer.parseInt(numero_uno.getText().toString()) + Integer.parseInt(numero_dos.getText().toString());
        res.setText(String.valueOf(resNum));

        if(resNum <= 10)
        {
            Toast.makeText(this, "Menos de 10", Toast.LENGTH_SHORT).show();
        }
        else if(resNum > 10)
        {
            Toast.makeText(this, "Mas de 10", Toast.LENGTH_SHORT).show();
        }
     }

    public void restar(View view)
    {
        Integer numeroUno = Integer.parseInt(numero_uno.getText().toString());
        Integer numeroDos = Integer.parseInt(numero_dos.getText().toString());

        if(numeroUno < numeroDos)
        {
            Toast.makeText(this, "El 1ro es menor al 2do!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Integer resNum = numeroUno - numeroDos;
            res.setText(resNum + "");
        }
    }

    public void dividir(View view)
    {

        Integer numDivisor = Integer.parseInt(numero_dos.getText().toString());
        if(numDivisor != 0)
        {
            Integer resNum = Integer.parseInt(numero_uno.getText().toString()) / Integer.parseInt(numero_dos.getText().toString());
            res.setText(resNum+"");
        }
        else
        {
            res.setText("0 invalido!");
        }
    }

    public void multiplicar(View view)
    {
        Integer resNum = Integer.parseInt(numero_uno.getText().toString()) * Integer.parseInt(numero_dos.getText().toString());
        res.setText(resNum+"");
    }
}