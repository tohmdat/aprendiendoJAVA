package klondikeconherencia;

public class Menu {

    private static final String[] TITULOS = new String[]{
        "\n1. Mover de baraja a descarte",
        "\n2. Mover de descarte a palo",
        "\n3. Mover de descarte a columna",
        "\n4. Mover de palo a columna",
        "\n5. Mover de columna a palo",
        "\n6. Mover de columna a columna",
        "\n7. Voltear carta en columna",
        "\n8. Voltear descarte en baraja",
        "\n9. Salir"
    };
    
    private static final Intervalo OPCIONES = new Intervalo(1,9);
    
    public void mostrar(){
        GestorIO gestorIO = new GestorIO();
        for (String titulo : TITULOS) {
            gestorIO.out(titulo);
        }
    }
    
    public int getOpcion() {
        GestorIO gestorIO = new GestorIO();
        int opcion;
        boolean error;
        do {
            gestorIO.out("\nOpci�n? [1-9]: ");
            opcion = gestorIO.inInt();
            error = !OPCIONES.incluye(opcion);
            if (error){
                gestorIO.out("Error!!! La opci�n debe ser entre 1 y 9");
            }
        } while (error);
        return opcion;
    }

}
