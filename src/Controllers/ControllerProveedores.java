/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelProveedores;
import Views.ViewProveedores;

/**
 *
 * @author Norberto
 */
public class ControllerProveedores {
    public Models.ModelProveedores modelProveedores;
    public Views.ViewProveedores viewProveedores;

    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
    }
    
}
