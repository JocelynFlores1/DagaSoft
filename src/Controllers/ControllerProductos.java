/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelProductos;
import Views.ViewProductos;

/**
 *
 * @author beto
 */
public class ControllerProductos {
    public Models.ModelProductos modelProductos;
    public Views.ViewProductos viewProductos;

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
    }
    
}
