/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelClientes;
import Views.ViewClientes;

/**
 *
 * @author beto
 */
public class ControllerClientes {
    public Models.ModelClientes modelClientes;
    public Views.ViewClientes viewClientes;

    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
    }
    
}
