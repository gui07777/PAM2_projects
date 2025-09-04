package com.example.modularpamiiguilhermeloginmvc;

public class UsuarioDataModel {
    //    toda classe DataModel tem essa estrutura:
    //    1 - atributo nome da tabela
    //    2 - atributos um para um com os nomes dos campos
    //    3 - query para criar a tabela do banco de dados
    //    4 - metodo para gerar o script para criar a tabela

    //1

    public static final String TABELA = "usuario";

    //2
    public static final String ID = "id";

    public static final String NOME = "nome";

    public static final String EMAIL = "email";

    public static final String SENHA = "senha";

    //3


    //4

    public static String criarTabela() {
        //concatenaçao de string

         return  "CREATE TABLE " + TABELA + "(" +
         ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
         NOME + " TEXT, "  +
         EMAIL + " TEXT, " +
         SENHA + " TEXT) ";
    }
}
