/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import objects.Alumno;
import objects.Carrera;
import objects.Fecha;

/**
 *
 * @author ceivg
 */
public class AlumnoDialog extends JDialog{
    
    private JPanel pnlWork;
    private JPanel pnlBotones;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private AlumnoListener listener;
    
    public AlumnoDialog(JFrame owner){
        super(owner,"Datos del alumno",true);
        super.setSize(400,300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(owner);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno alumno = new Alumno("014421782", "Pedro", "Martinez","Cruz",new Fecha(12,12,2012),Carrera.ARQUITECTURA);
                listener.aceptarButtonClick(alumno);
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               AlumnoDialog.this.setVisible(false);
            }
        });
        
        pnlWork = new JPanel();
        pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlBotones.add(btnAceptar);
        pnlBotones.add(btnCancelar);
       
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);
        
        
        super.setVisible(false);
    }
    
    public void setListener(AlumnoListener listener){
        this.listener=listener; 
    }
    
}
