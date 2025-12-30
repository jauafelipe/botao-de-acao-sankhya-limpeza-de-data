
import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.event.*;
import br.com.sankhya.jape.vo.DynamicVO;

import java.math.BigDecimal;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.QueryExecutor;
import br.com.sankhya.extensions.actionbutton.Registro;
   
    
public class ModuloClearDataVeiculos implements AcaoRotinaJava {

    @Override
    public void doAction(ContextoAcao contexto) throws Exception {
        QueryExecutor query = contexto.getQuery();
        Registro[] linhas = contexto.getLinhas();

        for(Registro registro: linhas) {
            BigDecimal id = (BigDecimal)contexto.getParam("id");
            
        }
    }
    
}
