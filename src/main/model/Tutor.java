package model;

import observer.Observador;

public class Tutor implements Observador {

    private final String nome;

    public Tutor(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {

        System.out.println(
                "Tutor "
                        + nome
                        + ": "
                        + mensagem
        );
    }
}