package com.kitap.ekitap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private String yazar;
    private String kategori;
    private LocalDate yayinTarihi;
    private boolean stoktaVarMi;

    public Kitap() {
    }

    public Kitap(String baslik, String yazar, String kategori, LocalDate yayinTarihi, boolean stoktaVarMi) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.kategori = kategori;
        this.yayinTarihi = yayinTarihi;
        this.stoktaVarMi = stoktaVarMi;
    }

    // Getter & Setter'lar

    public Long getId() {
        return id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public LocalDate getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(LocalDate yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public boolean isStoktaVarMi() {
        return stoktaVarMi;
    }

    public void setStoktaVarMi(boolean stoktaVarMi) {
        this.stoktaVarMi = stoktaVarMi;
    }
}
