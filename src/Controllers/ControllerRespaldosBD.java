/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelRespaldosBD;
import java.io.IOException;

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
        try {
            modelRespaldosBD.respaldosDB();
        } catch (IOException ex) {
            System.out.println("Error 01 Controller respaldos:  " + ex );
        }
    }
}
