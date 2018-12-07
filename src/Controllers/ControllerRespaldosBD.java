/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelRespaldosBD;
import javax.swing.JOptionPane;

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
        String host = "noutectyspdf.ddns.net";
        String puert = "3306";
        modelRespaldosBD.respaldosDB(host, puert, usuar, password, BD);
        JOptionPane.showMessageDialog(null, "La base de datos: ferreteriasacme\n ha sido respaldada");
    }

}
