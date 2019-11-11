import java.util.Comparator;

public class SBinTree<T> {
    public SBinTree(Comparator<? super T> c)  // konstruktør - lager et tomt tre
    {
        rot = null;    // rot er null i et tomt tre
        antall = 0;    // et tomt tre har ingen noder
        høyde = -1;    // et tomt tre har høyde lik -1
        comp = c;      // komparatoren får verdi
    }

    private static final class Node<T> // en indre nodeklasse
    {
        private final T verdi;           // nodens verdi
        private Node<T> venstre, høyre;  // venstre og høyre barn

        private Node(T verdi)  // konstruktør
        {
            this.verdi = verdi;
            venstre = høyre = null;
        }

    }
    private Node<T> rot;
    private int antall;
    private int høyde;
    private final Comparator<? super T> comp;



    public int antall() { return antall; }

    public boolean tom() { return antall == 0; }

    public int høyde() { return høyde; }

    public void leggInn(T verdi)
    {
        Node<T> p = rot, q = null;
        int cmp = 0;
        int nivå=0; //Ny instansvariabel

        while (p != null)
        {
            q = p;
            nivå++; // Her mp vi legge til verdi
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        p = new Node<>(verdi);
        if (q == null) rot = p;
        else if (cmp < 0) q.venstre = p;
        else q.høyre = p;
        if (nivå > høyde) høyde = nivå;  // ny programsetning

        antall++;
    }


    public T min()
    {
        if(tom()){
            return null;
        }
        Node<T> p=rot;
       while(p.venstre!=null)  {
            p=p.venstre;
        }
        return p.verdi;
    }
             /*
    private int dybde(Node<T> p)
{
        // Skal kodes
    }

    public T[] nedersteNivå()
    {
        // Skal kodes
    }
                    */
} // class SBinTre

