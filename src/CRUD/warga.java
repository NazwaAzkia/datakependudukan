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
public class warga {
    private String databaseName = "nazwaazkia_2210010396";
    private String username = "root";
    private String password = "";
    public static Connection connectiondb;
    
    public warga(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectiondb = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanwarga (String no_ktp, String id_keluarga, String nama, String agama, String t_lahir,Date tgl_lahir, String j_kel, String go_darah, String w_negara, String pendidikan, String pekerjaan, String s_nikah, String status) {
        try {
            String sql = "insert into warga (no_ktp, id_keluarga, nama, agama, t_lahir,tgl_lahir, j_kel, go_darah, w_negara, pendidikan, pekerjaan, s_nikah, status) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            perintah.setString(2, id_keluarga);
            perintah.setString(3, nama);
            perintah.setString(4, agama);
            perintah.setString(5, t_lahir);
            perintah.setDate(6, tgl_lahir);
            perintah.setString(7, j_kel);
            perintah.setString(8, go_darah);
            perintah.setString(9, w_negara);
            perintah.setString(10, pendidikan);
            perintah.setString(11, pekerjaan);
            perintah.setString(12, s_nikah);
            perintah.setString(13, status);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void ubahwarga (String no_ktp, String id_keluarga, String nama, String agama, String t_lahir,Date tgl_lahir, String j_kel, String go_darah, String w_negara, String pendidikan, String pekerjaan, String s_nikah, String status) {
        try {
            String sql = "update warga set id_keluarga =?, nama =?, agama=?, t_lahir=?, tgl_lahir=?, j_kel=?, go_darah=?, w_negara=?, pendidikan=?, pekerjaan=?, s_nikah=?, status=? where no_ktp = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            perintah.setString(2, nama);
            perintah.setString(3, agama);
            perintah.setString(4, t_lahir);
            perintah.setDate(5, tgl_lahir);
            perintah.setString(6, j_kel);
            perintah.setString(7, go_darah);
            perintah.setString(8, w_negara);
            perintah.setString(9, pendidikan);
            perintah.setString(10, pekerjaan);
            perintah.setString(11, s_nikah);
            perintah.setString(12, status);
            perintah.setString(13, no_ktp);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
        
    public void hapuswarga (String no_ktp, String id_keluarga, String nama, String agama, String t_lahir,Date tgl_lahir, String j_kel, String go_darah, String w_negara, String pendidikan, String pekerjaan, String s_nikah, String status) {
        try {
            String sql = "delete from warga where no_ktp = ?";
            PreparedStatement perintah = connectiondb.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void cariwarga(String paramno_ktp) {
        try {
          String SQL="SELECT*FROM warga WHERE no_ktp=?";
          PreparedStatement perintah = connectiondb.prepareStatement(SQL);
          perintah.setString(1,paramno_ktp);
          ResultSet data = perintah.executeQuery();
          while (data.next()) {
              System.out.println("no_ktp :"+data.getString("no_ktp"));
              System.out.println("id_keluarga :"+data.getString("id_keluarga"));
              System.out.println("nama :"+data.getString("nama"));
              System.out.println("agama :"+data.getString("agama"));
              System.out.println("t_lahir :"+data.getString("t_lahir"));
              System.out.println("tgl_lahir :"+data.getDate("tgl_lahir"));
              System.out.println("j_kel :"+data.getString("j_kel"));
              System.out.println("go_darah :"+data.getString("go_darah"));
              System.out.println("w_negara :"+data.getString("w_negara"));
              System.out.println("pendidikan :"+data.getString("pendidikan"));
              System.out.println("pekerjaan :"+data.getString("pekerjaan"));
              System.out.println("s_nikah :"+data.getString("s_nikah"));
              System.out.println("status :"+data.getString("status"));
          }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datawarga(){
      try {
          Statement stmt  = connectiondb.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM warga ORDER BY no_ktp ASC");
          while(baris.next()){
              System.out.println(baris.getString("no_ktp")+" | "+
                      baris.getString("id_keluarga")+" | "+
                      baris.getString("nama")+" | "+
                      baris.getString("agama")+" | "+
                      baris.getString("t_lahir")+" | "+
                      baris.getDate("tgl_lahir")+" | "+
                      baris.getString("j_kel")+" | "+
                      baris.getString("go_darah")+" | "+
                      baris.getString("w_negara")+" | "+
                      baris.getString("pendidikan")+" | "+
                      baris.getString("pekerjaan")+" | "+
                      baris.getString("s_nikah")+" | "+
                      baris.getString("status"));
            }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
    }
}
