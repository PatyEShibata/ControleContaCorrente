package com.db1.db1start;

public class Principal {

    public static void main(String[] args) {

        ControleContaCorrente contaCorrente2 = new ControleContaCorrente("Joao", 2, 2000.00);

        ControleContaCorrente contaCorrente1 = new ControleContaCorrente("Patricia", 1, 1000.00);
        contaCorrente1.depositar(500.0);
        contaCorrente1.sacar(200.00);
        contaCorrente1.transferir(300.00,contaCorrente2);
        contaCorrente1.extrato();
        contaCorrente2.depositar(100.00);
        contaCorrente2.sacar(200.00);
        contaCorrente2.extrato();

    }
}
