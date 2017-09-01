package tpmetodos.ui.tablas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import tpmetodos.dtos.ClienteDTO;
import tpmetodos.servicio.excepciones.VentaInvalidaException;
import tpmetodos.ui.mensajes.MensajeInformacionExito;
import tpmetodos.utils.HeaderRendererTablas;

public class JTableBuscarCliente extends JTable {

	private static final long serialVersionUID = 1L;
	private Object[] tableCabecera = new Object [] {"ID Cliente","Apellido","Nombre","DNI", "Fecha Nacimiento"};
	private Object [][] tableFilas = new Object [][] {};
	private List<ClienteDTO> contenidoCeldas = new ArrayList<ClienteDTO>();
	
	/**
	 * Constructor
	 * 
	 */
	public JTableBuscarCliente(){
		
		// TableHeader //
		JTableHeader header = this.getTableHeader();
		header.setDefaultRenderer(new HeaderRendererTablas(this)); // Estilo de Tabla
		//this.setHorizontalAlignment(SwingConstants.CENTER); // Centrar Columnas
		
		this.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		this.setModel(new DefaultTableModel(tableFilas, tableCabecera) {
            /* Serializacion */
            private static final long serialVersionUID = 1L;

            /* Propiedades de la Tabla */
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
				
		this.setVisible(true);
		
	}
	
	
    /**
     * LLena la tabla con los valores de la lista Cliente DTO
     * @param table
     * @param resultados 
     */
    public void agregarFilasTabla(LinkedList<ClienteDTO> resultados){
    	for(ClienteDTO filasClientes : resultados){
    		agregarFilaTabla(filasClientes);
    	}
    }
    
    /**
     * Agrega una fila a la tabla en base a un DTO Cliente
     * @param String[] fila
     */
    public void agregarFilaTabla(ClienteDTO resultado){
    	
    	contenidoCeldas.add(resultado);
    	
    	int cantidadColumnas = this.getColumnCount();
	
        String[] fila = new String[cantidadColumnas];
        
        // ID CLiente
        fila[0] = String.valueOf(resultado.getId());  
 
            // Apellido Cliente
        if(resultado.getApellidos()==null){
            fila[1]="";
        }
        else{
        	fila[1]= resultado.getApellidos();
        }
        
        // Nombre Cliente
        if(resultado.getNombres()==null){
            fila[2]="";
        }
        else{
        	fila[2]= resultado.getNombres();
        }
        
        // DNI Cliente
        if(resultado.getDni()==null){
            fila[3]="";
        }
        else{
        	fila[3]= String.valueOf(resultado.getDni());  
        }

        agregarFilaTabla(fila);
    }
    
    /**
     * Agrega una fila a la tabla en vase a valores String
     * @param String[] fila
     */
    private void agregarFilaTabla(String[] fila){
    	((DefaultTableModel)this.getModel()).addRow(fila);  // Agregar Filas //  
    }
    
    /**
     * Devuelve un Cliente DTO con ID Cliente
     * @return ClienteDTO
     */
    public ClienteDTO filaSeleccionada() throws VentaInvalidaException{
    	    	
    	ClienteDTO fila = null;
    	
    	// ESCUCHAR SELECCION FILA
    	int filaSeleccionada = this.getSelectedRow();
    	
        if(filaSeleccionada==-1){
            new MensajeInformacionExito(null,"Recuerde","Primero debe Seleccionar un cliente para asociar venta");
            throw new VentaInvalidaException("Cliente no seleccionado");
        }
        else{
        	int id = Integer.valueOf((String) this.getValueAt(filaSeleccionada, 0));        
        	fila = devolverfilaDTOCliente(id);
        	return fila;
        }

    }
    
    /**
     * Borra todas las celdas de la Tabla
     */
    public void borrarTabla(){
		for(int i=0; i<this.getRowCount(); i++){
			((DefaultTableModel)this.getModel()).removeRow(0);
			//((DefaultTableModel)this.getModel()).setValueAt("", i, j);
		}
		contenidoCeldas = new ArrayList<ClienteDTO>();
    }
    
    /**
     * Devuelve un DTO Cliente en base a un id Cliente.
     */
    public ClienteDTO devolverfilaDTOCliente(int idCliente){
		for(int i=0; i<contenidoCeldas.size(); i++){
			if (idCliente == contenidoCeldas.get(i).getId())
				return contenidoCeldas.get(i);
		}
		return null;
		
    }
    
    
    
    
}
