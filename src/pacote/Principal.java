package pacote;

import java.util.Scanner;

public class Principal {
	
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;      
        
		while(executando) {                     //MENU :)
			System.out.println();
		    System.out.println("╔════════════════════════════════════════╗");
		    System.out.println("║          MENU DA BIBLIOTECA            ║");
		    System.out.println("╠════════════════════════════════════════╣");
		    System.out.println("║  1. ➕  Adicionar livro                ║");
		    System.out.println("║  2. 📋  Listar todos os livros         ║");
		    System.out.println("║  3. ➖  Remover livro                  ║");
		    System.out.println("║  4. 🔍  Buscar por título              ║");
		    System.out.println("║  5. 🏷️  Buscar por categoria           ║");
		    System.out.println("╠════════════════════════════════════════╣");
		    System.out.println("║  0. ⬅️  Sair                           ║");
		    System.out.println("╚════════════════════════════════════════╝");
		    System.out.print("➤ Escolha uma opção :");
        
		int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado
        
        
        switch (opcao) {
        
        	case 1:// cria/Adiciona Livros a Biblioteca

        	    System.out.print("-----------------------------------------\n\n");

                System.out.print("Titulo: ");
                String titulo = scanner.nextLine();
                
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                
                System.out.print("Ano: ");
                int ano = scanner.nextInt();
                
                System.out.print("Estoque: ");
                int estoque = scanner.nextInt();
                scanner.nextLine(); // Limpa buffer
                
                try {
                    Livro livro = new Livro(titulo, autor, categoria, ano, estoque);
                    biblioteca.adicionarLivro(livro);
                    System.out.println(" Livro cadastrado!");
                } catch (IllegalArgumentException e) {
                    System.out.println("\n " + e.getMessage());
                    System.out.println("Por favor, preencha todos os campos obrigatórios!\n");
                }
                
                break;
                
            case 2:// Lista Livros na B.
            	System.out.println("Lista Total de Livros:\n");
                biblioteca.listarLivros();
                
                break;
                
            case 3: // Remover livro por título
                System.out.print("\nDigite o titulo do livro a remover: ");
                String tituloRemover = scanner.nextLine().trim();
                
                if (tituloRemover.isEmpty()) {
                    System.out.println("\nTitulo não pode estar vazio!\n");
                } else {
                    boolean removido = biblioteca.removerLivroPorTitulo(tituloRemover);
                    
                    System.out.println();
                    if (removido) {
                        System.out.println("Livro '" + tituloRemover + "' removido com sucesso!\n");
                    } else {
                        System.out.println("Livro '" + tituloRemover + "' não encontrado na biblioteca.\n");
                    }
                }
                break;
                
            case 4:// Buscar livro por título
                System.out.print("\nDigite o titulo do livro: ");
                String tituloBusca = scanner.nextLine();
                
                Livro livroEncontrado = biblioteca.buscarPorTitulo(tituloBusca);
                
                if(livroEncontrado != null) {
                    System.out.println("\nLivro encontrado:");
                    livroEncontrado.exibir();
                }else {
                    System.out.println("\nLivro '" + tituloBusca + "' não encontrado.");
                }
                break;
                
            case 5: // Buscar livros por categoria
                System.out.print("\nDigite a categoria: ");
                String categoriaBusca = scanner.nextLine();
                
                System.out.println("\n======= LIVROS NA CATEGORIA: " + categoriaBusca + " =======\n");
                biblioteca.buscarPorCategoria(categoriaBusca);
                
                
                break;
                
            case 0:// saida do loop
            	
                executando = false;
                System.out.println("Saindo... Até logo!");
                break;
                
            default: // mostra uma mensagem de erro!
            	System.out.println("Opção inválida. Tente novamente.");
        }
        
    }
    
    scanner.close();
}
    
}