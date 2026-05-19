package observer;

public class Recepcao
        implements Observador {

    @Override
    public void atualizar(String mensagem) {

        System.out.println(
                "Recepção recebeu aviso: "
                        + mensagem
        );
    }
}