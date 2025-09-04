package com.example.modularpamiiguilhermeloginmvc.controller;

import java.util.List;

public interface iCrud <T>{
    public boolean inserir(T t);
    public boolean alterar(T t);
    public boolean excluir(int id);

    public T buscar(int id);

    public List<T> listar();
}
