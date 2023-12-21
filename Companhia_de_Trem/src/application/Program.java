package application;

import model.entities.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Estacao> estacoes = new ArrayList<>();
        Companhia companhiaecia = new Companhia("Companhia & cia", 10);

        Estacao estacao1 = new Estacao("Cia Station", "Rua Bahia - Bairro carajas", "ativo");
        Estacao estacao2 = new Estacao("Cia&Cia Station", "Rua Lord - Bairro Flores", "ativo");

        Passageiro pass = new Passageiro();
        Bilhete bilhete2 = new Bilhete(estacao1, estacao2, 3.0, "cartao", LocalDateTime.now(), LocalDateTime.now());
        Bilheteria bt = new Bilheteria(pass);
        bt.adicionarBilhete(bilhete2);
        bt.imprimirBilhete();

        Empresa surprise = new Empresa("Surprise", "12.345.678/0001-90", "Rua Florida - bairro Sao Jorge", 156, "surprise@gmail.com", "surprise.com", Setor.SERVICOS);

        Companhia companiaTremBaum = new Companhia("Companhia Trem Baum", 8897);
        Estacao est1 = new Estacao("TrenBaum", "Rua Bahia - Bairro carajas", "ativo");
        Estacao est2 = new Estacao("TrenBaum - park", "Rua Luzes - Bairro Nova Jessy", "ativo");
        companiaTremBaum.addEstacao(est1);
        companiaTremBaum.addEstacao(est2);
        companiaTremBaum.conectarEstacoes(est1, est2, 40.0);

        TremPassageiro tremPassageiro1 = new TremPassageiro(1, "Expresso", 1000, FonteDeEnergia.ELETRICA, 10, 60, 30.0);
        TremPassageiro tremPassageiro2 = new TremPassageiro(2, "Expresso", 1200, FonteDeEnergia.DIESEL, 15, 80, 50.0);


        while (true){
            System.out.println("\n---Companhia Trem Baum---");
            System.out.println("1. Cadastrar empresa.");
            System.out.println("2. Cadastrar estação.");
            System.out.println("3. Comprar passagem.");
            System.out.println("4. Relatório das passsagens vendidas.");
            System.out.println("5. Realizar contrato.");
            System.out.println("5. Visualizar o trajeto de cada trem.");
            System.out.println("6. Visualizar passagens já reservadas.");
            System.out.println("7. Cadastrar companhia.");
            int menu;
            System.out.print("Opção: ");

            if (ler.hasNextInt()) {
                menu = ler.nextInt(); ler.nextLine();
                switch(menu) {
                    case 1:
                        try {
                            System.out.print("Digite o nome da empresa: ");
                            String nome = ler.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = ler.nextLine();
                            System.out.print("Endereço: ");
                            String end = ler.nextLine();
                            System.out.print("Numero: ");
                            int numero = ler.nextInt();
                            ler.nextLine(); // Consumir a quebra de linha após o número
                            System.out.print("Email: ");
                            String email = ler.nextLine();
                            System.out.print("Site: ");
                            String site = ler.nextLine();

                            while (true) {
                                System.out.println("Qual setor?");
                                System.out.println("1. Indústria.");
                                System.out.println("2. Mineração.");
                                System.out.println("3. Serviços.");
                                System.out.println("4. Agricultura.");
                                System.out.println("5. Automotivo.");
                                System.out.println("6. Manufatureira.");

                                int set;

                                try {
                                    set = ler.nextInt();

                                    switch (set) {
                                        case 1:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.INDUSTRIA));
                                            break;
                                        case 2:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.MINERACAO));
                                            break;
                                        case 3:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.SERVICOS));
                                            break;
                                        case 4:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.AGRICULTURA));
                                            break;
                                        case 5:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.AUTOMOTIVO));
                                            break;
                                        case 6:
                                            companiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.MANUFATUREIRA));
                                            break;
                                        default:
                                            System.out.println("Número inválido.");
                                            break;
                                    }
                                    break;  // Sair do loop se a entrada for válida
                                } catch (InputMismatchException e) {
                                    ler.nextLine();  // Consumir a entrada inválida
                                    System.out.println("Entrada inválida. Tente novamente.");
                                }
                            }
                            System.out.println("\nEMPRESA CRIADA COM SUCESSO!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Digite o nome da estação: ");
                            String name = ler.nextLine();
                            System.out.print("Endereço: ");
                            String ende = ler.nextLine();
                            System.out.print("Estado operacional: ");
                            String op = ler.nextLine();

                            companiaTremBaum.addEstacao(new Estacao(name, ende, op));

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de fornecer o tipo correto de dados.");
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro durante a leitura. Detalhes: " + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("====== Cadastro de Passageiro ======");
                            System.out.println("||\tInforme os seguintes dados\t||");

                            System.out.print("Nome: ");
                            String nome = ler.nextLine();
                            System.out.print("RG: ");
                            String rg = ler.nextLine();
                            System.out.print("Idade: ");
                            int idade = ler.nextInt();
                            ler.nextLine(); // Consumir a quebra de linha após a leitura de int

                            Passageiro passageiro = new Passageiro(nome, rg, idade);
                            Bilheteria bilheteria = new Bilheteria(passageiro);

                            System.out.println("====== BILHETERIA =======");
                            if (bilheteria.verificarIdade()) {
                                System.out.println("Estações: ");
                                companiaTremBaum.exibir();

                                System.out.print("Informe a estação de Partida: ");
                                int indexPartida = ler.nextInt();
                                Estacao estacaoPartida = companiaTremBaum.getEstacoes().get(indexPartida - 1);

                                companiaTremBaum.getEstacoes().get(indexPartida-1).setBilheteria(bilheteria);

                                System.out.print("Informe a estação de Chegada: ");
                                int indexChegada = ler.nextInt();
                                ler.nextLine();
                                Estacao estacaoChegada = companiaTremBaum.getEstacoes().get(indexChegada - 1);

                                System.out.print("Tipo de pagamento: ");
                                String formapagamento = ler.nextLine();

                                double distancia = companiaTremBaum.obterDistanciaEntreEstacoes(estacaoPartida, estacaoChegada);
                                double valor = 0;

                                if (distancia != -1) {
                                    valor = bilheteria.valor(distancia);
                                } else {
                                    System.out.println("Erro ao obter a distância.");
                                    return;
                                }

                                System.out.println("Informe data e horário de Partida (dd/MM/yyyy HH:mm): ");
                                String data = ler.nextLine();
                                LocalDateTime dataPartida = LocalDateTime.parse(data, formatoData);

                                Bilhete bilhete = new Bilhete(estacaoPartida, estacaoChegada, valor, formapagamento, LocalDateTime.now(), dataPartida);
                                bilheteria.adicionarBilhete(bilhete);
                                System.out.println(bilheteria.imprimirBilhete());
                                System.out.println("BILHETE FINALIZADO -- Obrigado pela compra!\n");
                            } else {
                                System.out.println("Idade insuficiente para comprar uma passagem.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de fornecer o tipo correto de dados.");
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            int i = 0;
                            System.out.println("|\tInforme a estação do relatório\t|");

                            for (Estacao estacao : companiaTremBaum.getEstacoes()) {
                                i++;
                                System.out.printf("%d - %s%n", i, estacao.getNome());
                            }

                            System.out.print("Estação (número): ");
                            int num = ler.nextInt();

                            if (num < 1 || num > companiaTremBaum.getEstacoes().size()) {
                                System.out.println("Número de estação inválido. Informe um número válido.");
                            } else {
                                Estacao estacao = companiaTremBaum.getEstacoes().get(num - 1);

                                System.out.println("\t----- Relatório -----");

                                if (estacao.getBilheteria() != null) {
                                    estacao.getBilheteria().relatorio();
                                } else {
                                    System.out.println("A estação selecionada não possui uma bilheteria para gerar relatório.");
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de fornecer um número inteiro.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Número de estação inválido. Informe um número válido.");
                        } break;

                    case 5:
                        try {
                            if (!companiaTremBaum.getEmpresas().isEmpty()) {
                                System.out.println("--- Informações para realização do Contrato ---");
                                System.out.print("Data de inicio (dd/MM/yyyy HH:mm): ");
                                String dataInicio = ler.nextLine();
                                System.out.print("Data de término (dd/MM/yyyy HH:mm): ");
                                String dataFinal = ler.nextLine();
                                System.out.print("Orçamento: ");
                                Double orcamento = ler.nextDouble();
                                ler.nextLine();
                                System.out.print("Tipo de Carga: ");
                                String tipoCarga = ler.nextLine();
                                System.out.println("Escolha a empresa relacionada: ");

                                int i = 1;
                                for (Empresa empresa : companiaTremBaum.getEmpresas()) {
                                    System.out.printf("%d - %s - %s%n", i, empresa.getNome(), empresa.getSetor());
                                    i++;
                                }

                                System.out.print("Empresa (numero): ");
                                int index = ler.nextInt();
                                ler.nextLine(); // Consume the newline character
                                Empresa empresa = companiaTremBaum.getEmpresas().get(index - 1);

                                Contrato contrato = new Contrato(LocalDate.parse(dataInicio, formatoData), LocalDate.parse(dataFinal, formatoData), orcamento, tipoCarga, empresa);
                                companiaTremBaum.addContrato(contrato);
                                System.out.println("CONTRATO REALIZADO COM SUCESSO");
                                System.out.println(contrato.toString());
                            } else {
                                System.out.println("Cadastre uma empresa antes!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de fornecer os dados corretamente.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Índice inválido. Verifique a lista de empresas e escolha um número válido.");
                        }
                        break;
                    case 6:

                        break;
                    case 7:



                        break;
                    case 8:

                        break;

                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}
