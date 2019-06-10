package klondikeconherencia;

import java.util.Random;

class Turno {

    private int valor;

    public Turno() {
        valor = new Random().nextInt(2);
    }

    public int toca() {
        return valor;
    }

    public int noToca() {
        return (valor + 1) % 2;
    }

    public void cambiar() {
        valor = this.noToca();
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        Turno turno;
        for (int i = 0; i < 10; i++) {
            turno = new Turno();
            gestorIO.out("Toca: " + turno.toca() + "\n");
            gestorIO.out("No toca: " + turno.noToca() + "\n");
            turno.cambiar();
            gestorIO.out("Cambiado\n");
            gestorIO.out("Toca: " + turno.toca() + "\n");
            gestorIO.out("No toca: " + turno.noToca() + "\n");
            gestorIO.out("\n");
        }
    }

}
