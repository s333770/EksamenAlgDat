package Eksamen2017;

public class LenketKø<T> implements Kø<T> {
    @Override
    public void leggInn(T verdi) {

    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        return null;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    private static final class Node<T>     // en indre nodeklasse
    {
        private T verdi;
        private Node<T> neste;

        private Node(Node<T> neste)    // nodekonstruktør
        {
            this.verdi = null;
            this.neste = neste;
        }

    }
}