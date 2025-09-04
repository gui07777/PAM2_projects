package com.example.modularpamiiguilhermeloginmvc.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.modularpamiiguilhermeloginmvc.R;
import com.example.modularpamiiguilhermeloginmvc.controller.UsuarioController;
import com.example.modularpamiiguilhermeloginmvc.model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText nomeUsuario, emailUsuario, senhaUsuario;
    Button cadastrar, entrar;
    UsuarioController controller;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents(); // Inicializa os componentes antes de usá-los

        entrar.setOnClickListener(view -> {
            if (validaCampos()) {
                usuario = new Usuario();

                String nome = nomeUsuario.getText().toString();
                String email = emailUsuario.getText().toString();
                String senha = senhaUsuario.getText().toString();

                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);

                controller = new UsuarioController(this);

                boolean isCheckUser = controller.checkUsuario(email);
                boolean isCheckPass = controller.checkSenha(email, senha);

                if (isCheckUser && isCheckPass) {
                    Toast.makeText(MainActivity.this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean validaCampos() {
            boolean camposValidados = false;
            if (nomeUsuario.getText().toString().isEmpty() ||
                    emailUsuario.getText().toString().isEmpty() ||
                    senhaUsuario.getText().toString().isEmpty()) {
                camposValidados = false;
            } else {
                camposValidados = true;
            }
            return camposValidados;
        }

        private void initComponents() {
            nomeUsuario = findViewById(R.id.nome);
            emailUsuario = findViewById(R.id.email);
            senhaUsuario = findViewById(R.id.senha);
            cadastrar = findViewById(R.id.cadastrar);
            entrar = findViewById(R.id.entrar);
        }
}