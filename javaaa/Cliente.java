package javaaa;

// isso é uma classe
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
  
    public Cliente(String nome, String cpf, String telefone) { // construtor
      this.nome = nome;
      this.cpf = cpf;
      this.telefone = telefone;
    }
  
    public String getNome() {
      return nome; 
    }
    public String getCpf() { 
      return cpf; 
    }
    public String getTelefone() { // get é pegar, como ta privado tem q ter um metodo "public" pra pegar
      return telefone; 
    }
  
    public void setTelefone(String telefone) { 
        this.telefone = telefone;
    }
    public void exibirC() { // mostra tudinho
        System.out.println("Cliente: " + nome + " CPF: " + cpf + " Telefone: " + telefone);
    }
  }