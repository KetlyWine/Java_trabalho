package application;

import model.entities.*;


import java.time.LocalDateTime;
import java.util.ArrayList;


import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Estacao> estacoes = new ArrayList<>();
        Companhia companhiaecia = new Companhia("Companhia & cia", 10);

        TremPassageiro tremPassageiro1 = new TremPassageiro(1, "Expresso", 1000, FonteDeEnergia.ELETRICA, 10, 60, 30.0);
        TremPassageiro tremPassageiro2 = new TremPassageiro(2, "Expresso", 1200, FonteDeEnergia.DIESEL, 15, 80, 50.0);

        Estacao estacao1 = new Estacao("Cia Station", "Rua Bahia - Bairro carajas", "ativo");
        Estacao estacao2 = new Estacao("Cia&Cia Station", "Rua Lord - Bairro Flores", "ativo");

        Passageiro pass = new Passageiro();
        Bilhete bilhete = new Bilhete(estacao1, estacao2, 3.0, "cartao", LocalDateTime.now(), LocalDateTime.now());
        Bilheteria bt = new Bilheteria(pass);
        Reserva rs = new Reserva(bt, tremPassageiro1);
        rs.mostrarAssentosDisponiveis();
        rs.atribuirAssento(2);
        rs.mostrarAssentosDisponiveis();
        rs.relatorioReserva();
        companhiaecia.conectarEstacoes(estacao1, estacao2, 30.0);
        companhiaecia.exibir();

        Empresa surprise = new Empresa("Surprise", "12.345.678/0001-90", "Rua Florida - bairro Sao Jorge", 156, "surprise@gmail.com", "surprise.com", Setor.SERVICOS);

        while (true){
            System.out.println("---Companhia de Trem---");
            System.out.println("1. Cadastrar empresa.");
            System.out.println("2. Cadastrar estação.");
            System.out.println("3. Comprar passagem.");
            System.out.println("4. Visualizar contratos de cada empresa.");
            System.out.println("5. Visualizar o trajeto de cada trem.");
            System.out.println("6. Visualizar passagens já reservadas.");
            System.out.println("7. Cadastrar companhia.");
            int menu;

            if (ler.hasNextInt()) {
                menu = ler.nextInt();
                switch(menu) {
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
                        while (true) {
                            System.out.println("Qual setor?");
                            System.out.println("1. Indústria.");
                            System.out.println("2. Mineração.");
                            System.out.println("3. Serviços.");
                            System.out.println("4. Agricultura.");
                            System.out.println("5. Automotivo.");
                            System.out.println("6. Manufatureira.");
                            int set;
                            if (ler.hasNextInt()) {
                                set = ler.nextInt();
                                switch (set) {
                                    case 1:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.INDUSTRIA));
                                        break;
                                    case 2:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.MINERACAO));
                                        break;
                                    case 3:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.SERVICOS));
                                        break;
                                    case 4:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.AGRICULTURA));
                                        break;
                                    case 5:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.AUTOMOTIVO));
                                        break;
                                    case 6:
                                        empresas.add(new Empresa(nome, cnpj, end, numero, email, site, Setor.MANUFATUREIRA));
                                        break;
                                    default:
                                        System.out.println("Número inválido.");


                                }
                            } else {
                                ler.next();
                                System.out.println("Entrada inválida. Tente novamente.");
                            }
                        }

                    case 2:
                        System.out.print("Digite o nome da estação: ");
                        String name = ler.next();
                        System.out.print("Endereço: ");
                        String ende = ler.next();
                        System.out.print("Estado operacional: ");
                        String op = ler.next();
                        estacoes.add(new Estacao(name, ende, op));
                        break;
                    case 7:
                        System.out.print("Digite o nome da Companhia: ");
                        String nomeC = ler.next();
                        System.out.print("Id: ");
                        int id = ler.nextInt();
                        System.out.println("Quais estações são desta companhia?");
                        

                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}
