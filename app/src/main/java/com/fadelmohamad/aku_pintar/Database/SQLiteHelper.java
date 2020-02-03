package com.fadelmohamad.aku_pintar.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fadelmohamad.aku_pintar.Model.UniversitasModel;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Kampus_PintarDB";
    private static final String T_UNIVERSITAS = "tb_universitas";

    private static final String KEY_ID = "id_universitas";
    private static final String KEY_NAMA = "namauUniversitas";
    private static final String KEY_AKREDITAS = "akreditas";
    private static final String KEY_STATUS = "status";
    private static final String JENIS = "jenis";
    private static final String ALAMAT = "alamat";
    private static final String KOTA = "kota";
    private static final String PROVINSI = "provinsi";
    private static final String WEBSITE = "website";


    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        tes(db);
    }

    public void tes(SQLiteDatabase db) {
        String query = "CREATE TABLE " + T_UNIVERSITAS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAMA + " TEXT, " +
                KEY_AKREDITAS + " TEXT, " +
                KEY_STATUS + " TEXT, " +
                JENIS + " TEXT, " +
                ALAMAT + " TEXT, " +
                KOTA + " TEXT, " +
                PROVINSI + " TEXT, " +
                WEBSITE + " TEXT" + ")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);

        query = "insert into tb_universitas values(1,'Institut Teknologi Bandung (ITB)','Akreditasi A','PTN-BH','Negeri','Jl. Ganesha no 10 Siliwangi','Kota Bandung','Jawa Barat','itb.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(2,'Universitas Gadjah Mada (UGM)','Akreditas A','PTN-BH','Negeri','Jl. Bulaksumur','Kota Sleman','D I Yogyakarta','ugm.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(3,'Institut Pertanian Bogor (IPB)','Akreditas A','PTN-BH','Negeri','Jl. Pajajaran','Kota Bogor','Jawa Barat','ipb.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(4,'Institut Teknologi Sepuluh November (ITS)','Akreditas A','PTN-BH','Negeri','Jl. Raya Keputih','Kota Surabaya','Jawa Timur','its.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(5,'Universitas Indonesia (UI)','Akreditas A','PTN-BH','Negeri','Jl. Margonda Raya','Kota Depok','Jawa Barat','ui.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(6,'Universitas Diponegoro (Undip)','Akreditas A','PTN-BH','Negeri','Jl. Prof. Soedarto SH','Kota Semarang','Jawa Tengah','undip.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(7,'Universitas Airlangga (Unair)','Akreditas A','PTN-BH','Negeri','Jl. Airlangga No 4-6','Kota Surabaya','Jawa Timur','unair.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(8,'Universitas Hasanuddin (Unhas)','Akreditas A','PTN-BH','Negeri','Jl. Perintis Kemerdekaan','Kota Makasar','Sulawesi Selatan','unhas.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(9,'Universitas Brawijaya (UB)','Akreditas A','PTN-BLU','Negeri','Jl. Veteran','Kota Malang','Jawa Timur','ub.ac.id')";
        db.execSQL(query);
        query = "insert into tb_universitas values(10,'Universitas Padjajaran (Unpad)','Akreditas A','PTN-BH','Negeri','Jl. Raya Bandung Sumedang','Kota Sumedang','Jawa Barat','unpad.ac.id')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + T_UNIVERSITAS);

        onCreate(db);
    }


    public List<UniversitasModel> getUniv() {
        List<UniversitasModel> univList = new ArrayList<>();
        String query = "SELECT * FROM " + T_UNIVERSITAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String akreditas = cursor.getString(2);
                String status = cursor.getString(3);
                String jenis = cursor.getString(4);
                String alamat = cursor.getString(5);
                String kota = cursor.getString(6);
                String provinsi = cursor.getString(7);
                String website = cursor.getString(8);

                UniversitasModel universitasModel = new UniversitasModel(id, nama, akreditas, status, jenis, alamat, kota, provinsi, website);

                univList.add(universitasModel);
            } while (cursor.moveToNext());
        }

        return univList;
    }

    //   public void history (int i, String w){

    //      SQLiteDatabase db = this.getWritableDatabase();
    //    String query = "insert into t_log values("+i+","+w+")";
    //   db.execSQL(query);
}