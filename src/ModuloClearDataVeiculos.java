
import java.math.BigInteger;
import java.sql.Timestamp;

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
            // idreferencia
            Timestamp dhSaida = (Timestamp) registro.getCampo("DHSAIDA");
            BigInteger codVeiculo =(BigInteger) registro.getCampo("CODVEICULO");
            BigInteger codEmp = (BigInteger) registro.getCampo("CODEMP");

            
        }
    }
    
}
