package javaaa;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Sistema sistema = new Sistema(); // inicia o sistema dentro do main
    Scanner scanner = new Scanner(System.in); // inicia o scanner (pra ler as coisa)
    int opcao;

    do { // "do" é fazer, ele vai fazer isso ai enquanto n for 0
        System.out.println("\n--- Clínica Veterinária ---");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Animal");
        System.out.println("3. Cadastrar Veterinário");
        System.out.println("4. Registrar Consulta");
        System.out.println("5. Consultar Histórico por CPF");
        System.out.println("6. Consultas Gerais");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt(); 
        scanner.nextLine();

        switch (opcao) { // esse switch vai pegar o valor q ta em opcao e dependendo do valor ele faz aqueles "casos" ali
            case 1: sistema.cadastrarCliente();
            break;
            case 2: sistema.cadastrarAnimal();
            break;
            case 3: sistema.cadastrarVeterinario();
            break;
            case 4: sistema.registrarConsulta();
            break;
            case 5: sistema.consultarHistoricoPorCpf();
            break;
            case 6: sistema.consultarMuito(); // Coloquei consultarMuito pq n tinha outro nome
            break;
            case 0: System.out.println("Tchauuu");
          default: System.out.println("Opção inválida."); // se n for nenhum dos casos, ele vai fazer isso
        }
    } while (opcao != 0);

    scanner.close();

  }
}