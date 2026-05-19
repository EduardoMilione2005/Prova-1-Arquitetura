package model;

import observer.Observador;

public class Tutor extends Observador {

    private String nome;

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