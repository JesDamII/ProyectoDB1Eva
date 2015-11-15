package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.sql.DATE;

public class DBProyecto1Eva {

    static final String CONTROLADOR_ORACLE = "oracle.jdbc.OracleDriver";
    static final String URL_DB = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String USUARIO = "prueba";
    static final String CONTRASEÑA = "prueba";

    private static Connection conexión;
    private static Statement sentenciaSQL;

    private static void conectar() {
        try {
            Class.forName(CONTROLADOR_ORACLE).newInstance();
            conexión = java.sql.DriverManager.getConnection(URL_DB, USUARIO, CONTRASEÑA);
            sentenciaSQL = conexión.createStatement(
                    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                    java.sql.ResultSet.CONCUR_UPDATABLE);
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.INFO, "\nConexión realizada con éxito.\n");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void desconectar() {
        try {
            if (sentenciaSQL != null) {
                sentenciaSQL.close();
            }
            if (conexión != null) {
                conexión.close();
            }
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.INFO, "Conexión cerrada");
        } catch (Exception e) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, e);
        }
    }

//    public static List<Clientes> getContactos()
//    {
//        conectar();
//        List<Clientes> list = new ArrayList<>();        
//        try {
//            String sql = "SELECT * FROM Clientes";
//            ResultSet rs= sentenciaSQL.executeQuery(sql);
//            while(rs.next())
//            {
//                Clientes c = new Clientes();
//                c.setcodigoCli(rs.getInt(1));
//                c.setNombre(rs.getString(2));
//                c.setLocalidad(rs.getString(3));
//                c.setTlf(rs.getString(4));
//                
//                list.add(c);
//                System.out.println("Comprobacion DB "+c.toString());
//            }            
//        } catch (SQLException ex) {
//            Logger.getLogger(DBProyecto1EVA.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally
//        {
//            desconectar();
//        }
//        
//        return list;
//    }
    //Altas de compras.
    public static void AltaCompras(int numCompra, int codCli,String fecha) {
        String sql = "insert into Compras (numcompra,codigo_cli,fechacompra)"
                + "values("
                + numCompra + ","
                + codCli +","
                + "to_date('"+fecha+"', 'dd/mm/yy')" + ")";
        System.out.println(sql);
        conectar();
        try {
            if (sentenciaSQL.executeUpdate(sql) != 0) {
                Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, "Contacto guardado...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        String fk="insert into detallecompras(numcompra) values("
        		+numCompra+")";
        conectar();
        try {
            if (sentenciaSQL.executeUpdate(fk) != 0) {
                Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, "Contacto guardado...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        
    }

    //Modificaciones de compras.
    public static void actualizarCompras(int numCompra, int codCli,String fecha) {
        try {
            String sql = "update Compras set codigo_cli="+codCli 
                    + ", fechacompra=" + "to_date('"+fecha+"', 'dd/mm/yy')"
                    + " where numcompra=" + numCompra;

            System.out.println(sql);
            conectar();
            sentenciaSQL.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
    }
    
    ////Bajas para la tabla compras.
    public static void bajaCompras(int numCompra) {
        try {
            conectar();
            String sql = "delete from Compras where numcompra=" + numCompra;
            sentenciaSQL.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
    }
    
    	/*Metodo para crear un String con el que llenar el TextArea de la ventana GestionCompras
    	 *  NUMCOMPRA  CODCLI   NOMBRE CLIENTE   IMPORTE TOTAL   NÚM-ART COMPRA
			----------- -------- ---------------- --------------- ---------------
  			Xxxxx     xxxxx    xxxxxxxxxxxxxx    xxxxxxxxxx       xxxxxxxx
			Xxxxx     xxxxx    xxxxxxxxxxxxxx    xxxxxxxxxx       xxxxxxxx 
				Dónde:
				IMPORTE TOTAL es la suma de los importes (unidades*precio) de los artículos que forman la compra.
				NÚM-ART COMPRA, es el número de artículos que forman la compra.* */ 
    public static String sentenciaGestionCompras(){
    	
        ResultSet rs = null;
        String espacio=" ";
        
        String sql = "select c.numcompra,c.codigo_cli,cl.nombre"+
						", sum(dtc.unidades*art.precio)importe_total, sum(dtc.unidades)Num_art_Compra "+
						"from Articulos art "+
						"join DETALLECOMPRAS dtc on art.CODARTICULO=dtc.CODARTICULO "+
						"join compras c on dtc.NUMCOMPRA=c.NUMCOMPRA "+
						"join clientes cl on c.CODIGO_CLI=cl.CODIGO_CLI "+
						"group by c.numcompra,c.codigo_cli,cl.nombre "+
						"order by c.NUMCOMPRA";
        System.out.println(sql);
        
        String acumulaCadena="NUMCOMPRA  CODCLI   NOMBRE CLIENTE     IMPORTE TOTAL   NÚM-ART COMPRA\n"+
							 "---------  ------   --------------     -------------   --------------\n";
        try {
            int i = 0;
            rs = sentenciaSQL.executeQuery(sql);
            
            while (rs.next()) {
               acumulaCadena+=String.format("%9d %7d %1s %-15s %16.2f %16d %n", rs.getInt(1),rs.getInt(2),espacio,rs.getString(3),rs.getFloat(4),rs.getInt(5));
               i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        }

    	return acumulaCadena;
    }
    
    
    //Metodo para llenar el ComboBox de GestionCompras que tiene la ventana GestionCompras
    public static String[] listarClientes() {
        int conta = contarClientes();
        ResultSet rs = null;
        String[] clientes = new String[conta];
        String sql = "select codigo_cli from clientes";
        try {
            int i = 0;
            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                clientes[i] = String.valueOf(rs.getInt("codigo_cli"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }
    
    //Método para dimensionar el array del metodo listarClientes().
    private static int contarClientes() {
        conectar();
        ResultSet rs = null;
        int conta = 0;
        String sql = "select count(codigo_cli) from clientes";
        try {
            rs = sentenciaSQL.executeQuery(sql);
            rs.first();
            conta = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conta;
    }

	public static String enlazarNombreCliente(String codCli) {
		 conectar();
	        ResultSet rs = null;
	        String nom="";
	        String sql = "select nombre from clientes where codigo_cli="+
	        		Integer.parseInt(codCli);
	        try {
	            rs = sentenciaSQL.executeQuery(sql);
	            rs.first();
	            nom= rs.getString(1);
	            rs.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(DBProyecto1Eva.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
		return nom;
	}

}
