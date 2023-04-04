package com.qantica.applicationgps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MovicappDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "my_database.db";
    private static final int DB_VERSION = 1;

    public MovicappDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tabla Formulario
        db.execSQL("CREATE TABLE Formulario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pregunta1 TEXT NOT NULL," +
                "pregunta2 TEXT NOT NULL," +
                "pregunta3 TEXT NOT NULL," +
                "pregunta4 TEXT NOT NULL," +
                "pregunta5 TEXT NOT NULL," +
                "foto BLOB," +
                "firma BLOB)");

        // Crear tabla Evidencia
        db.execSQL("CREATE TABLE Evidencia (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "observacion TEXT NOT NULL," +
                "foto BLOB)");

        // Crear tabla Informacion
        db.execSQL("CREATE TABLE Informacion (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_usuario TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "hora_inicio TEXT NOT NULL," +
                "hora_fin TEXT NOT NULL," +
                "distancia_recorrida REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si se necesita actualizar la base de datos, se pueden eliminar las tablas existentes
        db.execSQL("DROP TABLE IF EXISTS Formulario");
        db.execSQL("DROP TABLE IF EXISTS Evidencia");
        db.execSQL("DROP TABLE IF EXISTS Informacion");
        onCreate(db);
    }
}