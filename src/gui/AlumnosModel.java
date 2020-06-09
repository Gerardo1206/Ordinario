/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import javax.swing.table.AbstractTableModel;
import objects.Alumno;


/**
 *
 * @author ceivg
 */
public class AlumnosModel extends AbstractTableModel {
    
    private Controlador oControlador;
    
    public AlumnosModel(Controlador controlador){
        oControlador=controlador;
    }

    @Override
    public int getRowCount() {
        return oControlador.getAlumnosCount();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = oControlador.getAlumno(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getMatricula();
            case 1:
                return a.getNombre();
            case 2:
                return a.getPaterno();
            case 3:
                return a.getMaterno();
            case 4:
                return a.getFechaNacimiento();
            case 5:
                return a.getCarrera();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Matricula";
            case 1:
                return "Nombre";
            case 2:
                return "A.Paterno";
            case 3:
                return "A.Materno";
            case 4:
                return "Fecha nacimiento";
            case 5:
                return "Carrera ";
            default:
                throw new AssertionError();
        }
    }
    
    
    
}
