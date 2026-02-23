package servico;

import java.util.List;
import modelo.ItemBiblioteca;
import repositorio.RepositorioBiblioteca;

public class Biblioteca {
	
	// Usa o repositório!
    private RepositorioBiblioteca repositorio; 
    
    public Biblioteca() {
        this.repositorio = new RepositorioBiblioteca();
    }
    
    // SERVIÇOS 
    public void adicionarItem(ItemBiblioteca item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo!");
        }
        
        // Validações de negocio
        if (item.getEstoque() < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo!");
        }
        
        // Delega para o repositório
        repositorio.salvar(item);  
        System.out.println("✅ '" + item.getTitulo() + "' adicionado com sucesso!");
    }
    
    public void listarItens() {
        if (repositorio.estaVazio()) {
            System.out.println("📭 A biblioteca está vazia!");
            return;
        }
        
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║        ITENS DA BIBLIOTECA           ║");
        System.out.println("╚══════════════════════════════════════╝\n");
        
        List<ItemBiblioteca> itens = repositorio.listarTodos();
        for (ItemBiblioteca item : itens) {
            item.exibir();
            System.out.println();
        }
    }
    
    public void buscarPorCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            System.out.println("⚠️ Categoria inválida!");
            return;
        }
        
        List<ItemBiblioteca> resultados = repositorio.buscarPorCategoria(categoria);
        
        System.out.println("\n🔍 Resultados para '" + categoria + "':\n");
        
        if (resultados.isEmpty()) {
            System.out.println("⚠️ Nenhum item encontrado na categoria: " + categoria);
        } else {
            for (ItemBiblioteca item : resultados) {
            	
                // Detecta o tipo para mostrar icone
                if (item instanceof modelo.Livro) {
                    System.out.println("📖 " + item.getTitulo() + " (Livro)");
                } else if (item instanceof modelo.Jogos) {
                    System.out.println("🎮 " + item.getTitulo() + " (Jogo)");
                } else {
                    System.out.println("📦 " + item.getTitulo());
                }
            }
        }
        System.out.println();
    }
    
    public ItemBiblioteca buscarPorTitulo(String titulo) {
        return repositorio.buscarPorTitulo(titulo);
    }
    
    public boolean removerItemPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return false;
        }
        
        boolean removido = repositorio.remover(titulo);
        
        if (removido) {
            System.out.println("✅ Item removido com sucesso!");
        } else {
            System.out.println("❌ Item não encontrado.");
        }
        
        return removido;
    }
}