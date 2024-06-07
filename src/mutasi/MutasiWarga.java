/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutasi;

/**
 *
 * @author ASUS
 */
public class MutasiWarga extends Warga {
    // Constructor
    public MutasiWarga(String nama, String alamat, int usia, String pekerjaan) {
        super(nama, alamat, usia, pekerjaan);
    }

    // Method untuk pindah alamat
    public void pindahAlamat(String alamatBaru) {
        System.out.println("Mutasi alamat dari " + getAlamat() + " ke " + alamatBaru);
        setAlamat(alamatBaru);
    }

    // Method untuk menambahkan warga baru (datang)
    public static MutasiWarga wargaDatang(String nama, String alamat, int usia, String pekerjaan) {
        System.out.println("Warga baru datang: " + nama + ", Alamat: " + alamat + ", Usia: " + usia + ", Pekerjaan: " + pekerjaan);
        return new MutasiWarga(nama, alamat, usia, pekerjaan);
    }
}

