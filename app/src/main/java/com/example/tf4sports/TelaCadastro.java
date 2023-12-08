package com.example.tf4sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        //Criar objetos para os componentes da tela
        EditText etNomeC = findViewById(R.id.etNomeC);
        EditText etEmailC = findViewById(R.id.etEmailC);
        EditText etSenhaC = findViewById(R.id.etSenhaC);
        Button btCadastrarC = findViewById(R.id.btCadastrarC);

        btCadastrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Iniciar o objeto do SharedPreferences para gravação
                //O nome "dados" será o nome do arquivo XML, se não existir, será criado na hora
                //A classe Editor indica que o XML será usado para gravar dados

                SharedPreferences.Editor gravar = getSharedPreferences("dados", MODE_PRIVATE).edit();
                gravar.putString("email", etEmailC.getText().toString());
                gravar.putString("senha", etSenhaC.getText().toString());
                gravar.apply();

                //Para gravar os dados é necessário chmar o método apply() ou o método commit() sendo que aúnica diferença é que o commit()
                //retornará um boolean indicando que gravou os dados ou não, o apply não retorna nada

                Toast.makeText(TelaCadastro.this, "Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(TelaCadastro.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}