package com.example.modularpamiiguilhermeloginmvc.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.modularpamiiguilhermeloginmvc.controller.UsuarioController;
import com.example.modularpamiiguilhermeloginmvc.model.Usuario;




import com.example.modularpamiiguilhermeloginmvc.R;

public class CadastroActivity extends AppCompatActivity {
    EditText nome, email, senha;
    Button cadastrar;
    UsuarioController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);

        controller = new UsuarioController(this);

        cadastrar.setOnClickListener(view -> cadastrarUsuario());
        });

    }
    private void cadastrarUsuario() {
        String nomeString = nome.getText().toString().trim();
        String emailString = email.getText().toString().trim();
        String senhaString = senha.getText().toString().trim();

        if (nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nomeString);
        usuario.setEmail(emailString);
        usuario.setSenha(senhaString);

        if (controller.checkUsuario(emailString)) {
            Toast.makeText(this, "Usuário já existe com esse email", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean sucesso = controller.inserir(usuario);
        if (sucesso) {
            Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();

        }
    }
}