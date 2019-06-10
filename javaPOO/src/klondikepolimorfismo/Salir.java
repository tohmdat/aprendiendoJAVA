package klondikepolimorfismo;

class Salir extends Opcion {

    private boolean ejecutada;
    
    protected Salir() {
        super("Salir");
        ejecutada = false;
    }

    @Override
    public void ejecutar() {
        ejecutada = true;
    }
    
    public boolean ejecutada(){
        return ejecutada;
    }
}
