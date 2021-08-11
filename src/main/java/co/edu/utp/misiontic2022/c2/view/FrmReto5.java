package co.edu.utp.misiontic2022.c2.view;

import javax.swing.JFrame;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;

public class FrmReto5 extends JFrame {

    private ConsultasController controlador;

    public FrmReto5() {
        controlador = new ConsultasController();
        iniciarUI();
        setLocationRelativeTo(null);
    }

    private void iniciarUI() {
        setTitle("MinTic UTP Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        
    }
    
}
