package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.List;
import co.edu.utp.misiontic2022.c2.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoBancoVo;

public class ConsultasController {
    private ProyectoBancoDao proyectoBancoDao;

    public ConsultasController() {
        proyectoBancoDao = new ProyectoBancoDao();
    }

    public List<ProyectoBancoVo> listaProyectoBanco(String banco) throws SQLException {
        return proyectoBancoDao.consultaProyectoBanco(banco);
    }
}
