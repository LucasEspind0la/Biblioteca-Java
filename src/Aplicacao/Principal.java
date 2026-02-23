package Aplicacao;

import java.util.Scanner;

import modelo.ItemBiblioteca;
import modelo.Jogos;
import modelo.Livro;
import servico.Biblioteca;

public class Principal {
	
	
	// CORES PARA CONSOLE ANSI
	// ══════════════════════════════════════════════
	
	private static final String RESET = "\u001B[0m";
	private static final String RED = "\u001B[31m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String PURPLE = "\u001B[35m";
	private static final String CYAN = "\u001B[36m";
	private static final String BOLD = "\u001B[1m";
	
	// ══════════════════════════════════════════════
    
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;      
        
        //Loop
        while(executando) {

            								// MENU

        	System.out.println();
        	System.out.println(CYAN + "╔════════════════════════════════════════╗" + RESET);
        	System.out.println(CYAN + "║" + RESET + BOLD + "     📚 BIBLIOTECA DIGITAL 🎮           " + RESET + CYAN + "║" + RESET);
        	System.out.println(CYAN + "╠════════════════════════════════════════╣" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + GREEN + "1. ➕" + RESET + " Adicionar Livro                 " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + YELLOW + "2. ➕" + RESET + " Adicionar Jogo                  " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + RED + "3. 🗑️" + RESET + " Remover Item                    " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + BLUE + "4. 📋" + RESET + " Listar Todos os Itens           " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + PURPLE + "5. 🔍" + RESET + " Buscar por Título               " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + CYAN + "6. 🏷️" + RESET + " Buscar por Categoria            " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "╠════════════════════════════════════════╣" + RESET);
        	System.out.println(CYAN + "║" + RESET + "  " + RED + BOLD + "0. ⬅️  "       + RESET + " Sair                          " + CYAN + "║" + RESET);
        	System.out.println(CYAN + "╚════════════════════════════════════════╝" + RESET);
        	System.out.print(GREEN + BOLD + "\n➤ " + RESET + "Escolha uma opção: ");
            
            // Validaçao da entrada numerica
            
            int opcao;
            while (!scanner.hasNextInt()) {
                System.out.println("⚠ Por favor, digite apenas números!");
                scanner.next();
                System.out.print("➤ Escolha uma opção: ");
            }
            opcao = scanner.nextInt();
            
            // Limpa buffer
            scanner.nextLine(); 
            
            switch (opcao) {
                
       
                // ADICIONAR LIVRO
                case 1:
                    System.out.println("\n📖 === CADASTRAR NOVO LIVRO ===\n");
                    
                    System.out.print("Título: ");
                    String tituloLivro = scanner.nextLine();
                    
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    
                    System.out.print("Categoria/Gênero: ");
                    String categoriaLivro = scanner.nextLine();
                    
                    System.out.print("Ano de publicação: ");
                    int anoLivro = lerInteiro(scanner, "Ano inválido! Digite um número: ");
                    
                    System.out.print("Estoque: ");
                    int estoqueLivro = lerInteiro(scanner, "Estoque inválido! Digite um número: ");
                    
                    try {
                        Livro livro = new Livro(tituloLivro, autor, categoriaLivro, anoLivro, estoqueLivro);
                        biblioteca.adicionarItem(livro);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n❌ Erro: " + e.getMessage() + "\n");
                    }
                    break;
                
                // ADICIONAR JOGO
                case 2:
                    System.out.println("\n🎮 === CADASTRAR NOVO JOGO ===\n");
                    
                    System.out.print(CYAN + "  Título: " + RESET);
                    String tituloJogo = scanner.nextLine();
                    
                    System.out.print(CYAN + "  Plataforma: " + RESET);
                    String plataforma = scanner.nextLine();
                    
                    System.out.print(CYAN + "  Categoria: " + RESET);
                    String categoriaJogo = scanner.nextLine();
                    
                    System.out.print(CYAN + "  Ano: " + RESET);
                    int anoJogo = lerInteiro(scanner, "Ano inválido! Digite um número: ");
                    
                    System.out.print(CYAN + "  Estoque: " + RESET);
                    int estoqueJogo = lerInteiro(scanner, "Estoque inválido! Digite um número: ");                    
                    try {
                        //  Construtor com 5 parâmetros na ordem correta:
                        Jogos jogo = new Jogos(tituloJogo, plataforma, categoriaJogo, anoJogo, estoqueJogo);
                        
                        biblioteca.adicionarItem(jogo);
                        System.out.println(GREEN + "\n✅ Jogo '" + jogo.getTitulo() + "' cadastrado com sucesso!" + RESET);
                        
                    } catch (IllegalArgumentException e) {
                        System.out.println(RED + "\n❌ Erro: " + e.getMessage() + RESET + "\n");
                    }
                    break;

                 // REMOVE ITEM POR TITUL
                case 3:
                    System.out.print("\n🗑️ Digite o título EXATO do item a remover: ");
                    String tituloRemover = scanner.nextLine().trim();  // ← ✅ LER DO USUÁRIO!
                    
                    if (tituloRemover.isEmpty()) {
                        System.out.println("⚠️ Título não pode estar vazio!\n");
                    } else {
                    	
                        // remove Item das DUAS listas (Livro OU Jogo)
                    	boolean removido = biblioteca.removerItemPorTitulo(tituloRemover);
                        
                        if (removido) {
                            System.out.println("✅ '" + tituloRemover + "' removido com sucesso!\n");
                        } else {
                            System.out.println("❌ Item '" + tituloRemover + "' não encontrado.\n");
                        }
                    }
                    break;
                
                // LISTAR TODOS OS ITENS (COM TIPO)
                case 4:
                    System.out.println("\n📋 === LISTA COMPLETA ===");
                    biblioteca.listarItens();
                    break;
                
                // BUSCAR POR TiTULO/NOME
                case 5:
                    System.out.print("\n🔍 Digite o título para buscar: ");
                    String tituloBusca = scanner.nextLine().trim();
                    
                    if (tituloBusca.isEmpty()) {
                        System.out.println("⚠️ Campo de busca vazio!\n");
                        break;
                    }
                    
                    ItemBiblioteca encontrado = biblioteca.buscarPorTitulo(tituloBusca);
                    
                    if (encontrado != null) {
                        System.out.println("\n✅ Item encontrado: \n");
                        encontrado.exibir();
                    } else {
                        System.out.println("\n❌ Nenhum item com o título '" + tituloBusca + "' foi encontrado.\n");
                    }
                    break; 
                
                // BUSCA POR GENERO/CATEGORIA
                case 6:
                    System.out.print("\n🏷️ Digite o gênero/categoria (ex: Fantasia, Terror, RPG): ");
                    String categoriaBusca = scanner.nextLine().trim();
                    
                    if (categoriaBusca.isEmpty()) {
                        System.out.println("⚠️ Categoria não pode estar vazia!\n");
                        break;
                    }
                    
                    biblioteca.buscarPorCategoria(categoriaBusca);
                    break;
                
                //  SAIR DO SISTEMA
                case 0:
                    executando = false;
                    System.out.println("\n Saindo... Até logo!\n");
                    break;
                

                // DEFAULT: OPÇÃO INVÁLIDA
                default:
                    System.out.println("⚠️ Opção inválida! Escolha um número de 0 a 7.\n");
            }
            
            	// Pausa para leitura antes de voltar ao menu
            	if (executando) {
            		System.out.print("Pressione Enter para continuar...");
            		scanner.nextLine();
            }
        }
        			scanner.close();
    }
    
    // auxiliar para ler inteiros com validação
    private static int lerInteiro(Scanner scanner, String mensagemErro) {
        while (!scanner.hasNextInt()) {
            System.out.println("⚠️ " + mensagemErro);
            
            // Descarta entrada inválida
            scanner.next(); 
        }
        	int valor = scanner.nextInt();
        
        	// Limpa buffer
        	scanner.nextLine(); 
        	return valor;
    }
}