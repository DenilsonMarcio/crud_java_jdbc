package br.com.bootcampdio;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        // -------------SELECT FROM
        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        // -------------SELECT FROM COM PARAMETRO
        System.out.println("Informe o ID para CONSULTAR: ");
        Scanner sc = new Scanner(System.in);
        int param = sc.nextInt();
        Aluno alunoParaConsulta = alunoDAO.getById(param);
        System.out.println(alunoParaConsulta);

        // -------------ADICIONAR
        System.out.println("Informe os dados para INSERIR no banco");
        System.out.println("Nome: ");
        Scanner scnome = new Scanner(System.in);
        String nome = scnome.next();
        System.out.println("Idade: ");
        Scanner scidade = new Scanner(System.in);
        int idade = scidade.nextInt();
        System.out.println("Estado: ");
        Scanner scestado = new Scanner(System.in);
        String estado = scestado.next();
        Aluno alunoParaInsercao = new Aluno(nome, idade, estado);
        alunoDAO.Adiciona(alunoParaInsercao);
        // alunos = alunoDAO.list();
        // alunos.stream().forEach(System.out::println);

        // -------------APAGAR
        System.out.println("Informe o ID para APAGAR: ");
        Scanner scapaga = new Scanner(System.in);
        int params = scapaga.nextInt();
        alunoDAO.Deleta(params);
        // alunos = alunoDAO.list();
        // alunos.stream().forEach(System.out::println);

        // -------------ATUALIZAR
        System.out.println("Informe os dados para ATUALIZAR no banco");
        System.out.println("ID: ");
        Scanner sid = new Scanner(System.in);
        int sid_ = sid.nextInt();
        System.out.println("Nome: ");
        Scanner snome = new Scanner(System.in);
        String nome_ = snome.next();
        System.out.println("Idade: ");
        Scanner sidade = new Scanner(System.in);
        int idade_ = sidade.nextInt();
        System.out.println("Estado: ");
        Scanner sestado = new Scanner(System.in);
        String estado_ = sestado.next();
        Aluno alunoParaAtualizar = alunoDAO.getById(sid_);
        alunoParaAtualizar.setNome(nome_);
        alunoParaAtualizar.setIdade(idade_);
        alunoParaAtualizar.setEstado(estado_);
        alunoDAO.Atualiza(alunoParaAtualizar);
        alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        // ***********************************************
        // FAZER UM SWITCH CASE PARA MONTAR UM MENU MELHOR
        // ***********************************************

    }

}
