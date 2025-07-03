package javaaa;

//classe

public class Veterinario {
    private String nome;
    private String crmv;
    private String especialidade;
  
    public Veterinario(String nome, String crmv, String especialidade) { // construtor
      this.nome = nome;
      this.crmv = crmv;
      this.especialidade = especialidade;
    }
  
    public String getNome() { // pra pegar os coiso ja q estao privados
      return nome;
    }
    public String getCrmv() {
      return crmv;
    }
    public String getEspecialidade() {
      return especialidade;
    }
  
    public void exibirV() { // mostra tudinho
      System.out.println("Veterinário: " + nome + "CRMv: " + crmv + "Especialidade: " + especialidade);
    }
  }