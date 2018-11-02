/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelCompras;
import Views.ViewCompras;

/**
 *
 * @author beto
 */
public class ControllerCompras {
    public Models.ModelCompras modelCompras;
    public Views.ViewCompras viewCompras;

    public ControllerCompras(ModelCompras modelCompras, ViewCompras viewCompras) {
        this.modelCompras = modelCompras;
        this.viewCompras = viewCompras;
    }
    
}
