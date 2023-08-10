package com;

public class Cliente {

    private String nome;
    private int idade;
    private int anoNascimento;
    private int cpf;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        if (idade >= 18){
            this.idade = idade;
        }
        else System.out.println("Menor de idade");
    }

    public int getAnoNascimento(){
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento){
        if (anoNascimento < 2005){
            System.out.println("Menor de idade");
        }
        else this.anoNascimento = anoNascimento;
    }

    public int getCpf(){
        return cpf;
    }

    public void setCpf(int cpf){
        this.cpf = cpf;
    }

}
