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
public class database {
    private String databaseName = "nazwaazkia_2210010396";
    private String username = "root";
    private String password = "";
    public static Connection connectiondb;
    
    public database(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectiondb = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void simpanuji (String nik, String nama, String telp, String Alamat) {
        try {
            String sql = "insert into uji (nik, nama, telp, Alamat) value (?, ?, ?, ?)";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, Alamat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void ubahuji (String nik, String nama, String telp, String Alamat) {
        try {
            String sql = "update uji set nama nama = ?, telp = ?, Alamat=? where nik = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, Alamat);
            perintah.setString(4, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
        
    public void hapusuji (String nik, String nama, String telp, String Alamat) {
        try {
            String sql = "delete from uji where nik = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariuji(String paramnik) {
        try {
          String SQL="SELECT*FROM uji WHERE nik=?";
          PreparedStatement perintah = connectiondb.prepareStatement(SQL);
          perintah.setString(1,paramnik);
          ResultSet data = perintah.executeQuery();
          while (data.next()) {
              System.out.println("nik :"+data.getString("nik"));
              System.out.println("nama :"+data.getString("nama"));
              System.out.println("telp :"+data.getString("telp"));
              System.out.println("Alamat :"+data.getString("Alamat"));
          }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datauji(){
      try {
          Statement stmt  = connectiondb.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM uji ORDER BY nik ASC");
          while(baris.next()){
              System.out.println(baris.getString("nik")+" | "+
                      baris.getString("nama")+" | "+
                      baris.getString("telp")+" | "+
                      baris.getString("Alamat"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
    }
}
