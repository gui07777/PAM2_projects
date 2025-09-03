package com.example.modularpamiiguilhermeloginmvc.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.modularpamiiguilhermeloginmvc.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(validaCampos()) {
                    usuario = new Usuario();
                    controller = new UsuarioController(getApplicationContext());

                    String user = usuario.getUserEmail().toString();
                    String pass = usuario.getUserPassword().toString();

                    usuario.setUserEmail(user);
                    usuario.setUserPassword(pass);

                    boolean isCheckUser = controller.usuarioeSenha(user, pass);

                    if(!isCheckUser) {
                        Toast.makeText(MainActivity.this "Usuario ainda nao cadastrado");
                    } else {
                        Intent home = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(home);
                    }
                }
            }
        })




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}