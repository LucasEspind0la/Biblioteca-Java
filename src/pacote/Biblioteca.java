package pacote;

public class Biblioteca {
	
	private Livro[] livros;
	private int totalDeLivros;
	
	
	//Construtor
	
	public Biblioteca() {
		this.livros = new Livro[10];
		this.totalDeLivros = 0;
	
	}
	
	public void adicionarLivro(Livro livro) {
		if(livro == null) {
			System.out.println(" Não foi Possivel adicionar o LIVRO!");
			return;
		}
		
		
		if(totalDeLivros < livros.length) {
			livros[totalDeLivros] = livro;
			totalDeLivros++;
			System.out.println("Livro '" + livro.getTitulo() + "' adicionado com sucesso!");
		}else {
			System.out.println(" Biblioteca Cheia!" + livros.length);
		}
	}
	
	public void listarLivros() {
		if (totalDeLivros == 0) {
			System.out.println("A biblioteca esta VAZIA!");
			return;
		}
			System.out.println("\n╔═════════════════=════════════════════╗");
			System.out.println("║      LISTA DE LIVROS CADASTRADOS     ║");
			System.out.println("╚══════════════════════════════════════╝\n");
		
		for(int posicao = 0; posicao < totalDeLivros; posicao ++) {
			livros[posicao].exibir();
		}
	}
	
	public void buscarPorCategoria(String categoria) {
	    boolean encontrado = false;
        
        for (int posicao = 0; posicao < totalDeLivros; posicao++) {
            if (livros[posicao].getCategoria().equalsIgnoreCase(categoria)) {
                livros[posicao].exibir();
                encontrado = true;
            } 
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado na categoria: " + categoria);
        }
    }

	public Livro buscarPorTitulo(String titulo) {
	    for (int posicao = 0; posicao < totalDeLivros; posicao++) {
	        if (livros[posicao].getTitulo().equalsIgnoreCase(titulo)) {
	        	return livros[posicao]; // Encontrou e retorna o livro da posição i
	        }
	    }
	    return null; // Nao encontrou
	}
	
	public boolean removerLivroPorTitulo(String tituloRemover) {
	    if (tituloRemover == null || tituloRemover.trim().isEmpty()) {
	        return false;
	    }
	    
	    String tituloBusca = tituloRemover.trim();
	    
	    for (int posicao = 0; posicao < totalDeLivros; posicao++) {
	        if (livros[posicao] != null && livros[posicao].getTitulo().equalsIgnoreCase(tituloBusca)) {
	        	
	            // Desloca os livros seguintes para preencher o espaço
	        	
	            for (int proximaPosicao = posicao; proximaPosicao < totalDeLivros - 1; proximaPosicao++) {
	                livros[proximaPosicao] = livros[proximaPosicao + 1];
	            }
	            livros[totalDeLivros - 1] = null; // Limpa última posição
	            totalDeLivros--; // DECREMENTo
	            return true;
	        }
	    }
	    
	    return false;
	}
}
