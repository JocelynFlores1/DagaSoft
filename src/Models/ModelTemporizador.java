/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Calendar;
import java.util.TimerTask;

/**
 *
 * @author Norberto
 */
public class ModelTemporizador extends TimerTask {

    @Override
    public void run() {
        Calendar diaActual = Calendar.getInstance();
        Models.ModelRespaldosBD respaldosBD = new Models.ModelRespaldosBD();
        Controllers.ControllerRespaldosBD controllerRespaldosBD = new Controllers.ControllerRespaldosBD(respaldosBD);

        switch (diaActual.get(Calendar.DAY_OF_WEEK)) {
            case 1: // Es domingo puedes seguir durmiendo y se apaga el despertador
                System.out.println("Zzz...");
                this.cancel();
                System.out.println("Temporizador apagado.");
                break;
            case 2: // Durante los dias de diario suena el despertador
                controllerRespaldosBD.respaldo();
                System.out.println("Respaldo automatico");
            case 3:
                controllerRespaldosBD.respaldo();
                System.out.println("Respaldo automatico");
                break;
            case 4:
                controllerRespaldosBD.respaldo();
                System.out.println("Respaldo automatico");
                break;
            case 5:
                controllerRespaldosBD.respaldo();
                System.out.println("Respaldo automatico");
                break;
            case 6:
                controllerRespaldosBD.respaldo();
                System.out.println("Respaldo automatico");
                break;
            case 7: // Es sabado puedes seguir durmiendo
                System.out.println("Zzz...");
                break;
        }
    }
}
