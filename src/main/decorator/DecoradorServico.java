package decorator;

public abstract class DecoradorServico
        implements ServicoVeterinario {

    protected ServicoVeterinario servico;

    public DecoradorServico(
            ServicoVeterinario servico
    ) {

        this.servico = servico;
    }
}