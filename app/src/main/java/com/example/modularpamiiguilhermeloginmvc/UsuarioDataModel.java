package com.example.modularpamiiguilhermeloginmvc;

public class UsuarioDataModel {
    //    toda classe DataModel tem essa estrutura:
    //    1 - atributo nome da tabela
    //    2 - atributos um para um com os nomes dos campos
    //    3 - query para criar a tabela do banco de dados
    //    4 - metodo para gerar o script para criar a tabela

    //1

    public static final String TABELA = "usuarios";

    //2
    public static final String ID = "id";

    public static final String NOME = "nome";

    public static final String EMAIL = "email";

    public static final String SENHA = "senha";

    //3

    public static String queryCriarTabela = "";

    //4

    public static String criarTabela() {
        //concatenaçao de string

        queryCriarTabela += "CREATE TABLE " + TABELA + "(";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, " ;
        queryCriarTabela += EMAIL + " text, ";
        queryCriarTabela += SENHA + " text ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }
}
