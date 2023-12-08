package com.example.tf4sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {
    EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //Criar objetos para os componentes da tela
        EditText email = (EditText) findViewById(R.id.etEmailL);
        EditText senha = (EditText) findViewById(R.id.etSenhaL);
        Button btLogar = findViewById(R.id.btLogar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailGravado = email.getText().toString();
                String senhaGravada = senha.getText().toString();

                if (TextUtils.isEmpty(emailGravado) || TextUtils.isEmpty(senhaGravada)) {
                    Toast.makeText(TelaLogin.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences ler = getSharedPreferences("dados", MODE_PRIVATE);
                    String EmailGravado = ler.getString("email","");
                    String SenhaGravada = ler.getString("senha","");
                    if (EmailGravado.equals(email.getText().toString()) && SenhaGravada.equals(senha.getText().toString())) {
                        Toast.makeText(TelaLogin.this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent tela = new Intent(getApplicationContext(),TelaMenu.class);
                        startActivity(tela);
                    } else {
                        Toast.makeText(TelaLogin.this, "Usuário ou senha incorreta", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}