/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import excepciones.AlumnoExistenteException;
import interfaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import objects.Alumno;
import objects.Carrera;
import objects.Fecha;

/**
 *
 * @author ceivg
 */
public class PrincipalFrame extends JFrame{
    
    private EncabezadoPanel pnlEncabezado;
    private BusquedaPanel pnlBusqueda;
    private WorkPanel pnlWork;
    
    private Controlador controlador;
    
    private AlumnoDialog dlgAlumno;
    
    public PrincipalFrame(){
        super("Control Escolar");
        super.setLayout(new BorderLayout());
        super.setSize(800,500);
        super.setLocationRelativeTo(null);
        
        dlgAlumno = new AlumnoDialog(this);
        dlgAlumno.setListener(new AlumnoListener() {
            @Override
            public void aceptarButtonClick(Alumno alumno) {
                try {   
                    controlador.addAlumno(alumno);
                    dlgAlumno.setVisible(false);
                } catch (AlumnoExistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"La matricula ya ha sido insertada anteriormente","Matricula invalida",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        controlador = new Controlador();
        cargaInicial();
        
        pnlEncabezado = new EncabezadoPanel();
        
        pnlWork = new WorkPanel(controlador);
        
        pnlBusqueda = new BusquedaPanel();
     
        super.setJMenuBar(createMenu());
        
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
    private void cargaInicial() {
        Alumno z = new Alumno("014421781","Gerardo","Crisanto","Ulloa",new Fecha(15,12,2000), Carrera.ELECTRONICA);
        Alumno x = new Alumno("x");
        Alumno a = new Alumno("a");
        Alumno b = new Alumno("b");
        Alumno c = new Alumno("c");
        Alumno d = new Alumno("d");

        try {
            controlador.addAlumno(z);
            controlador.addAlumno(a);
            controlador.addAlumno(b);
            controlador.addAlumno(c);
            controlador.addAlumno(d);
            controlador.addAlumno(x);
        } catch (AlumnoExistenteException ex) {
            ex.printStackTrace();
        }
    }
    
    private JMenuBar createMenu(){
        JMenuBar mbMain = new JMenuBar();
        
        JMenu mmArchivo = new JMenu("Archivo");
        JMenuItem miNuevo = new JMenuItem("Nuevo alumno...");
        JMenuItem miSalir = new JMenuItem("Salir");
        miNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dlgAlumno.setVisible(true);
            }
        });
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        mmArchivo.add(miNuevo);
        mmArchivo.addSeparator();
        mmArchivo.add(miSalir);
        
        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem miAcerca = new JMenuItem("Acerca de...");
        mmAyuda.add(miAcerca);
        
        mbMain.add(mmArchivo);
        mbMain.add(mmAyuda);
        
        return mbMain;
    }

}
