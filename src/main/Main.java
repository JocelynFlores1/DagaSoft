/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controllers.ControllerClientes;
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
    }

}
