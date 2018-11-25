/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Norberto
 */
public class ModelRespaldosBD {

    public void respaldosDB() throws IOException {
        try {
            Runtime runtime = Runtime.getRuntime();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mysql://noutectyspdf.ddns.net:3306/ferreteriasacme";
            String user = "dagasoft";
            String password = "ferreteriasacme";
            Connection con = DriverManager.getConnection(url, user, password);
            String path = null;

            Process p = runtime.exec("mysqldump  -datatable -p123 --add-drop-database server -B datatable -r" + path);
            //  "C:/xampp/mysql/bin/mysqldump.exe -uroot -p --add-drop-database server  -B newproject -r"+path); 

            int processComplete = p.waitFor();
            if (processComplete == 1) {
                System.out.println("Backup Created Succuss");
            } else {
                System.out.println("Can't Create backup");
            }

        } catch (IOException | InterruptedException | SQLException e) {
            System.out.println("Error model backup 01: " + e);
        }
    }

}
