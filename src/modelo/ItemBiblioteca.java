package modelo;

public interface ItemBiblioteca {
    
    // TITULO 
    String getTitulo();
    void setTitulo(String titulo);
    
    // CATEGORIA 
    String getCategoria();
    void setCategoria(String categoria);
    
    //  ANO 
    int getAno();
    void setAno(int ano);
    
    // ESTOQUE 
    int getEstoque();
    void setEstoque(int estoque);
    
    // EXIBIÇÃO 
    void exibir();
    void exibirEstilizado();
    void exibirVisual();
}