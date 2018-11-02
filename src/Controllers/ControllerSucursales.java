/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelSucursales;
import Views.ViewSucursales;

/**
 *
 * @author beto
 */
public class ControllerSucursales {
    public Models.ModelSucursales modelSucursales;
    public Views.ViewSucursales viewSucursales;

    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
    }
    
}
