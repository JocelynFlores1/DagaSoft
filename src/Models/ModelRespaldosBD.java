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

    public void respaldosDB(String host, String puert, String usuar, String password, String BD) throws IOException {
        Process p = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump --host=192.168.1.97 "
                + "-udagasoft -pferreteriasacme -B ferreteriasacme");

        InputStream is = p.getInputStream();//Pedimos la entrada
        FileOutputStream fos = new FileOutputStream("src/bd/backup_ferreteriasacme.sql"); //creamos el archivo para le respaldo
        byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

        int leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.
        while (leido > 0) {
            fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
            leido = is.read(buffer);
        }

        fos.close();//Cierra respaldo
    }

    /**
     * try { JFileChooser jfc = new JFileChooser(); jfc.setVisible(true);
     * ModelConexion mc = new ModelConexion();
     *
     * Runtime runtime = Runtime.getRuntime(); String path = null; Process run =
     * Runtime.getRuntime().exec( "cmd /c mysqldump --host=" + host + " --port="
     * + puert + " --user=" + usuar + " --password=" + password + "
     * --complete-insert --extended-insert" + " " + "" + BD + ""); //se guarda
     * en memoria el backup //
     *
     * Process p = runtime.exec("mysqldump -datatable -p123 --add-drop-database
     * server -B datatable -r" + path); // "C:/xampp/mysql/bin/mysqldump.exe
     * -uroot -p --add-drop-database server -B newproject -r"+path); * int
     * processComplete = run.waitFor(); if (processComplete == 1) {
     * System.out.println("Backup Created Succuss"); } else {
     * System.out.println("Can't Create backup"); }
     *
     * } catch (IOException e) { System.out.println("Error model backup 01: " +
     * e); }
     *
     */
}
