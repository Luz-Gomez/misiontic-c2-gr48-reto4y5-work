package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.model.dao.PagadoPorProyectoDao;
import co.edu.utp.misiontic2022.c2.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoBancoVo;

public class ConsultasController {
    private ProyectoBancoDao proyectoBancoDao;
    private PagadoPorProyectoDao pagadoPorProyectoDao;

    public ConsultasController() {
        proyectoBancoDao = new ProyectoBancoDao();
        pagadoPorProyectoDao = new PagadoPorProyectoDao();
    }

    public List<ProyectoBancoVo> listaProyectoBanco(String banco) throws SQLException {
        return proyectoBancoDao.consultaProyectoBanco(banco);
    }

    public List<PagadoPorProyectoVo> listaPagadoPorProyecto(Double limiteInferior) throws SQLException {
        return pagadoPorProyectoDao.consultaPagadoPorProyecto(limiteInferior);
    }
}
