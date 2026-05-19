package decorator;

public class TaxaDomiciliar
        extends DecoradorServico {

    public TaxaDomiciliar(
            ServicoVeterinario servico
    ) {

        super(servico);
    }

    @Override
    public double getValor() {

        return servico.getValor() + 50;
    }

    @Override
    public String getDescricao() {

        return servico.getDescricao()
                + " + atendimento domiciliar";
    }
}