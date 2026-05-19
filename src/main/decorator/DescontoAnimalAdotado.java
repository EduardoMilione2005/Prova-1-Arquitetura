package decorator;

public class DescontoAnimalAdotado
        extends DecoradorServico {

    public DescontoAnimalAdotado(
            ServicoVeterinario servico
    ) {

        super(servico);
    }

    @Override
    public double getValor() {

        return servico.getValor() - 20;
    }

    @Override
    public String getDescricao() {

        return servico.getDescricao()
                + " + desconto adoção";
    }
}