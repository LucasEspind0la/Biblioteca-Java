package pacote;

public class Livro {

		//Emcapsulamento
	
	  	private String titulo;
	    private String autor;
	    private String categoria;
	    private int ano;
	    private int estoque;
	    
	    //Construtor
	    
	    public Livro(String titulo, String autor, String categoria, int ano, int estoque) {
	    	
	    	if (titulo == null || titulo.trim().isEmpty()) {
	    		
	    	    throw new IllegalArgumentException("Título é obrigatório! ;( ");
	    	}
	    	if (autor == null || autor.trim().isEmpty()) {
	    		
	    	    throw new IllegalArgumentException("Autor é obrigatório! ;( ");
	    	}
	    	if (categoria == null || categoria.trim().isEmpty()) {
	   
	    	    throw new IllegalArgumentException("Categoria é obrigatória!  ;( ");
	    	}
	    	
	    	// dados já validados
	    	this.titulo = titulo.trim(); // opcional: .trim() para limpar espaços
	    	this.autor = autor.trim();
	    	this.categoria = categoria.trim();
	    	this.ano = ano;
	    	this.estoque = estoque;
	    	
	    }
	    
		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
		    if (titulo == null || titulo.trim().isEmpty()) {
		        throw new IllegalArgumentException("Título não pode ser vazio");
		    }
		    this.titulo = titulo.trim();
		}
		
		public void exibir() {
			
			System.out.println("┌──────────────────────────────────────┐");
		    System.out.println("│          LIVROS EM ESTOQUE           │");
		    System.out.println("└──────────────────────────────────────┘");
		    System.out.println("  Categoria: " + categoria);
		    System.out.println("  ────────────────────────────────────");
		    System.out.println("  Título:  " + titulo);
		    System.out.println("  Autor:   " + autor);
		    System.out.println("  Ano:     " + ano);
		    System.out.println("  Estoque: " + estoque + " unidade(s)");
		    System.out.println("  ────────────────────────────────────");
		}
}

