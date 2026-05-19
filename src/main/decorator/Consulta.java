package decorator;

public class Consulta
        implements ServicoVeterinario {

    @Override
    public double getValor() {
        return 100.0;
    }

    @Override
    public String getDescricao() {
        return "Consulta Veterinária";
    }
}