/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasMencobaDBPertemuan4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

/**
 *
 * @author egty
 */
public class DeletePertemuanEmpat {
    
    public static void main(String[] args) {
        String QUERY = "DELETE FROM karyawan WHERE id_karyawan = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");
            pstmt = conn.prepareStatement(QUERY );
            
            
            System.out.println("Masukkan id karyawan yang ingin dihapus: ");
            Scanner scann = new Scanner(System.in);
            String hapus = scann.nextLine();
//            int hapusid = Integer.parseInt(hapus);
            
            pstmt.setString(1, hapus);
            int k = pstmt.executeUpdate();
            
            if (k > 0) {
                System.out.println("Hapus id_karyawan " + hapus + " BERHASIL. ");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
            finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}
