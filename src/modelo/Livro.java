package modelo;

public class Livro implements ItemBiblioteca {

    // CORES PARA CONSOLE (ANSI)
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";
    
    // Encapsulamento
    private String titulo;
    private String autor;
    private String categoria;
    private int ano;
    private int estoque;
    
    // Construtor
    public Livro(String titulo, String autor, String categoria, int ano, int estoque) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título é obrigatório!");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor é obrigatório!");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria é obrigatória!");
        }
        if (ano < 1900 || ano > 2100) {
            throw new IllegalArgumentException("Ano inválido: " + ano);
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo!");
        }
        
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.categoria = categoria.trim();
        this.ano = ano;
        this.estoque = estoque;
    }
    
    // Getters e Setters
    
    public String getAutor() {
        return autor;
    }

    
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor é obrigatório!");
        }
        this.autor = autor.trim();
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria é obrigatória!");
        }
        this.categoria = categoria.trim();
    }

    @Override
    public int getAno() { 
        return ano;
    }

    @Override
    public void setAno(int ano) {  
        if (ano < 1900 || ano > 2100) {
            throw new IllegalArgumentException("Ano inválido: " + ano);
        }
        this.ano = ano;
    }

    @Override
    public int getEstoque() {
        return estoque;
    }

    @Override
    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo!");
        }
        this.estoque = estoque;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
    
    @Override
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        this.titulo = titulo.trim();
    } 
    
    @Override
    public void exibir() {
        System.out.println("  " + BOLD + "📖 LIVRO" + RESET);
        System.out.println(CYAN + "  " + "─".repeat(30) + RESET);
        System.out.println("  " + CYAN + "Título:" + RESET + "     " + BOLD + titulo + RESET);
        System.out.println("  " + CYAN + "Autor:" + RESET + "      " + autor);
        System.out.println("  " + CYAN + "Categoria:" + RESET + "  " + categoria);
        System.out.println("  " + CYAN + "Ano:" + RESET + "        " + ano);
        System.out.println("  " + CYAN + "Estoque:" + RESET + "    " + 
                          (estoque > 0 ? GREEN + estoque + " disponível" + RESET : RED + "Esgotado" + RESET));
    }

    @Override
    public void exibirEstilizado() {
        exibir(); 
    }

    @Override
    public void exibirVisual() {
        exibir();
    }
    
}  