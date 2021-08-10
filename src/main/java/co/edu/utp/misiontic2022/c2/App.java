package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

public class App 
{
    public static void main( String[] args )
    {
        try {
            //var conectar = JDBCUtilities.getConnection();
            //System.out.println("Conexion con BD ok");
            //conectar.close();

            //var dao = new ComprasDeLiderDao();
            //var lista = dao.consultaComprasPorBanco("Davivienda");

            var controller = new ConsultasController();
            var lista = controller.consultaComprasPorBanco("Davivienda");
            for (ComprasDeLiderVo mostrar : lista) {
                System.out.println(mostrar);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
            e.printStackTrace();
        }
    }
}
