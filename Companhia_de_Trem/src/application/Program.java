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
        
        Companhia companhiaTremBaum = new Companhia("Companhia Trem Baum", 8897);
        Estacao est1 = new Estacao("TrenBaum", "Rua Bahia - Bairro carajas", "ativo");
        Estacao est2 = new Estacao("TrenBaum - park", "Rua Luzes - Bairro Nova Jessy", "ativo");
        companhiaTremBaum.addEstacao(est1);
        companhiaTremBaum.addEstacao(est2);
        companhiaTremBaum.conectarEstacoes(est1, est2, 40.0);

        TremPassageiro tremPassageiro1 = new TremPassageiro(1, "Expresso", 1000, FonteDeEnergia.ELETRICA, 10, 60, 30.0);
        TremPassageiro tremPassageiro2 = new TremPassageiro(2, "Expresso", 1200, FonteDeEnergia.DIESEL, 15, 80, 50.0);
        companhiaTremBaum.addTrem(tremPassageiro1);
        companhiaTremBaum.addTrem(tremPassageiro2);

        boolean validacao = true;
        while (validacao){
            System.out.println("\n---Companhia Trem Baum---");
            System.out.println("1. Cadastrar empresa.");
            System.out.println("2. Cadastrar estação.");
            System.out.println("3. Comprar passagem.");
            System.out.println("4. Relatório das passsagens vendidas.");
            System.out.println("5. Realizar contrato.");
            System.out.println("6. Adicionar Trem.");
            System.out.println("7. Conectar estações.");
            System.out.println("8. Sair.");
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
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.INDUSTRIA));
                                            break;
                                        case 2:
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.MINERACAO));
                                            break;
                                        case 3:
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.SERVICOS));
                                            break;
                                        case 4:
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.AGRICULTURA));
                                            break;
                                        case 5:
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.AUTOMOTIVO));
                                            break;
                                        case 6:
                                            companhiaTremBaum.addEmpresa(new Empresa(nome, cnpj, end, numero, email, site, Setor.MANUFATUREIRA));
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

                            companhiaTremBaum.addEstacao(new Estacao(name, ende, op));

                            System.out.println("ESTAÇÃO CADASTRADA COM SUCESSO!");

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

                            System.out.println("======= BILHETERIA =======");
                            if (bilheteria.verificarIdade()) {
                                System.out.println("Estações: ");
                                companhiaTremBaum.exibir();

                                System.out.print("Informe a estação de Partida: ");
                                int indexPartida = ler.nextInt();
                                Estacao estacaoPartida = companhiaTremBaum.getEstacoes().get(indexPartida - 1);

                                companhiaTremBaum.getEstacoes().get(indexPartida-1).setBilheteria(bilheteria);

                                System.out.print("Informe a estação de Chegada: ");
                                int indexChegada = ler.nextInt();
                                ler.nextLine();
                                Estacao estacaoChegada = companhiaTremBaum.getEstacoes().get(indexChegada - 1);

                                System.out.print("Tipo de pagamento: ");
                                String formapagamento = ler.nextLine();

                                double distancia = companhiaTremBaum.obterDistanciaEntreEstacoes(estacaoPartida, estacaoChegada);
                                double valor = 0;

                                if (distancia != -1) {
                                    valor = bilheteria.valor(distancia);
                                } else {
                                    System.out.println("Erro ao obter a distância.");
                                    return;
                                }
                                int i = 0;
                                System.out.println("Trens disponíveis - selecione: ");
                                for (Trem trem : companhiaTremBaum.getTrens()) {
                                    if (trem instanceof TremPassageiro) {
                                        TremPassageiro tremPassageiro = (TremPassageiro) trem;
                                        System.out.printf("%d - id: %d - %s - %s\n", i+1, tremPassageiro.getNumero(), tremPassageiro.getModelo(), tremPassageiro.toString());
                                    }
                                    i++;
                                }

                                System.out.print("opção (numero): ");
                                int index = ler.nextInt();
                                TremPassageiro trem = (TremPassageiro) companhiaTremBaum.getTrens().get(index-1);
                                Reserva reserva = new Reserva(trem);

                                System.out.println("Reserve um assento: ");
                                reserva.mostrarAssentosDisponiveis();
                                System.out.print("\nInforme a numeração do assento escolhido: ");
                                int num = ler.nextInt(); ler.nextLine();
                                reserva.agendarAssento(num);

                                System.out.print("Informe data e horário de Partida (dd/MM/yyyy HH:mm): ");
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

                            for (Estacao estacao : companhiaTremBaum.getEstacoes()) {
                                i++;
                                System.out.printf("%d - %s%n", i, estacao.getNome());
                            }

                            System.out.print("Estação (número): ");
                            int num = ler.nextInt();

                            if (num < 1 || num > companhiaTremBaum.getEstacoes().size()) {
                                System.out.println("Número de estação inválido. Informe um número válido.");
                            } else {
                                Estacao estacao = companhiaTremBaum.getEstacoes().get(num - 1);

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
                            if (!companhiaTremBaum.getEmpresas().isEmpty()) {
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
                                for (Empresa empresa : companhiaTremBaum.getEmpresas()) {
                                    System.out.printf("%d - %s - %s%n", i, empresa.getNome(), empresa.getSetor());
                                    i++;
                                }

                                System.out.print("Empresa (numero): ");
                                int index = ler.nextInt();
                                ler.nextLine(); // Consume the newline character
                                Empresa empresa = companhiaTremBaum.getEmpresas().get(index - 1);

                                Contrato contrato = new Contrato(LocalDate.parse(dataInicio, formatoData), LocalDate.parse(dataFinal, formatoData), orcamento, tipoCarga, empresa);
                                companhiaTremBaum.addContrato(contrato);
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
                        System.out.println("==== Adicionando Trem ====");
                        System.out.println("Escolha o tipo de trem: \n1 - Trem de Passageiro\n 2 - Trem de Carga");
                        System.out.print("Opção: ");
                        int num = ler.nextInt(); ler.nextLine();
                        if (num >= 1 && num <= 2){
                            if (num == 1){
                                System.out.println(" -- Trem Passageiro --");
                                System.out.print("Numero: ");
                                int numero = ler.nextInt(); ler.nextLine();
                                System.out.print("Modelo: ");
                                String modelo = ler.nextLine();
                                System.out.print("Potencia: ");
                                int potencia = ler.nextInt();
                                System.out.print("Numero de Vagões: ");
                                int numVagao = ler.nextInt();
                                System.out.print("Capacidade de passageiros: ");
                                int capacPassag = ler.nextInt();
                                System.out.print("Capacidade de bagagem (m^2): ");
                                double capacidade = ler.nextDouble(); ler.nextLine();

                                TremPassageiro tremPassageiro = new TremPassageiro(numero, modelo, potencia, FonteDeEnergia.ELETRICA, numVagao, capacPassag, capacidade);
                                companhiaTremBaum.addTrem(tremPassageiro);
                            } else {
                                System.out.println(" -- Trem Carga --");
                                System.out.print("Numero: ");
                                int numero = ler.nextInt(); ler.nextLine();
                                System.out.print("Modelo: ");
                                String modelo = ler.nextLine();
                                System.out.print("Potencia: ");
                                int potencia = ler.nextInt();
                                System.out.print("Numero de Vagões: ");
                                int numVagao = ler.nextInt();
                                System.out.print("Capacidade de carga (m^2): ");
                                double capacidade = ler.nextDouble(); ler.nextLine();

                                TremCarga tremcarga = new TremCarga(numero, modelo, potencia, numVagao,FonteDeEnergia.ELETRICA, capacidade);
                                companhiaTremBaum.addTrem(tremcarga);
                            }
                        } else
                            System.out.println("Opção inválida");
                        System.out.println("ADICIONADO!");
                        break;
                    case 7:
                        int i = 0;
                        System.out.println(" ==== CONECTAR ESTAÇÕES ====");
                        System.out.println("Primeira estação: ");
                        List<Estacao> estacoesDisponiveis = new ArrayList<>(companhiaTremBaum.getEstacoes());

                        for (Estacao estacao : estacoesDisponiveis) {
                            System.out.printf("%d - %s%n", i+1, estacao.getNome());
                            i++;
                        }

                        System.out.print("Opção: ");
                        int opcao1 = ler.nextInt();
                        ler.nextLine();

                        if (opcao1 < 1 || opcao1 > estacoesDisponiveis.size()) {
                            System.out.println("Opção inválida");
                        } else {
                            Estacao primeira = estacoesDisponiveis.get(opcao1 - 1);
                            estacoesDisponiveis.remove(primeira);

                            i = 0;
                            System.out.println("Segunda estação: ");
                            for (Estacao estacao : estacoesDisponiveis) {
                                System.out.printf("%d - %s%n", i+1, estacao.getNome());
                                i++;
                            }

                            System.out.print("Opção: ");
                            int opcao2 = ler.nextInt();
                            ler.nextLine();

                            if (opcao2 < 1 || opcao2 > estacoesDisponiveis.size()) {
                                System.out.println("Opção inválida");
                            } else {
                                Estacao segunda = estacoesDisponiveis.get(opcao2 - 1);
                                System.out.print("Informe a distância das mesmas: ");
                                Double distancia = ler.nextDouble(); ler.nextLine();

                                companhiaTremBaum.conectarEstacoes(primeira, segunda, distancia);
                            }

                        }
                        System.out.println("\nCONEXÃO REALIZADA COM SUCESSO!");
                        break;
                    case 8:
                        validacao = false;
                        break;
                }
            } else {
                ler.next();
                System.out.println("Entrada inválida. Tente novamente.");
            }

        }
    }
}
