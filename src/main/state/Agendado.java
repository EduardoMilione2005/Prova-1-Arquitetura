package state;

import model.Atendimento;

public class Agendado
        implements EstadoAtendimento {

    @Override
    public void iniciar(
            Atendimento atendimento
    ) {

        atendimento.setEstado(
                new EmAtendimento()
        );

        atendimento.notificar(
                "Atendimento iniciado"
        );
    }

    @Override
    public void finalizar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento agendado não pode ser finalizado."
        );
    }

    @Override
    public void cancelar(
            Atendimento atendimento
    ) {

        atendimento.setEstado(
                new Cancelado()
        );

        atendimento.notificar(
                "Atendimento cancelado"
        );
    }

    @Override
    public String getNome() {
        return "Agendado";
    }
}