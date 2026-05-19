package decorator;

public class BanhoPosConsulta
        extends DecoradorServico {

    public BanhoPosConsulta(
            ServicoVeterinario servico
    ) {

        super(servico);
    }

    @Override
    public double getValor() {

        return servico.getValor() + 30;
    }

    @Override
    public String getDescricao() {

        return servico.getDescricao()
                + " + banho";
    }
}