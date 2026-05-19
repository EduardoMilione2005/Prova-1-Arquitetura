import decorator.*;
import model.*;
import observer.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "======================================"
        );

        System.out.println(
                " SISTEMA CLÍNICA VETERINÁRIA "
        );

        System.out.println(
                "======================================\n"
        );

        // ======================================
        // CRIAÇÃO DOS OBJETOS
        // ======================================

        Tutor tutor = new Tutor("Carlos");

        Animal animal = new Animal(
                "Rex",
                "Cachorro",
                true
        );

        System.out.println(
                "Tutor cadastrado: Carlos"
        );

        System.out.println(
                "Animal cadastrado: Rex"
        );

        System.out.println(
                "Espécie: Cachorro\n"
        );

        // ======================================
        // SERVIÇOS
        // ======================================

        System.out.println(
                "========== SERVIÇOS =========="
        );

        ServicoVeterinario servico =
                new Consulta();

        servico =
                new DescontoAnimalAdotado(servico);

        servico =
                new TaxaDomiciliar(servico);

        servico =
                new BanhoPosConsulta(servico);

        System.out.println(
                "Serviços aplicados:"
        );

        System.out.println(
                servico.getDescricao()
        );

        System.out.println();

        // ======================================
        // ATENDIMENTO
        // ======================================

        Atendimento atendimento =
                new Atendimento(
                        tutor,
                        animal,
                        servico
                );

        atendimento.adicionarObservador(
                tutor
        );

        atendimento.adicionarObservador(
                new Veterinario("Dr. João")
        );

        atendimento.adicionarObservador(
                new Recepcao()
        );

        System.out.println(
                "======= ESTADO INICIAL ======="
        );

        System.out.println(
                "Estado atual: "
                        + atendimento.getEstadoAtual()
        );

        System.out.println();

        // ======================================
        // INICIAR
        // ======================================

        System.out.println(
                "===== INICIANDO ATENDIMENTO ====="
        );

        atendimento.iniciar();

        System.out.println();

        System.out.println(
                "Novo estado: "
                        + atendimento.getEstadoAtual()
        );

        System.out.println();

        // ======================================
        // FINALIZAR
        // ======================================

        System.out.println(
                "===== FINALIZANDO ATENDIMENTO ====="
        );

        atendimento.finalizar();

        System.out.println();

        System.out.println(
                "Novo estado: "
                        + atendimento.getEstadoAtual()
        );

        System.out.println();

        // ======================================
        // TESTE INVÁLIDO
        // ======================================

        System.out.println(
                "===== TESTE DE CANCELAMENTO ====="
        );

        try {

            atendimento.cancelar();

        } catch (Exception e) {

            System.out.println(
                    "ERRO:"
            );

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println();

        // ======================================
        // VALOR FINAL
        // ======================================

        System.out.println(
                "======= VALOR FINAL ======="
        );

        System.out.println(
                "Valor total do atendimento:"
        );

        System.out.println(
                "R$ "
                        + atendimento.getValorFinal()
        );

        System.out.println();

        System.out.println(
                "======================================"
        );

        System.out.println(
                " FIM DA EXECUÇÃO "
        );

        System.out.println(
                "======================================"
        );
    }
}