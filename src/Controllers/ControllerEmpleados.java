/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelEmpleados;
import Views.ViewEmpleados;

/**
 *
 * @author beto
 */
public class ControllerEmpleados {
    public Models.ModelEmpleados modelEmpleados;
    public Views.ViewEmpleados viewEmpleados;

    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
    }
    
}
