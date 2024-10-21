package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 * 
 * @author Rafaelson
 */
class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0; // iniciamos com saldo 0
    }

    public void consultarSaldo() {
        System.out.println("Seu saldo atual e de: R$ " + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$ " + valor + " realizado com exito.");
        } else {
            System.out.println("Valor de deposito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente ou valor inserido incorretamente.");
        }
    }
}

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome, por gentileza: ");
        String nome = scanner.nextLine();

        System.out.println("Informe seu sobrenome, por gentileza: ");
        String sobrenome = scanner.nextLine();

        System.out.println("Informe seu CPF, por gentileza: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nO que deseja?");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Fazer deposito");
            System.out.println("3 - Fazer saque");
            System.out.println("4 - Encerrar aplicao\n\n");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> cliente.consultarSaldo();
                case 2 -> {
                    System.out.println("Informe o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                }
                case 3 -> {
                    System.out.println("Informe o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                }
                case 4 -> {
                    continuar = false;
                    System.out.println("Encerrando a aplicacao, ate logo!");
                }
                default -> System.out.println("Opção invalida, tente outra vez.");
            }
        }

        scanner.close();
    }
}