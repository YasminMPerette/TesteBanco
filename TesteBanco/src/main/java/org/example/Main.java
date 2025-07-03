package org.example;

import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String nome;
        String email;

        UsuarioDAO user = new UsuarioDAO();

        System.out.println("Digite seu nome: ");
        nome = in.nextLine();

        System.out.println("Digite seu e-mail: ");
        email = in.nextLine();

        Usuario usuario = new Usuario(nome, email);
        user.inserir(usuario);

    }
}
