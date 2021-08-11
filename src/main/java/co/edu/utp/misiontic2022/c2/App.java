package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;
import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;
import co.edu.utp.misiontic2022.c2.view.ReportesView;

public class App 
{
    public static void main( String[] args )
    {
        var vista = new ReportesView();
        vista.proyectosFinanciadosPorBanco("Davivienda");
        vista.totalPagadoPorProyectosSuperioresALimite(50_000d);
        vista.lideresQueMenosGastan();
    }
    /**
        try {
            //var conectar = JDBCUtilities.getConnection();
            //System.out.println("Conexion con BD ok");
            //conectar.close();

            //var dao = new ComprasDeLiderDao();
            //var lista = dao.consultaComprasPorBanco("Davivienda");

            //var controller = new ConsultasController();
            //var lista = controller.listaProyectoBanco("Davivienda");
            //for ( ProyectoBancoVo mostrar : lista){
            //    System.out.println(mostrar);
            //}
        //} catch (SQLException e) {
        //    System.err.println("Error " + e);
        //    e.printStackTrace();
        //}
    }
    */
}
