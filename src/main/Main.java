import decorator.*;
import model.*;
import observer.*;
import state.*;

public class Main {

    public static void main(String[] args) {

        Tutor tutor = new Tutor("Carlos");

        Animal animal = new Animal(
                "Rex",
                "Cachorro",
                true
        );

        ServicoVeterinario servico =
                new Consulta();

        servico =
                new DescontoAnimalAdotado(servico);

        servico =
                new TaxaDomiciliar(servico);

        servico =
                new BanhoPosConsulta(servico);

        Atendimento atendimento =
                new Atendimento(
                        tutor,
                        animal,
                        servico
                );

        atendimento.adicionarObservador(tutor);

        atendimento.adicionarObservador(
                new Veterinario("Dr. João")
        );

        atendimento.adicionarObservador(
                new Recepcao()
        );

        System.out.println(
                "Estado atual: "
                        + atendimento.getEstadoAtual()
        );

        atendimento.iniciar();

        System.out.println(
                "Estado atual: "
                        + atendimento.getEstadoAtual()
        );

        atendimento.finalizar();

        System.out.println(
                "Estado atual: "
                        + atendimento.getEstadoAtual()
        );

        try {
            atendimento.cancelar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(
                "Valor final: R$ "
                        + atendimento.getValorFinal()
        );
    }
}