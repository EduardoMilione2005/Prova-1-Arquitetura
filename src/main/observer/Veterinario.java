package observer;

public class Veterinario
        implements Observador {

    private final String nome;

    public Veterinario(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {

        System.out.println(
                "Veterinário "
                        + nome
                        + ": "
                        + mensagem
        );
    }
}