package application;

import model.entities.*;
import java.time.LocalDateTime;
import java.util.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Estacao> estacoes = new ArrayList<>();
        ArrayList<Companhia> companhias = new ArrayList<>();

        Companhia companhiaecia = new Companhia("Companhia & cia", 10);

        TremPassageiro tremPassageiro1 = new TremPassageiro(1, "Expresso", 1000, FonteDeEnergia.ELETRICA, 10, 60, 30.0);
        TremPassageiro tremPassageiro2 = new TremPassageiro(2, "Expresso", 1200, FonteDeEnergia.DIESEL, 15, 80, 50.0);

        Estacao estacao1 = new Estacao("Cia Station", "Rua Bahia - Bairro carajas", "ativo");
        Estacao estacao2 = new Estacao("Cia&Cia Station", "Rua Lord - Bairro Flores", "ativo");
        Estacao estacao3 = new Estacao("Ketly's & Hermanos Station", "Rua Não Sei onde ela mora - Bairro Liberdade", "ativo");
        Estacao estacao4 = new Estacao("Aquila's & Pollos Station", "Rua D'Agua - Bairro Sf Pioneiro", "ativo");
        estacoes.add(estacao1); estacoes.add(estacao2); estacoes.add(estacao3); estacoes.add(estacao4);

        Passageiro pass = new Passageiro();
        Bilhete bilhete = new Bilhete(estacao1, estacao2, 3.0, "cartao", LocalDateTime.now(), LocalDateTime.now());
        Bilheteria bt = new Bilheteria(pass);
        Reserva rs = new Reserva(bt, tremPassageiro1);
        rs.mostrarAssentosDisponiveis();
        rs.atribuirAssento(2);
        rs.mostrarAssentosDisponiveis();
        rs.relatorioReserva();
        Companhia minhaCompanhia = new Companhia(estacoes);
        companhiaecia.conectarEstacoes(estacao1, estacao2, 30.0);
        companhiaecia.exibir();

        Empresa surprise = new Empresa("Surprise", "12.345.678/0001-90", "Rua Florida - bairro Sao Jorge", 156, "surprise@gmail.com", "surprise.com", Setor.SERVICOS);
        empresas.add(surprise);
        while (true){
            System.out.println("---Companhia de---");
            System.out.println("1. Cadastrar empresa.");
            System.out.println("2. Cadastrar estação.");
            System.out.println("3. Comprar passagem.");
            System.out.println("4. Visualizar contratos de cada empresa.");
            System.out.println("5. Visualizar o trajeto de cada trem.");
            System.out.println("6. Visualizar passagens já reservadas.");
            System.out.println("7. Cadastrar companhia.");
            int menu;
            System.out.print("Menu: ");
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
                                System.out.print("Setor: ");
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
                                        break;

                                }
                            } else {
                                ler.next();
                                System.out.println("Entrada inválida. Tente novamente.");
                            }
                            break;
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
                    case 3:
                        System.out.print("Informe seu nome: ");
                        String nomepas = ler.nextLine();
                        System.out.print("RG: ");
                        String rg = ler.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = ler.nextLine();
                        System.out.print("Idade: ");
                        int idade = ler.nextInt();
                        Passageiro pass1 = new Passageiro(nomepas,rg, idade, endereco);
                        if(idade < 18){
                            System.out.println(pass1);
                            System.out.println("Idade: "+idade+" -- Menor de idade.");
                        } else{
                            System.out.println(pass1);
                            System.out.println("Idade: "+idade);
                        }
                        System.out.println("\nEscolha a estação de Partida: ");
                        for(int i = 0; i < estacoes.size(); i++){
                            System.out.println(i+". "+estacoes.get(i).getNome());
                        }
                        int indo = 0;
                        if (ler.hasNextInt()) {
                            System.out.print("Índice: ");
                            indo = ler.nextInt();
                        } else{
                            ler.next();
                            System.out.println("Entrada inválida. Tente novamente.");
                        }
                        System.out.println("\nEscolha a estação de Chegada: ");

                        for(int i = 0; i < estacoes.size(); i++){
                            if(!(estacoes.get(i) == estacoes.get(indo))){
                                System.out.println(i+". "+estacoes.get(i).getNome());
                            }
                        }
                        int voltando =0;
                        if (ler.hasNextInt()) {
                            System.out.print("Índice: ");
                            voltando = ler.nextInt();
                        } else{
                            ler.next();
                            System.out.println("Entrada inválida. Tente novamente.");
                        }
                        System.out.println("O preço será decidido quando for realizar a reserva.");
                        System.out.print("Forma de pagamento: ");
                        String pag = ler.nextLine();
                        bt.addPassageiro(pass1);
                        bt.adicionarBilhete(new Bilhete(estacoes.get(indo),estacoes.get(voltando),
                                            pag,LocalDateTime.now(),LocalDateTime.now()));

                    case 7:
                        System.out.print("Digite o nome da Companhia: ");
                        String nomeC = ler.next();
                        System.out.print("Id: ");
                        int id = ler.nextInt();
                        System.out.println("Quais estações são desta companhia?");ler.nextLine();

                        minhaCompanhia.mostrarEstacoesDisponiveis();
                        minhaCompanhia.escolherEstacoes(ler);
                        minhaCompanhia.mostrarEstacoesDisponiveis();
                        companhias.add(minhaCompanhia);
                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}

