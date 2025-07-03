package javaaa;

import java.time.LocalDate; // eu faço data

public class Consulta {
    private LocalDate data; // localdate é uma classe q funciona pra data
    private Animal animal; // "Animal" é uma classe e "animal" é um objeto dentro dela
    private Veterinario veterinario; // mesma coisa

    public Consulta(LocalDate data, Animal animal, Veterinario veterinario) { // construtor
        this.data = data;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public void exibirResumo() { // mostra tudinho
        System.out.println("Consulta em: " + data + " Animal: " + animal.getNome() + " Vet: " + veterinario.getNome());
    }

    public Cliente getCliente() { // para buscar o cliente
        return animal.getDono(); // o dono do animal é o cliente
    }
}
