package klondikesinherencia;

import java.util.Random;

class Baraja {

    private Carta[] cartas;

    private int ultima;

    public static final int NUM_PALOS = 4;

    public static final int NUM_NUMEROS = 13;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[NUM_PALOS * NUM_NUMEROS];
        for (int i = 0; i < NUM_PALOS; i++) {
            for (int j = 0; j < NUM_NUMEROS; j++) {
                this.poner(new Carta(i, j));
            }
        }
        this.barajar();
    }
    
    private void barajar(){
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(NUM_PALOS * NUM_NUMEROS);
            int destino = aleatorio.nextInt(NUM_PALOS * NUM_NUMEROS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    private boolean vacia() {
        return ultima == 0;
    }

    private boolean completa() {
        return ultima == NUM_PALOS * NUM_NUMEROS;
    }

    private Carta cima() {
        assert !this.vacia();
        return cartas[ultima - 1];
    }

    public Carta sacar() {
        assert !this.vacia();
        ultima--;
        return cartas[ultima];
    }

    public void poner(Carta carta) {
        assert carta != null;
        assert !carta.bocaArriba();
        assert !this.completa();
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nBaraja: ");
        if (this.vacia()) {
            gestorIO.out("<VACIA>");
        } else {
            this.cima().mostrar();
        }
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en baraja");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        Baraja baraja = new Baraja();
        for (int i = 0; i < 47; i++) {
            gestorIO.out("\nCompleto? " + baraja.completa());
            gestorIO.out("\nVacia? " + baraja.vacia());
            Carta carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        }
    }

}
