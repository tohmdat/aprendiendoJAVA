package klondikepolimorfismo;

abstract class OpcionKlondike extends Opcion {

    protected Tapete tapete;

    protected OpcionKlondike(String titulo, Tapete tapete) {
        super(titulo);
        this.tapete = tapete;
    }

    protected void error(String mensaje) {
        new GestorIO().out("Error!!! " + mensaje);
    }
    
    protected int recoger(String mensaje, int tope) {
        GestorIO gestorIO = new GestorIO();
        int posicion;
        boolean error;
        do {
            gestorIO.out("�" + mensaje + "? [1-" + tope + "]: ");
            posicion = gestorIO.inInt();
            error = !new Intervalo(1, tope).incluye(posicion);
            if (error) {
                this.error("Debe ser un n�mero entre 1 y " + tope + "\n");
            }
        } while (error);
        return posicion - 1;
    }
}
