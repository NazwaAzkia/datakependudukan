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
public class mutasi_warga {
    private String databaseName = "nazwaazkia_2210010396";
    private String username = "root";
    private String password = "";
    public static Connection connectiondb;
    
    public mutasi_warga(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectiondb = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void simpanmutasiwarga (String id_mutasi, String no_ktp, Date tgl_warga, String jenis_mutasi, Date tanggal, String keterangan) {
        try {
            String sql = "insert into mutasi_warga (id_mutasi, no_ktp, tgl_warga, jenis_mutasi, tanggal, keterangan) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_mutasi);
            perintah.setString(2, no_ktp);
            perintah.setDate(3, tgl_warga);
            perintah.setString(4, jenis_mutasi);
            perintah.setDate(5, tanggal);
            perintah.setString(6, keterangan);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void ubahmutasiwarga (String id_mutasi, String no_ktp, Date tgl_warga, String jenis_mutasi, Date tanggal, String keterangan) {
        try {
            String sql = "update mutasi_warga set no_ktp = ?, tgl_warga = ?, jenis_mutasi = ? , tanggal = ?, keterangan = ? where id_mutasi = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            perintah.setDate(2, tgl_warga);
            perintah.setString(3, jenis_mutasi);
            perintah.setDate(4, tanggal);
            perintah.setString(5, keterangan);
            perintah.setString(6, id_mutasi);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
        
    public void hapusmutasiwarga (String id_mutasi) {
        try {
            String sql = "delete from mutasi_warga where id_mutasi = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_mutasi);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void carimutasi_warga(String paramid_mutasi) {
        try {
          String SQL="SELECT*FROM mutasi_warga WHERE id_mutasi=?";
          PreparedStatement perintah = connectiondb.prepareStatement(SQL);
          perintah.setString(1,paramid_mutasi);
          ResultSet data = perintah.executeQuery();
          while (data.next()) {
              System.out.println("id_mutasi :"+data.getString("id_mutasi"));
              System.out.println("no_ktp :"+data.getString("no_ktp"));
              System.out.println("tgl_warga :"+data.getDate("tgl_warga"));
              System.out.println("jenis_mutasi :"+data.getString("jenis_mutasi"));
              System.out.println("tanggal :"+data.getDate("tanggal"));
              System.out.println("keterangan :"+data.getString("keterangan"));
          }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datamutasiwarga(){
      try {
          Statement stmt  = connectiondb.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM mutasi_warga ORDER BY id_mutasi ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_mutasi")+" | "+
                      baris.getString("no_ktp")+" | "+
                      baris.getDate("tgl_warga")+" | "+
                      baris.getString("jenis_mutasi")+" | "+
                      baris.getDate("tanggal")+" | "+
                      baris.getString("keterangan"));
            }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
    }
}
