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
    public boolean inserir(Usuario usuario) {
        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put("nome", usuario.getNome());
        dadosDoObjeto.put("email", usuario.getEmail());
        dadosDoObjeto.put("senha", usuario.getSenha());



        return insert(UsuarioDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean alterar(Usuario usuario) {
        return false;
    }

    @Override
    public boolean excluir(int id) {
        return false;
    }

    public Usuario buscar(int id) {
        return null;
    }

    @Override
    public List<Usuario> listar() {
        return Collections.emptyList();
    }

    public boolean checkSenha(String email, String senha) {
        return checkSenha(email, senha);
    }

    public boolean checkUsuario(String email) {
        return checkUser(email);
    }
}
