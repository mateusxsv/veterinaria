package javaaa;

// isso é uma classe
public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private Cliente dono; // esse "Cliente dono" se refere a um cliente todo dentro da classe Cliente
      
    public Animal(String nome, String especie, int idade, Cliente dono) { // construtor
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.dono = dono;
    }
    public String getNome() { return nome; } // como as variaveis estao privadas, tem q ter um metodo pra puxar elas. "get" é pegar em ingles
    public String getEspecie() { return especie; }
    public int getIdade() { return idade; }
    public Cliente getDono() { return dono; }
  
    public void exibirA() { // esse metodo é pra exibir tudo q tem no animal
        System.out.println("Animal: " + nome + " Espécie: " + especie + " Idade: " + idade + " Dono: " + dono.getNome());
      }
  }
