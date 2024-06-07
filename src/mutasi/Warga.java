/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutasi;

/**
 *
 * @author ASUS
 */
public class Warga {
    public String nama;
    public String alamat;
    public int usia;
    public String pekerjaan;

    // Constructor
    public Warga(String nama, String alamat, int usia, String pekerjaan) {
        this.nama = nama;
        this.alamat = alamat;
        this.usia = usia;
        this.pekerjaan = pekerjaan;
    }

    // Getters and Setters
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }
    
    public String getpekerjaan() {
        return pekerjaan;
    }

    public void setpekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    @Override
    public String toString() {
        return "Warga{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", usia=" + usia + '\'' +
                ", pekerjaan='" + pekerjaan +
                '}';
    }
}
