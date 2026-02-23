package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.ItemBiblioteca;

public class RepositorioBiblioteca {
    
    private List<ItemBiblioteca> acervo;
    
    public RepositorioBiblioteca() {
        this.acervo = new ArrayList<>();
    }
    
    // CRUD BÁSICO
    public void salvar(ItemBiblioteca item) {
        acervo.add(item);
    }
    
    public boolean remover(String titulo) {
        return acervo.removeIf(item -> 
            item.getTitulo().equalsIgnoreCase(titulo.trim()));
    }
    
    public List<ItemBiblioteca> listarTodos() {
    	
    	// Retorna cópia para proteger os dados
        return new ArrayList<>(acervo); 
    }
    
    // BUSCAS 
    public ItemBiblioteca buscarPorTitulo(String titulo) {
        String tituloBusca = titulo.trim().toLowerCase();
        
        for (ItemBiblioteca item : acervo) {
            if (item.getTitulo().toLowerCase().equals(tituloBusca)) {
                return item;
            }
        }
        return null;
    }
    
    public List<ItemBiblioteca> buscarPorCategoria(String categoria) {
        List<ItemBiblioteca> resultados = new ArrayList<>();
        String categoriaBusca = categoria.trim().toLowerCase();
        
        for (ItemBiblioteca item : acervo) {
            if (item.getCategoria().toLowerCase().equals(categoriaBusca)) {
                resultados.add(item);
            }
        }
        return resultados;
    }
    
    // INFORMAÇÕES 
    public int totalDeItens() {
        return acervo.size();
    }
    
    public boolean estaVazio() {
        return acervo.isEmpty();
    }
}