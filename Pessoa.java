package app;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa() {
        // Construtor vazio (opcional)
    }

    // ✅ Este é o construtor que você precisa
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void alterar(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String exibir() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}
