package model;

import decorator.ServicoVeterinario;
import observer.Observador;
import state.Agendado;
import state.EstadoAtendimento;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {

    private EstadoAtendimento estado;
    private final ServicoVeterinario servico;

    private final List<Observador> observadores =
            new ArrayList<>();

    public Atendimento(
            Tutor tutor,
            Animal animal,
            ServicoVeterinario servico
    ) {

        this.servico = servico;

        this.estado = new Agendado();
    }

    public void adicionarObservador(
            Observador observador
    ) {

        observadores.add(observador);
    }

    public void notificar(String mensagem) {

        for (Observador observador
                : observadores) {

            observador.atualizar(mensagem);
        }
    }

    public void iniciar() {
        estado.iniciar(this);
    }

    public void finalizar() {
        estado.finalizar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void setEstado(
            EstadoAtendimento estado
    ) {

        this.estado = estado;
    }

    public double getValorFinal() {
        return servico.getValor();
    }

    public String getEstadoAtual() {
        return estado.getNome();
    }
}