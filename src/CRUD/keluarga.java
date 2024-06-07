/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintal sql simpan, ubah, hapus
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class keluarga {
    private String databaseName = "nazwaazkia_2210010396";
    private String username = "root";
    private String password = "";
    public static Connection connectiondb;
    
    public keluarga(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectiondb = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void simpankeluarga (String id_keluarga, String kepala_keluarga, String alamat, String dusun, String rt, String rw, String ekonomi) {
        try {
            String sql = "insert into keluarga (id_keluarga, kepala_keluarga, alamat, dusun, rt, rw, ekonomi) value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            perintah.setString(2, kepala_keluarga);
            perintah.setString(3, alamat);
            perintah.setString(4, dusun);
            perintah.setString(5, rt);
            perintah.setString(6, rw);
            perintah.setString(7, ekonomi);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void ubahkeluarga (String id_keluarga, String kepala_keluarga, String alamat, String dusun, String rt, String rw, String ekonomi) {
        try {
            String sql = "update keluarga set kepala_keluarga = ?, alamat = ?, dusun = ? , rt = ?, rw = ?, ekonomi = ? WHERE id_keluarga = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, kepala_keluarga);
            perintah.setString(2, alamat);
            perintah.setString(3, dusun);
            perintah.setString(4, rt);
            perintah.setString(5, rw);
            perintah.setString(6, ekonomi);
            perintah.setString(7, id_keluarga);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
        
    public void hapuskeluarga (String id_keluarga, String kepala_keluarga, String alamat, String dusun, String rt, String rw, String ekonomi) {
        try {
            String sql = "delete from keluarga where id_keluarga = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void carikeluarga(String paramid_keluarga) {
        try {
          String SQL="SELECT*FROM keluarga WHERE id_keluarga=?";
          PreparedStatement perintah = connectiondb.prepareStatement(SQL);
          perintah.setString(1,paramid_keluarga);
          ResultSet data = perintah.executeQuery();
          while (data.next()) {
              System.out.println("id_keluarga :"+data.getString("id_keluarga"));
              System.out.println("kepala_keluarga :"+data.getString("kepala_keluarga"));
              System.out.println("alamat :"+data.getString("alamat"));
              System.out.println("dusun :"+data.getString("dusun"));
              System.out.println("rt :"+data.getString("rt"));
              System.out.println("rw :"+data.getString("rw"));
              System.out.println("ekonomi :"+data.getString("ekonomi"));
          }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datakeluarga(){
      try {
          Statement stmt  = connectiondb.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM keluarga ORDER BY id_keluarga ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_keluarga")+" | "+
                      baris.getString("kepala_keluarga")+" | "+
                      baris.getString("alamat")+" | "+
                      baris.getString("dusun")+" | "+
                      baris.getString("rt")+" | "+
                      baris.getString("rw")+" | "+
                      baris.getString("ekonomi"));
            }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
    }
}  

