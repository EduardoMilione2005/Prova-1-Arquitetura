import decorator.*;
import model.*;
import observer.*;

public class TestesSistema {

    public static void main(String[] args) {

        System.out.println(
                "========================================="
        );

        System.out.println(
                " TESTES DO SISTEMA VETERINÁRIO "
        );

        System.out.println(
                "=========================================\n"
        );

        testeMudancaValida();

        testeMudancaInvalida();

        testeAvisosAutomaticos();

        testeCalculoValorFinal();

        System.out.println(
                "\n========================================="
        );

        System.out.println(
                " TODOS OS TESTES FINALIZADOS "
        );

        System.out.println(
                "========================================="
        );
    }

    // =====================================================
    // TESTE 1
    // Mudança válida de estado
    // =====================================================

    public static void testeMudancaValida() {

        System.out.println(
                "========== TESTE 1 =========="
        );

        System.out.println(
                "Mudança válida de estado\n"
        );

        Tutor tutor =
                new Tutor("Carlos");

        Animal animal =
                new Animal(
                        "Rex",
                        "Cachorro",
                        true
                );

        ServicoVeterinario servico =
                new Consulta();

        Atendimento atendimento =
                new Atendimento(
                        tutor,
                        animal,
                        servico
                );

        System.out.println(
                "Estado inicial:"
        );

        System.out.println(
                atendimento.getEstadoAtual()
        );

        atendimento.iniciar();

        System.out.println(
                "\nApós iniciar:"
        );

        System.out.println(
                atendimento.getEstadoAtual()
        );

        atendimento.finalizar();

        System.out.println(
                "\nApós finalizar:"
        );

        System.out.println(
                atendimento.getEstadoAtual()
        );

        System.out.println(
                "\nTESTE 1 FINALIZADO\n"
        );
    }

    // =====================================================
    // TESTE 2
    // Mudança inválida
    // =====================================================

    public static void testeMudancaInvalida() {

        System.out.println(
                "========== TESTE 2 =========="
        );

        System.out.println(
                "Tentativa de mudança inválida\n"
        );

        Tutor tutor =
                new Tutor("Marina");

        Animal animal =
                new Animal(
                        "Luna",
                        "Gato",
                        false
                );

        ServicoVeterinario servico =
                new Consulta();

        Atendimento atendimento =
                new Atendimento(
                        tutor,
                        animal,
                        servico
                );

        atendimento.iniciar();

        atendimento.finalizar();

        try {

            atendimento.cancelar();

        } catch (Exception e) {

            System.out.println(
                    "Exceção capturada:"
            );

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println(
                "\nTESTE 2 FINALIZADO\n"
        );
    }

    // =====================================================
    // TESTE 3
    // Observer
    // =====================================================

    public static void testeAvisosAutomaticos() {

        System.out.println(
                "========== TESTE 3 =========="
        );

        System.out.println(
                "Envio automático de avisos\n"
        );

        Tutor tutor =
                new Tutor("Fernanda");

        Animal animal =
                new Animal(
                        "Bob",
                        "Cachorro",
                        false
                );

        ServicoVeterinario servico =
                new Consulta();

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
                new Veterinario(
                        "Dr. João"
                )
        );

        atendimento.adicionarObservador(
                new Recepcao()
        );

        System.out.println(
                "Iniciando atendimento...\n"
        );

        atendimento.iniciar();

        System.out.println();

        System.out.println(
                "Finalizando atendimento...\n"
        );

        atendimento.finalizar();

        System.out.println(
                "\nTESTE 3 FINALIZADO\n"
        );
    }

    // =====================================================
    // TESTE 4
    // Decorator
    // =====================================================

    public static void testeCalculoValorFinal() {

        System.out.println(
                "========== TESTE 4 =========="
        );

        System.out.println(
                "Cálculo do valor final\n"
        );

        Tutor tutor =
                new Tutor("Ana");

        Animal animal =
                new Animal(
                        "Thor",
                        "Cachorro",
                        true
                );

        ServicoVeterinario servico =
                new Consulta();

        servico =
                new DescontoAnimalAdotado(
                        servico
                );

        servico =
                new TaxaDomiciliar(
                        servico
                );

        servico =
                new BanhoPosConsulta(
                        servico
                );

        Atendimento atendimento =
                new Atendimento(
                        tutor,
                        animal,
                        servico
                );

        System.out.println(
                "Serviços aplicados:"
        );

        System.out.println(
                servico.getDescricao()
        );

        System.out.println();

        System.out.println(
                "Valor final:"
        );

        System.out.println(
                "R$ "
                        + atendimento.getValorFinal()
        );

        System.out.println(
                "\nTESTE 4 FINALIZADO\n"
        );
    }
}