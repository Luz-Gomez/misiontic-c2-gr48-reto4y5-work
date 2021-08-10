package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import org.sqlite.jdbc3.JDBC3Connection;

import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

public class App 
{
    public static void main( String[] args )
    {
        try {
            var conectar = JDBCUtilities.getConnection();
            System.out.println("Conexion con BD ok");
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error " + e);
            e.printStackTrace();
        }
    }
}
