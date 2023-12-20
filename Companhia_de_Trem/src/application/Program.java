package application;

import model.entities.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Companhia companhiaecia = new Companhia("Companhia & cia", 10);

        TremPassageiro tremPassageiro1 = new TremPassageiro(1, "Expresso", 1000, FonteDeEnergia.ELETRICA, 10, 60, 30.0);
        TremPassageiro tremPassageiro2 = new TremPassageiro(2, "Expresso", 1200, FonteDeEnergia.DIESEL, 15, 80, 50.0);

        Estacao estacao1 = new Estacao("Cia Station", "Rua Bahia - Bairro carajas", "ativo");
        Estacao estacao2 = new Estacao("Cia&Cia Station", "Rua Lord - Bairro Flores", "ativo");

        Empresa surprise = new Empresa("Surprise", "12.345.678/0001-90", "Rua Florida - bairro Sao Jorge", 156, "surprise@gmail.com", "surprise.com", Setor.SERVICOS);

        while (true){
            System.out.println("---Companhia de Trem---");
            System.out.println("1. Cadastrar empresa.");
            System.out.println("2. Cadastrar estação.");
            System.out.println("3. Comprar passagem.");
            System.out.println("4. Visualizar contratos de cada empresa.");
            System.out.println("5. Visualizar o trajeto de cada trem.");
            System.out.println("6. Visualizar passagens já reservadas.");
            int menu;

            if (ler.hasNextInt()) {
                menu = ler.nextInt();
                switch(menu){
                    case 1:

                        System.out.print("Digite o nome da empresa: ");
                        String nome = ler.next();
                        System.out.print("CNPJ: ");
                        String cnpj = ler.next();
                        System.out.print("Endereço: ");
                        String end = ler.next();
                        System.out.print("Numero: ");
                        int numero = ler.nextInt();
                        System.out.print("Email: ");
                        String email = ler.next();
                        System.out.println("Site: ");
                        String site = ler.next();
                        

                        break;
                    case 2:
                        System.out.println("B");
                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}
