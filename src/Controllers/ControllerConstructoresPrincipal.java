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
        Models.ModelClientes modelClientes = new Models.ModelClientes();
        Views.ViewClientes viewClientes = new Views.ViewClientes();
        Controllers.ControllerClientes controllerClientes = new Controllers.ControllerClientes(modelClientes, viewClientes);

        Models.ModelCompras modelCompras = new Models.ModelCompras();
        Views.ViewCompras viewCompras = new Views.ViewCompras();
        Controllers.ControllerCompras controllerCompras = new Controllers.ControllerCompras(modelCompras, viewCompras);

        Models.ModelEmpleados modelEmpleados = new Models.ModelEmpleados();
        Views.ViewEmpleados viewEmpleados = new Views.ViewEmpleados();
        Controllers.ControllerEmpleados controllerEmpleados = new Controllers.ControllerEmpleados(modelEmpleados, viewEmpleados);

        Models.ModelProductos modelProductos = new Models.ModelProductos();
        Views.ViewProductos viewProductos = new Views.ViewProductos();
        Controllers.ControllerProductos controllerProductos = new Controllers.ControllerProductos(modelProductos, viewProductos);

        Models.ModelProveedores modelProveedores = new Models.ModelProveedores();
        Views.ViewProveedores viewProveedores = new Views.ViewProveedores();
        Controllers.ControllerProveedores controllerProveedores = new Controllers.ControllerProveedores(modelProveedores, viewProveedores);

        Models.ModelSucursales modelSucursales = new Models.ModelSucursales();
        Views.ViewSucursales viewSucursales = new Views.ViewSucursales();
        Controllers.ControllerSucursales controllerSucursales = new Controllers.ControllerSucursales(modelSucursales, viewSucursales);

        Object[] controllers = new Object[6];
        controllers[0] = controllerProveedores;
        controllers[1] = controllerClientes;
        controllers[2] = controllerCompras;
        controllers[3] = controllerEmpleados;
        controllers[4] = controllerProductos;
        controllers[5] = controllerSucursales;

        Models.ModelMain modelMain = new Models.ModelMain();
        Views.ViewMenu viewMenu = new Views.ViewMenu();
        Controllers.ControllerMain controllerMain = new Controllers.ControllerMain(modelMain, viewMenu, controllers);
    }
}
