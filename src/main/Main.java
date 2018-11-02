/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Models.ModelMain;
import Views.ViewMenu;

/**
 *
 * @author Norberto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Models.ModelLogin modelLogin = new Models.ModelLogin();
        Views.ViewLogin viewLogin = new Views.ViewLogin();
        Controllers.ControllerLogin controllerLogin = new Controllers.ControllerLogin(modelLogin, viewLogin);
        
        Models.ModelProveedores modelProveedores = new Models.ModelProveedores();
        Views.ViewProveedores viewProveedores = new Views.ViewProveedores();
        Controllers.ControllerProveedores controllerProveedores = new Controllers.ControllerProveedores(modelProveedores, viewProveedores);

        Object[] controllers = new Object[1];
        controllers[0] = controllerProveedores;
        
        Models.ModelMain modelMain = new Models.ModelMain();
        Views.ViewMenu viewMenu = new  Views.ViewMenu();
        Controllers.ControllerMain controllerMain = new Controllers.ControllerMain(modelMain, viewMenu, controllers);
    }

}
