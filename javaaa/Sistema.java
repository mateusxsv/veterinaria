package javaaa;

import java.time.LocalDate; // data
import java.util.ArrayList; // listinha 2 (nao me pergunte)
import java.util.List; // listinha
import java.util.Scanner; // ler

// so as coisa pro sistema funcionar

public class Sistema { // inicia a classe
  Cliente clienteA = new Cliente("Guilherme", "892.267.637-42", "(81) 9866M-60FD"); // isso é de teste
    
  private List<Cliente> clientes = new ArrayList<>();
  private List<Animal> animais = new ArrayList<>();
  private List<Veterinario> veterinarios = new ArrayList<>();
  private List<Consulta> consultas = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public Sistema() { // tive q fazer isso pra o cliente aparecer toda vez q algm chamar a classe sistema
      clientes.add(clienteA);
  }

  private Cliente buscarPorCpf(String cpf) { // aqui ele vai buscar por cpf
    for (Cliente c : clientes) { // pra cada cliente dentro da lista
        if (c.getCpf().equals(cpf)) return c; // se o cpf do cliente bater certinho, deu certo
    }
    return null; // se nao da errado (simples)
  }

  private Animal buscarAnimal(String nome) { // mesmissima coisa soq com nome (ate pq animal n tem cpf)
    for (Animal a : animais) { // bla bla bla
        if (a.getNome().equalsIgnoreCase(nome)) return a;
    }
    return null;
  }

  private Veterinario buscarVeterinario(String nome) { // da pra entender
    for (Veterinario v : veterinarios) {
        if (v.getNome().equalsIgnoreCase(nome)) return v;
    }
    return null;
  }

  public void cadastrarCliente() { // cadastrar o cliente na listinha e na classe dele
    System.out.println("Insira o nome do Cliente: ");
    String nome = scanner.nextLine(); // nome
    System.out.println("Insira o CPF do Cliente: ");
    String cpf = scanner.nextLine(); // cpf
    System.out.println("Insira o telefone do Cliente: ");
    String telefone = scanner.nextLine(); // deu pra entender
    clientes.add(new Cliente(nome, cpf, telefone)); // colocou na lista e dps na classe 
    System.out.println("Cliente cadastrado.");
  }

  public void cadastrarAnimal() {
    System.out.println("Insira o CPF do dono: ");
    String cpf = scanner.nextLine();
    Cliente dono = buscarPorCpf(cpf); // o metodo pra procurar
    if (dono == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }
    // se der certo continua
    System.out.println("Insira o nome do Animal: "); // nao vou comentar isso
    String nome = scanner.nextLine();
    System.out.println("Insira a espécie do Animal: ");
    String especie = scanner.nextLine();
    System.out.println("Insira a idade do Animal: ");
    int idade = scanner.nextInt();
    scanner.nextLine();
    animais.add(new Animal(nome, especie, idade, dono));
    System.out.println("Animal cadastrado.");
  }

  public void cadastrarVeterinario() { // da pra entender
    System.out.println("Insira o nome do Veterinário: ");
    String nome = scanner.nextLine();
    System.out.println("Insira o CRMV do Veterinário: ");
    String crmv = scanner.nextLine();
    System.out.println("Insira a especialidade do Veterinário: ");
    String especialidade = scanner.nextLine();
    veterinarios.add(new Veterinario(nome, crmv, especialidade));
    System.out.println("Veterinário cadastrado.");
  }

  public void registrarConsulta() {
    System.out.println("Insira o nome do Animal que vai receber a consulta: ");
    String nomeAnimal = scanner.nextLine();
    Animal animal = buscarAnimal(nomeAnimal);
    if (animal == null) { // ele tem q verificar se o animal existe ate pq n da pra fazer consulta sem nada
        System.out.println("Animal não encontrado.");
        return;
    }

    System.out.println("Insira o nome do Veterinário: "); // e n da pra fazer consulta sem veterinario
    String nomeVeterinario = scanner.nextLine();
    Veterinario veterinario = buscarVeterinario(nomeVeterinario);
    if (veterinario == null) {
        System.out.println("Veterinário não encontrado.");
        return;
    }

    System.out.println("Insira a data da consulta (AAAA-MM-DD): "); // aqui complica soq é simples
    String dataTexto = scanner.nextLine();
    
    try {
        LocalDate data = LocalDate.parse(dataTexto); // .parse é um método para transformar texto em data
        consultas.add(new Consulta(data, animal, veterinario)); // adiciona na lista
        System.out.println("Consulta registrada. (não bugou!"); // nao bugou
    }
    catch (Exception e) { // Exception é uma class Deus q tem todos os erros, e o "e" é a forma q a classe ta sendo chamada
        System.out.println("Data inválida. Use o formato AAAA-MM-DD (ou não bugou não.)"); // bugou
    }
  }

    public void consultarHistoricoPorCpf() { // faz a mesma coisa, soq ao inves de so ver se existe ele mostra o historico la embaixo
        System.out.println("Insira o CPF do Cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Histórico de consultas:"); // olha ele aqui
        for (Consulta c : consultas) { // pra cada consulta dentro da lista de consultas
            if (c.getCliente().getCpf().equals(cpf)) {
                c.exibirResumo(); //exibirResumo é um método q mostra tudo q tem na consulta
            }
        }
    }

    public void consultarMuito() { // ele consulta muito
        System.out.println();
        System.out.println("1. Consultar Clientes");
        System.out.println("2. Consultar Animais");
        System.out.println("3. Consultar Veterinários");
        System.out.println("0. Voltar");
        int opcao = scanner.nextInt();
        scanner.nextLine();

       switch (opcao) {
           case 1: System.out.println("Insira o CPF do Cliente: ");
                   String cpf = scanner.nextLine();
                   Cliente cliente = buscarPorCpf(cpf); // buscando
                   if (cliente != null) {
                       cliente.exibirC(); // quando ele acha, esse "exibirC" mostra tudo q tem no cliente
                       break; // esse break para o codigo se der tudo certo
                   } else {
                       System.out.println("Cliente não encontrado.");
                       return; // o return é o contrario
                   }
           case 2: System.out.println("Insira o nome do Animal: "); // nao vou fazer isso toda vez
                   String nomeAnimal = scanner.nextLine();
                   Animal animal = buscarAnimal(nomeAnimal);
                   if (animal != null) {
                       animal.exibirA();
                       break;
                   } else {
                       System.out.println("Animal não encontrado.");
                       return;
                   }
           case 3: System.out.println("Insira o nome do Veterinário: ");
                   String nomeVeterinario = scanner.nextLine();
                   Veterinario veterinario = buscarVeterinario(nomeVeterinario);
                   if (veterinario != null) {
                       veterinario.exibirV();
                       break;
                   } else {
                       System.out.println("Veterinário não encontrado.");
                       return;
                   }
           case 0: return; // se a pessoa quiser sair é isso ai
       }
    }
  }
