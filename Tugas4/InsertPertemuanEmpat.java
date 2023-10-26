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
public class InsertPertemuanEmpat {

    static final String db_URL = "jdbc:postgresql://localhost:5433/Pbo_Tugas";
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {

        try ( Scanner scan = new Scanner(System.in);  
            Connection conn = DriverManager.getConnection(db_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Koneksi sukses!");
                
                System.out.println("masukkan id departemen: ");
                String id = scan.nextLine();
                
                System.out.println("masukkan id karyawan : ");
                String id_karyawan = scan.nextLine();

                System.out.println("masukkan nama : ");
                String nama = scan.nextLine();

                System.out.println("masukkan alamat : ");
                String alamat = scan.nextLine();

                String QUERY = "INSERT INTO karyawan(id_dep, id_karyawan, nama, alamat) VALUES (?,?,?,?)";

                try ( PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, id_karyawan);
                    preparedStatement.setString(3, nama);
                    preparedStatement.setString(4, alamat);
                    preparedStatement.executeUpdate();

                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(InsertPertemuanEmpat.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    }

