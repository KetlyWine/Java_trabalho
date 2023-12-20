package application;

import model.entities.*;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import java.util.ArrayList;
>>>>>>> 29da3543ac0d196548823336576f4ef76787611f
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Empresa> empresas = new ArrayList<>();
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
                        /*
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
                        while(true){
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
                                switch(set){
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
                        } */
                        Empresa surpriseE = new Empresa("Surprise", "12.345.678/0001-90", "Rua Florida - bairro Sao Jorge", 156, "surprise@gmail.com", "surprise.com", Setor.SERVICOS);
                    case 2:
                        System.out.println("B");
                        break;
                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}
