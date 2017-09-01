package tpmetodos.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
* Clase que implementa HeaderRenderer para Formatear Tabla.
* @author Agu
*/
public class HeaderRendererTablas implements TableCellRenderer {

    private DefaultTableCellRenderer renderer;

    // Formato de Columnas //
    private DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(){ 

		private static final long serialVersionUID = 1L;

		@Override 
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            Font fuente = new Font("Inherited", Font.BOLD, 12); 
            //this.setForeground(new Color(55,115,2)); //
            table.setSelectionBackground(Color.black);
            table.setSelectionForeground(Color.lightGray);
            this.setFont(fuente); 
            return this; 
        } 
    };
    
    /**
     * Constructor:
     * 
     * @param table 
     */
    public HeaderRendererTablas(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setRowHeight(25); // Ajustar Tam Filas //
        table.setRowMargin(5); // Sombra de Filas //
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont((table.getTableHeader()).getFont().deriveFont(Font.BOLD,12));
        table.getTableHeader().setReorderingAllowed(false);
        
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    /**
     * 
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param col
     * @return 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
    }    
    
}