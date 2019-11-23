package com.db1.db1start;

import java.util.ArrayList;
import java.util.List;

public class ControleContaCorrente {

    private String nomeCliente;
    private Integer numeroConta;
    private Double saldo;

    public ControleContaCorrente(String nomeCliente, Integer numeroConta, Double saldo) {
            if (nomeCliente == null) {
                throw new CampoNaoPodeSerNulo("Nome não pode ser nulo.");
            }
            if (numeroConta == null) {
                throw new CampoNaoPodeSerNulo("Número da conta não pode ser nulo.");
            }
            if (saldo == null) {
                throw new CampoNaoPodeSerNulo("Saldo não pode ser nulo.");
            }

        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }


    List<String> extrato = new ArrayList<>();

    public void separar(){
        System.out.println("-----------------------");
    }

    public Double depositar(Double valorDeposito){
        if (valorDeposito < 0){
            throw new ValorInvalido("Valor inválido.");

        }
        System.out.println("Valor do depósito: " + valorDeposito);
        System.out.println("Depósito realizado com sucesso.");
        separar();
        extrato.add("Depósito: " + Double.toString(valorDeposito)+ "\n");
        return saldo = saldo + valorDeposito;
    }

    public Double sacar (Double valorSaque){
        System.out.println("Valor do saque: " + valorSaque);
        if (saldo < valorSaque){
            throw new ValorInvalido("Saldo insuficiente.");
        }
        System.out.println("Saque realizado com sucesso.");
        separar();
        extrato.add("Saque: " + Double.toString(valorSaque)+ "\n");
        return saldo = saldo - valorSaque;
    }

    public Double transferir (Double valorTransferencia, ControleContaCorrente contaCorrente){
        System.out.println("Valor da transferencia: " + valorTransferencia);
        if (saldo < valorTransferencia){
            throw new ValorInvalido("Saldo insuficiente.");
        }
        System.out.println("Transferencia realizada com sucesso.");
        contaCorrente.saldo = contaCorrente.saldo + valorTransferencia;
        contaCorrente.extrato.add("Transferencia recebida: " + valorTransferencia + "\n");

        extrato.add("Tranferencia realizada: " + Double.toString(valorTransferencia) + "\n");
        separar();
        return saldo = saldo - valorTransferencia;
    }

    public void extrato(){
        System.out.println("==========EXTRATO==========" +"\n" + "Número da conta: " + numeroConta + "\n" + "Nome: " + nomeCliente);
        System.out.println("---------------------------" + "\n" + extrato + "\n" + "---------------------------" + "\n" + "Saldo: " + saldo);
        System.out.println("===========================");
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
