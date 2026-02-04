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
	    	
	    	this.titulo = titulo;
	    	this.autor = autor;
	    	this.categoria = categoria;
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
			this.titulo = titulo;
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

