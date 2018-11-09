/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelInicio;
import Views.ViewInicio;

/**
 *
 * @author Norberto
 */
public class ControllerInicio {
    Models.ModelInicio modelInicio;
    Views.ViewInicio viewInicio;

    public ControllerInicio(ModelInicio modelInicio, ViewInicio viewInicio) {
        this.modelInicio = modelInicio;
        this.viewInicio = viewInicio;
    }
    
}
