package com.example.modularpamiiguilhermeloginmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.modularpamiiguilhermeloginmvc.UsuarioDataModel;
import com.example.modularpamiiguilhermeloginmvc.datasource.AppDataBase;

import com.example.modularpamiiguilhermeloginmvc.model.Usuario;

import java.util.Collections;
import java.util.List;

public class UsuarioController extends AppDataBase implements iCrud<Usuario> {
    ContentValues dadosDoObjeto;
    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Usuario obj) {
        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put(UsuarioDataModel.NOME, obj.getUserName());
        dadosDoObjeto.put(UsuarioDataModel.EMAIL, obj.getUserEmail());
        dadosDoObjeto.put(UsuarioDataModel.SENHA, obj.getUserPassword());


        return insert(UsuarioDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean alterar(Usuario obj) {
        return false;
    }

    @Override
    public boolean deletar(Usuario obj) {
        return false;
    }

    @Override
    public List listar() {
        return Collections.emptyList();
    }

    public boolean usuarioSenha(String username, String password) {
        return checkUserPassword(username, password);
    }

    public boolean usuario(String user) {
        return checkUser(user);
    }
}
