package com.example.danni.domiventas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText eNombreNegocio, eNombrePropietario,eDireccion, eNumeroCelular;
    String TipoNegocio, Email;
    private Spinner sTipoTienda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        eNombreNegocio=(EditText)findViewById(R.id.eNombreNegocio);
        eNombrePropietario=(EditText)findViewById(R.id.eNombrePropietario);
        eDireccion=(EditText)findViewById(R.id.eDireccion);
        eNumeroCelular=(EditText)findViewById(R.id.eNumeroCelular);
        sTipoTienda=(Spinner)findViewById(R.id.sTipoTienda);

        Bundle data = getIntent().getExtras();
        Email=data.getString("Email");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_negocio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTipoTienda.setAdapter(adapter);
        sTipoTienda.setOnItemSelectedListener(Register2Activity.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TipoNegocio = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void bContinue(View view) {
        Intent intent = new Intent(Register2Activity.this,Register3Activity.class);
        intent.putExtra("Email",Email);
        intent.putExtra("Nombre",eNombreNegocio.getText().toString());
        intent.putExtra("Propietario",eNombrePropietario.getText().toString());
        intent.putExtra("Direccion",eDireccion.getText().toString());
        intent.putExtra("Celular",eNumeroCelular.getText().toString());
        intent.putExtra("Tipo",TipoNegocio);
        startActivity(intent);
        finish();
    }
}
