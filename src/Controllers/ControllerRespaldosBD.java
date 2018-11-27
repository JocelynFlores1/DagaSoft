/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelRespaldosBD;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author beto
 */
public class ControllerRespaldosBD {

    ModelRespaldosBD modelRespaldosBD;

    public ControllerRespaldosBD(ModelRespaldosBD modelRespaldosBD) {
        this.modelRespaldosBD = modelRespaldosBD;
    }

    public void respaldo() {

        String BD = "ferreteriasacme";
        String usuar = "dagasoft";
        String password = "ferreteriasacme";
        String host = "192.168.1.97";
        String puert = "3306";
        try {
            modelRespaldosBD.respaldosDB(host, puert, usuar, password, BD);
            JOptionPane.showMessageDialog(null, "La base de datos: ferreteriasacme\n ha sido respaldada");
        } catch (IOException ex) {
            Logger.getLogger(ControllerRespaldosBD.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
