package klondikepolimorfismo;

class Menu {

    private Opcion[] opciones;
    
    private int cantidad;
    
    private Salir salir;
    
    public Menu(){
        opciones = new Opcion[100];
        cantidad = 0;
        salir = new Salir();
    }
    
    public void añadir(Opcion opcion){
        opciones[cantidad] = opcion;
        cantidad++;
    }
    
    public void cerrar(){
        this.añadir(salir);
    }
    
    public void mostrar(){
        for (int i = 0; i < cantidad; i++) {
            opciones[i].mostar(i+1);
        } 
    }
    
    public Opcion getOpcion() {
        GestorIO gestorIO = new GestorIO();
        int opcion;
        boolean error;
        do {
            gestorIO.out("\nOpciñn? [1-" + cantidad + "]: ");
            opcion = gestorIO.inInt();
            error = !new Intervalo(1,cantidad).incluye(opcion);
            if (error){
                gestorIO.out("Error!!! La opciñn debe ser entre 1 y 9");
            }
        } while (error);
        return opciones[opcion-1];
    }

    public boolean terminado() {
        return salir.ejecutada();
    }

}
