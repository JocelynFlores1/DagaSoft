/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author beto
 */
public class ControllerConstructoresPrincipal {

    public void principalControllersMenu() {
        Models.ModelProveedores modelProveedores = new Models.ModelProveedores();
        Views.ViewProveedores viewProveedores = new Views.ViewProveedores();
        Controllers.ControllerProveedores controllerProveedores = new Controllers.ControllerProveedores(modelProveedores, viewProveedores);

        Models.ModelClientes modelClientes = new Models.ModelClientes();
        Views.ViewClientes viewClientes = new Views.ViewClientes();
        Controllers.ControllerClientes controllerClientes = new Controllers.ControllerClientes(modelClientes, viewClientes);

        Object[] controllers = new Object[2];
        controllers[0] = controllerProveedores;
        controllers[1] = controllerClientes;

        Models.ModelMain modelMain = new Models.ModelMain();
        Views.ViewMenu viewMenu = new Views.ViewMenu();
        Controllers.ControllerMain controllerMain = new Controllers.ControllerMain(modelMain, viewMenu, controllers);
    }
}
