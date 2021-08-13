package co.edu.utp.misiontic2022.c2.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoBancoVo;

public class FrmReto5 extends JFrame {

    private ConsultasController controller;
    private JTable tabla;
    private JComboBox<String> comboBox;

    public FrmReto5() {
        controller = new ConsultasController();
        iniciarComponentes();
        setLocationRelativeTo(null);
    }

    // Se inicializan componentes del Frame

    private void iniciarComponentes() {
        setTitle("Misión TIC 2022 UTP - Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd1 = new JTabbedPane();
        getContentPane().add(tbd1, BorderLayout.CENTER);

        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        tbd1.addTab("Proyectos Financiados Por Banco", panel1);

        var panelVariable = new JPanel();
        panelVariable.add(new JLabel(" Banco "));

        var label = new JLabel(" Seleccione un Banco ");
        panelVariable.add(label);

        comboBox = new JComboBox<>();
        panelVariable.add(comboBox);
        LoadBancos(); 
        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            label.setText(comboBox.getSelectedItem().toString());
        }});

        var btnConsulta = new JButton("Consultar");
        btnConsulta.addActionListener(e -> consutarProyectosPorBanco(label.getText().trim()));
        panelVariable.add(btnConsulta);
        panel1.add(panelVariable, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel1.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void consutarProyectosPorBanco(String dato){
        try {
            var lista = controller.listaProyectoBanco(dato);
            var tableModel = new ProyectoTableModel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    private class ProyectoTableModel extends AbstractTableModel {
        private List<ProyectoBancoVo> data;
        
        public void setData(List<ProyectoBancoVo> data) {
            this.data = data;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                case 4:
                    return Integer.class;
                case 2:
                case 3:
                case 5:
                    return String.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "ID";
                case 1:
                    return "CONSTRUCTORA";
                case 2:
                    return "CIUDAD";
                case 3:
                    return "CLASIFICACION";
                case 4:
                    return "ESTRATO";
                case 5:
                    return "LIDER";

            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var proyecto = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return proyecto.getId();
                case 1:
                    return proyecto.getConstructora();
                case 2:
                    return proyecto.getCiudad();
                case 3:
                    return proyecto.getClasificacion();
                case 4:
                    return proyecto.getEstrato();
                case 5:
                    return proyecto.getLider();
            }
            return null;
        }
    }
    public void LoadBancos() {
        // Trae los bancos del Controller y los carga en el ComboBox
        comboBox.addItem("");
        try {
            var lista = controller.listaBancos();
            for (int i = 0; i < lista.size(); i++){
                comboBox.addItem(lista.get(i).getBanco());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}