package com.example.daftarmenu;

public class SetterGetter {

    String makanan;
    String profile;
    String harga;
    String deskripsi;
    String deskripsiHarga;
    int profilepopup;

    public SetterGetter(String makanan, String profile, String harga, String deskripsi,String deskripsiHarga, int profilepopup) {
        this.profile = profile;
        this.makanan = makanan;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.deskripsiHarga = deskripsiHarga;
        this.profilepopup = profilepopup;

    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getProfilepopup() {
        return profilepopup;
    }

    public void setProfilepopup(int profilepopup) {
        this.profilepopup = profilepopup;
    }

    public String getDeskripsiHarga() {
        return deskripsiHarga;
    }

    public void setDeskripsiHarga(String deskripsiHarga) {
        this.deskripsiHarga = deskripsiHarga;
    }
}