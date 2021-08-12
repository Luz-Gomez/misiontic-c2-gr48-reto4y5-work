package co.edu.utp.misiontic2022.c2.view;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoBancoVo;

public class FrmReto5 extends JFrame {

    private ConsultasController controller;
    private JTable tabla;

    public FrmReto5() {
        controller = new ConsultasController();
        iniciarUI();
        setLocationRelativeTo(null);
    }

    private void iniciarUI() {
        setTitle("Misión TIC 2022 UTP - Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Proyectos Financiados Por Banco", panel);

        var panelVariable = new JPanel();
        panelVariable.add(new JLabel("Banco"));
        var txtBanco = new JTextField(15);
        panelVariable.add(txtBanco);

        var btnConsulta = new JButton("Consultar");
        btnConsulta.addActionListener(e -> consutarProyectosPorBanco(txtBanco.getText().trim()));
        panelVariable.add(btnConsulta);
        panel.add(panelVariable, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
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
}
