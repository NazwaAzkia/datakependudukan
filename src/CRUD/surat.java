/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintal sql simpan, ubah, hapus
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ASUS
 */
public class surat {
    private String databaseName = "nazwaazkia_2210010396";
    private String username = "root";
    private String password = "";
    public static Connection connectiondb;
    
    public surat(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectiondb = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpansurat (String id_surat, String jenis_surat, String no_surat, String nama_surat, Date tanggal, String isi_surat, String tanda_surat, String no_ktp, String nama_warga) {
        try {
            String sql = "insert into surat (id_surat, jenis_surat, no_surat, nama_surat, tanggal, isi_surat, tanda_surat, no_ktp, nama_warga) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_surat);
            perintah.setString(2, jenis_surat);
            perintah.setString(3, no_surat);
            perintah.setString(4, nama_surat);
            perintah.setDate(5, tanggal);
            perintah.setString(6, isi_surat);
            perintah.setString(7, tanda_surat);
            perintah.setString(8, no_ktp);
            perintah.setString(9, nama_warga);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void ubahsurat (String id_surat, String jenis_surat, String no_surat, String nama_surat, Date tanggal, String isi_surat, String tanda_surat, String no_ktp, String nama_warga) {
        try {
            String sql = "update surat set jenis_surat = ?, no_surat = ?, nama_surat=?, tanggal=?, isi_surat=?, tanda_surat=?, no_ktp=?, nama_warga=? where id_surat = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, jenis_surat);
            perintah.setString(2, no_surat);
            perintah.setString(3, nama_surat);
            perintah.setDate(4, tanggal);
            perintah.setString(5, isi_surat);
            perintah.setString(6, tanda_surat);
            perintah.setString(7, no_ktp);
            perintah.setString(8, nama_warga);
            perintah.setString(9, id_surat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
        
    public void hapussurat (String id_surat) {
        try {
            String sql = "delete from surat where id_surat = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_surat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void carisurat(String paramid_surat) {
        try {
          String SQL="SELECT*FROM surat WHERE id_surat=?";
          PreparedStatement perintah = connectiondb.prepareStatement(SQL);
          perintah.setString(1,paramid_surat);
          ResultSet data = perintah.executeQuery();
          while (data.next()) {
              System.out.println("id_surat :"+data.getString("id_surat"));
              System.out.println("jenis_surat :"+data.getString("jenis_surat"));
              System.out.println("no_surat :"+data.getString("no_surat"));
              System.out.println("nama_surat :"+data.getString("nama_surat"));
              System.out.println("tanggal :"+data.getDate("tanggal"));
              System.out.println("isi_surat :"+data.getString("isi_surat"));
              System.out.println("tanda_surat :"+data.getString("tanda_surat"));
              System.out.println("no_ktp :"+data.getString("no_ktp"));
              System.out.println("nama_warga :"+data.getString("nama_warga"));
          }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datasurat(){
      try {
          Statement stmt  = connectiondb.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM surat ORDER BY id_surat ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_surat")+" | "+
                      baris.getString("jenis_surat")+" | "+
                      baris.getString("no_surat")+" | "+
                      baris.getString("nama_surat")+" | "+
                      baris.getDate("tanggal")+" | "+
                      baris.getString("isi_surat")+" | "+
                      baris.getString("tanda_surat")+" | "+
                      baris.getString("no_ktp")+" | "+
                      baris.getString("nama_warga"));
            }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
    }
}


