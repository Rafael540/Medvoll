package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoComOutraConsulta implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
    var medicoPossuiOutraConsultaNoMesmoHoario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
    if((boolean) medicoPossuiOutraConsultaNoMesmoHoario){
        throw new ValidacaoException("Medico já possui outra consulta agendada nesse mesmo horário");
    }
    }
}
