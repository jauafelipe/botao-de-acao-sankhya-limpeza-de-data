package adicionaNovoRetorno;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.QueryExecutor;
import br.com.sankhya.extensions.actionbutton.Registro;

public class Modulo_novorRetorno implements AcaoRotinaJava {

    @Override
    public void doAction(ContextoAcao contexto) throws Exception {
             Registro[] linhas = contexto.getLinhas();

        if (linhas == null || linhas.length == 0) {
            contexto.mostraErro("Selecione ao menos um registro.");
            return;
        }

        contexto.confirmarSimNao(
            "ATENÇÃO",
            "Os registros selecionados terão uma Nova Data de Retorno. Deseja prosseguir?",
            1
        );

        QueryExecutor query = contexto.getQuery();

        for (Registro registro : linhas) {
            Timestamp formNovaDataRetorno = (Timestamp) contexto.getParam("Nova Data De Retorno");
            BigDecimal codVeiculo = (BigDecimal) registro.getCampo("CODVEICULO");
            BigDecimal codEmp     = (BigDecimal) registro.getCampo("CODEMP");
            Timestamp dhSaida = (Timestamp) registro.getCampo("DHSAIDA");

           

            query.setParam("P_CODVEICULO", codVeiculo);
            query.setParam("P_CODEMP", codEmp);
            query.setParam("P_DHSAIDA", dhSaida);
            query.setParam("P_DHCHEGADA", formNovaDataRetorno);

            query.update(
                "UPDATE TGFCVE " +
                "SET DHCHEGADA = {P_DHCHEGADA} " +
                "WHERE DHCHEGADA IS NULL " +
                "AND CODVEICULO = {P_CODVEICULO} " +
                "AND DHSAIDA = {P_DHSAIDA}"
            );
        }

        contexto.setMensagemRetorno("Data de Retorno Adicionado com sucesso!");
    }
    
}
