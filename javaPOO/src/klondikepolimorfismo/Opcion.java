package klondikepolimorfismo;

abstract class Opcion {
    
    protected final String titulo;
    
    protected Opcion(String titulo){
        this.titulo = titulo;
    }
    
    public void mostar(int posicion){
        new GestorIO().out("\n" + posicion+". "+titulo);
    }
    
    public abstract void ejecutar();
    
}
