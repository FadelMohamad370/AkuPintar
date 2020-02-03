package com.fadelmohamad.aku_pintar.Model;


public class UniversitasModel {
    private int id;
    private String nama;
    private String akreditas;
    private String status;
    private String jenis;
    private String alamat;
    private String kota;
    private String provinsi;
    private String website;

    public UniversitasModel(int universitasID, String nama, String akreditas, String status, String jenis, String alamat, String kota, String provinsi, String website) {
        this.id = universitasID;
        this.nama = nama;
        this.akreditas = akreditas;
        this.status = status;
        this.jenis = jenis;
        this.alamat = alamat;
        this.kota = kota;
        this.provinsi = provinsi;
        this.website = website;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAkreditas() {
        return akreditas;
    }
    public void setAkreditas(String akreditas) {
        this.akreditas = akreditas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

}