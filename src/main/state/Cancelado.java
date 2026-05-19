package state;

import model.Atendimento;

public class Cancelado
        implements EstadoAtendimento {

    @Override
    public void iniciar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento cancelado não pode iniciar."
        );
    }

    @Override
    public void finalizar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento cancelado não pode finalizar."
        );
    }

    @Override
    public void cancelar(
            Atendimento atendimento
    ) {

        throw new RuntimeException(
                "Atendimento já cancelado."
        );
    }

    @Override
    public String getNome() {
        return "Cancelado";
    }
}