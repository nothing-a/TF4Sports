package com.example.tf4sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = findViewById(R.id.btLogin);
        Button btCadastrar = findViewById(R.id.btCadastrar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrParaTelaLogin();
            }
            private void IrParaTelaLogin() {

                Intent it = new Intent(MainActivity.this, TelaLogin.class);
                startActivity(it);

            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrParaTelaCadastro();
            }
            private void IrParaTelaCadastro() {

                Intent it = new Intent(MainActivity.this, TelaCadastro.class);
                startActivity(it);

            }
        });
    }
}
