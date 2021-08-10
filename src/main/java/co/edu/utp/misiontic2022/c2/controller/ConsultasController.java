package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.List;
import co.edu.utp.misiontic2022.c2.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.model.vo.ComprasDeLiderVo;

public class ConsultasController {
    private ComprasDeLiderDao comprasDeLiderDao;

    public ConsultasController() {
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ComprasDeLiderVo> consultaComprasPorBanco(String banco) throws SQLException {
        return comprasDeLiderDao.consultaComprasPorBanco(banco);
    }
}
