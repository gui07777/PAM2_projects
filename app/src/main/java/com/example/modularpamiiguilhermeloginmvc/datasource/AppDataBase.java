package com.example.modularpamiiguilhermeloginmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.modularpamiiguilhermeloginmvc.UsuarioDataModel;

public class AppDataBase extends SQLiteOpenHelper {


    public static final String DB_NAME = "Loja.sqlite";
    public static final int VERSION = 1;

    SQLiteDatabase db;
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.i(AppUtil.TAG, "AppDataBase: Criando a conexao!");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert (String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            e.getMessage();
        }
        return retorno;
    }

    public Boolean checkUserPassword(String username, String password) {
        db = getWritableDatabase();
        boolean retorno = false;

        Cursor cursor = db.rawQuery("SELECT * FROM " +  UsuarioDataModel.TABELA + " WHERE username = ? " +
                " AND password = ?",
                new String[]{username, password});

        return cursor.getCount() > 0;
    }

    public Boolean checkUser(String username) {
        db = getWritableDatabase();
        boolean retorno = false;

        Cursor cursor = db.rawQuery("SELECT * FROM " +
                        UsuarioDataModel.TABELA + " WHERE username = ? ",
                new String[]{username});

        return cursor.getCount() > 0;
    }
}
