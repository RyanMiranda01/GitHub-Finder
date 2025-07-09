package br.com.projeto.LocaizadorDePerfilGITHUB.principal;

import br.com.projeto.LocaizadorDePerfilGITHUB.erros.ErroConsultaGitHubException;
import br.com.projeto.LocaizadorDePerfilGITHUB.funcionalidade.Localizador;
import br.com.projeto.LocaizadorDePerfilGITHUB.funcionalidade.Salvar;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args){
        int resposta = -1;
        Localizador localiza = new Localizador();
        Scanner digitar = new Scanner(System.in);
        Salvar salv = new Salvar();

        System.out.println("""
                ==============================
                🐙 Bem-vindo ao GitHub Finder!
                ==============================
                Pesquise qualquer perfil público do GitHub usando a API oficial.
                """);

        while (resposta != 0 && resposta != 1) {
            try {

                System.out.println("Caso queira pesquisar o perfil de alguém no git digite 1 mas caso queira sair digite 0");
                resposta = digitar.nextInt();
                digitar.nextLine();
                if(resposta != 1 && resposta != 0){
                    System.out.println("Só é possível os numeros 0 ou 1 tente de novo");
                }

            } catch (Exception i) {
                System.out.println("Só é possível os numeros 0 ou 1 tente de novo");
                digitar.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println();
                switch (resposta) {

                    case 1: {

                        System.out.println("Digite o nome de perfil que gostaria de receber as informações no GITHUB: ");
                        var perfil = digitar.next();
                        localiza.pesquisa(perfil);

                        System.out.println("Caso queira sair digite (0), Caso queira continuar digite (1), Caso queira ver o histórico digite (2), caso queira limpar o histórico digite (3)");
                        digitar.nextLine();
                        resposta = digitar.nextInt();
                        break;
                    }
                    case 2: {
                        localiza.getHistoricoPerfis();

                        System.out.println("Caso queira sair digite (0), Caso queira continuar digite (1), caso queira limpar o histórico digite (3)");
                        digitar.nextLine();
                        resposta = digitar.nextInt();
                        break;
                    }
                    case 3: {
                        localiza.excluirHistorico();

                        System.out.println("Caso queira sair digite (0), Caso queira continuar digite (1), Caso queira ver o histórico digite (2)");
                        digitar.nextLine();
                        resposta = digitar.nextInt();
                        break;
                    }
                    case 0: {
                        System.out.println("Obrigado por usar meu sistema de pesquisa, até a próxima...");
                        digitar.close();
                        return;
                    }
                }
            } catch (ErroConsultaGitHubException e) {
                System.out.println(e.getMessage());
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro de conexão. Tente novamente mais tarde.");
            } catch (InputMismatchException i) {
                System.out.println("Só é possível os numeros 0 ou 1, reinicie o sistema!!");
                break;
            }
        }
    }
}