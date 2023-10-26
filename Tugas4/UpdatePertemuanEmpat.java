/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasMencobaDBPertemuan4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egty
 */
public class UpdatePertemuanEmpat {
    
    static final String db_URL = "jdbc:postgresql://localhost:5433/Pbo_Tugas";
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        
        try ( Scanner scan = new Scanner(System.in);  
            Connection conn = DriverManager.getConnection(db_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Koneksi sukses!");
        
                System.out.println("Masukkan id lama yang akan diperbarui : ");
                String idLama = scan.nextLine();
                
                System.out.println("Masukkan id departemen : ");
                String id_dep = scan.nextLine();
                
                System.out.println("Masukkan id karywan : ");
                String id_kar = scan.nextLine();
                               
                System.out.println("Masukkan nama baru : ");
                String namaBaru = scan.nextLine();
                
                System.out.println("Masukkan alamat baru : ");
                String alamatBaru = scan.nextLine();
                
                String QUERY = "UPDATE karyawan set id_dep = ?, id_karyawan = ?, nama = ?, alamat = ? WHERE id_karyawan = ?";
       
                try ( PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
                    preparedStatement.setString(1, id_dep);
                    preparedStatement.setString(2, id_kar);
                    preparedStatement.setString(3, namaBaru);
                    preparedStatement.setString(4, alamatBaru);
                    preparedStatement.setString(5, idLama);
                    preparedStatement.executeUpdate();
                    
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if(rowsUpdated > 0){
                        System.out.println("Data berhasil diupdate");
                    }else{
                        System.out.println("data dengan id yang dimasukkan tidak ditemnukan.");
                    }

                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        
        
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePertemuanEmpat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
