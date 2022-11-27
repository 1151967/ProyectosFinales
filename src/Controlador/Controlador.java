/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.daoVehiculo;
import Modelo.Vehiculo;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SrLob
 */
public class Controlador implements ActionListener{
    Vista v;
    Vehiculo ve;
    daoVehiculo dao;
    
    public static void main(String[] args) {
        Controlador c = new Controlador();
    }

    public Controlador() {
        v = new Vista();
        dao = new daoVehiculo();
        v.btnAgregar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.btnReiniciar.addActionListener(this);
        v.btnTotalizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == v.btnAgregar){
        
            ve = new Vehiculo();
            ve.setPlaca(v.txtPlaca.getText());
            ve.setFecha(v.txtFecha.getText());
            ve.setModelo(Integer.parseInt(v.txtModelo.getText()));
            ve.setTipo(v.cbTipo.getSelectedItem().toString());
            limpiarcampos();
        
             JOptionPane.showMessageDialog(this.v, "Se inserto el producto exitosamente.");
        }
        
        if(!dao.create(ve)){
        
             JOptionPane.showMessageDialog(this.v, "No se inserto el producto exitosamente.");
        }
        
    }
    
    public void limpiarcampos(){
    v.txtPlaca.setText("");
   v.txtCarro.setText("");
   v.txtFecha.setText("");
 v.txtModelo.setText("");
 v.cbTipo.setSelectedIndex(0);
        
    }
    
}
