package state;

import model.Atendimento;

public class EmAtendimento
        implements EstadoAtendimento {

    @Override
    public void iniciar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento já iniciado."
        );
    }

    @Override
    public void finalizar(
            Atendimento atendimento
    ) {

        atendimento.setEstado(
                new Finalizado()
        );

        atendimento.notificar(
                "Atendimento finalizado"
        );
    }

    @Override
    public void cancelar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento em andamento não pode ser cancelado."
        );
    }

    @Override
    public String getNome() {
        return "Em Atendimento";
    }
}