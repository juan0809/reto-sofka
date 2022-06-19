/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Buscarnaves;
import Modelo.Naves;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian
 */
public class Controladornaves implements ActionListener {

    private Naves n;
    private Buscarnaves b;
    private Menu m;

    public Controladornaves(Naves n, Buscarnaves b, Menu m) {
        this.n = n;
        this.b = b;
        this.m = m;
        this.m.BtnGuardar.addActionListener(this);
        this.m.BtnEliminar.addActionListener(this);
        this.m.BtnGuardar.addActionListener(this);
        this.m.BtnModificar.addActionListener(this);
    }

    public void iniciar() {
        m.setTitle("Naves menu");
        m.setLocationRelativeTo(null);

    }

    @Override
    //se hara el registro
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m.BtnGuardar) {
            n.setNombre_nave(m.Txtnombre.getText());
            n.setDatos(m.Jdatos.getText());
            n.setPasajeros(Integer.parseInt(m.txtpasajeros.getText()));
            if (b.ingresar(n)) {

                JOptionPane.showMessageDialog(null, "registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "registro no guardado");

            }
        }

        if (e.getSource() == m.BtnModificar) {
            n.setNombre_nave(m.Txtnombre.getText());
            n.setDatos(m.Jdatos.getText());
            n.setPasajeros(Integer.parseInt(m.txtpasajeros.getText()));
            if (b.ingresar(n)) {

                JOptionPane.showMessageDialog(null, "registro actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "registro actualizado");

            }
        }
        if (e.getSource() == m.BtnBuscar) {
            n.setNombre_nave(m.Txtnombre.getText());
            n.setDatos(m.Jdatos.getText());
            n.setPasajeros(Integer.parseInt(m.txtpasajeros.getText()));
            if (b.buscar(n)) {
                m.jTextArea1.setText(m.Txtnombre.getText());
                m.jTextArea1.setText(m.Jdatos.getText());
                m.jTextArea1.setText(String.valueOf(m.txtpasajeros.getText()));
                JOptionPane.showMessageDialog(null, "registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "registro no guardado");

            }
        }

    }

}
