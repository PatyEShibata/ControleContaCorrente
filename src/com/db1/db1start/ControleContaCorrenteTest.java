package com.db1.db1start;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.ldap.Control;

import static org.junit.Assert.*;

public class ControleContaCorrenteTest {

    @Test
    public void deveCriarContaPorMeioDoConstrutor() {
        String nome = "Fake";
        Integer numeroConta = 1;
        Double saldo = 100.;

        ControleContaCorrente contaCorrente = new ControleContaCorrente("Fake", 1, 100.00);
        Assert.assertEquals(nome, contaCorrente.getNomeCliente());
        Assert.assertEquals(numeroConta, contaCorrente.getNumeroConta());
        Assert.assertEquals(saldo, contaCorrente.getSaldo());
    }


    ControleContaCorrente contaCorrente = new ControleContaCorrente("Fake", 1,100.00);

    @Test
    public void deveJogarExceptionComNomeNulo() {
        Integer numeroConta = 1;
        Double saldo = 10.00;
        try {
            ControleContaCorrente contaCorrente = new ControleContaCorrente(null, numeroConta, saldo);
        } catch (CampoNaoPodeSerNulo naoPodeSerNulo) {
            Assert.assertEquals("Nome não pode ser nulo.", naoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void deveJogarExceptionComNumeroContaNulo(){
        String nomeCliente = "Fake";
        Double saldo = 10.00;
        try {
            ControleContaCorrente contaCorrente = new ControleContaCorrente(nomeCliente, null, saldo);
        } catch (CampoNaoPodeSerNulo naoPodeSerNulo){
            Assert.assertEquals("Número da conta não pode ser nulo.", naoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void deveJogarExceptionComSaldoNulo(){
        String nomeCliente = "Fake";
        Integer numeroConta = 1;
        try{
            ControleContaCorrente contaCorrente = new ControleContaCorrente(nomeCliente, numeroConta, null);
        }catch (CampoNaoPodeSerNulo naoPodeSerNulo){
            Assert.assertEquals("Saldo não pode ser nulo.", naoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void deveRetornar200(){
        Double expected = 200.00;
        Double response = contaCorrente.depositar(100.00);
        Assert.assertEquals(expected, response);
    }

    @Test
    public void deveRetornarValorInvalido(){
        try {
            contaCorrente.depositar(-100.00);
            fail();
        } catch (ValorInvalido valorInvalido){
            Assert.assertEquals("Valor inválido.", valorInvalido.getMessage());
        }
    }

    @Test
    public void deveRetornarSaldoInsuficienteNoMetodoSacar(){
        try{
            contaCorrente.sacar(200.00);
        }catch (ValorInvalido valorInvalido){
            Assert.assertEquals("Saldo insuficiente.", valorInvalido.getMessage());
        }
    }

    @Test
    public void deveRetornar80(){
        Double expected = 80.00;
        Double response = contaCorrente.sacar(20.00);
        Assert.assertEquals(expected, response);
    }

    @Test
    public void deveRetornarSaldoInsuficienteNoMetodoTransferir(){
        ControleContaCorrente contaCorrente2 = new ControleContaCorrente("Fake2", 2,200.00);
        try{
            contaCorrente.transferir(200.00,contaCorrente2);
        }catch (ValorInvalido valorInvalido){
            Assert.assertEquals("Saldo insuficiente.", valorInvalido.getMessage());
        }
    }

    @Test
    public void deveRetornar70(){
        ControleContaCorrente contaCorrente2 = new ControleContaCorrente("Fake2", 2,200.00);
        Double expected = 70.00;
        Double response = contaCorrente.transferir(30.00,contaCorrente2);
        Assert.assertEquals(expected, response);
    }







}