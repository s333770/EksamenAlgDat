import java.util.Comparator;
import java.util.Queue;

public class EksamenVår2017 {
    /* Mitt forslag
    public static void snu(int[] a){
        String utString="";
        int teller=0;
        int lengde =a.length;
        int ut[]= new int[lengde];
        for(int i=lengde-1; i>=0; i--){
            ut[teller]=a[i];
            teller++;
        }
        for(int i=0; i<ut.length;i++){
            a[i]=ut[i];
        }

    }
     */
    //Fasit svar;
    public static void snu(int[] a)
    {
        int[] b = a.clone();
        for (int i = b.length - 1, j = 0; i >= 0; i--, j++) a[j] = b[i];
    }
    //Kan også lages med en bytt funksjon
    public static void bytt(int[] a,int i,int j){
        int temp=a[i];
         a[i]=a[j];
         a[j]=temp;
    }
    public static void snu2(int a[]){
        for(int i=0, j=a.length-1;j>i;  ){
            bytt(a,i++,j--);
        }
    }
    public static int finn2(int [] a, int verdi ){
        int i=0;
        while (i<a.length && a[i]<verdi){
           i++;
        }
        if(i<a.length && a[i]==verdi){
            return i;
        }
        else{
            return -(i+1);
        }
    }

    public static int finn(int[] a, int verdi)
    {
        int v = 0, h = a.length - 1;  // hver sin ende av tabellen

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else break;                              // funnet
        }

        if (v > h) return -(v + 1);  // v er innsettingspunktet

        // må finne den første hvis det er flere forekomster av verdi
        while (v > 0 && a[v - 1] == verdi) v--;
        return v;
    }
    /*Oppgave 2
    Spør om hjelp med Hoffman trær

                           1, E
                           /   \
                        2, I       3, B
                     /   \           /  \
                4,G     5,A     6,H     7,K
             /   \     /   \      \       /
                     10,L  11,O    13, D  14, N
    *
    public static <T> int fjernBakerst(Kø<T> kø, int antall){
        int n=kø.antall(); // n= antall kø
        if(antall<0){ //Antall er ikke mindre enn null
            throw new IllegalArgumentException("Negativt antall!");
        }
        if(antall>=n){ // if antall er større eller lik null, fjern alle
            kø.nullstill();
        }
        for(int i=n-antall; i>0; i--){ //
            kø.leggInn(kø.taUt());
        }
        for(int i=0;i<antall;i++){
            kø.taUt();
        }
        return antall;
    }
    */
    public static <T> int fjernBakerst(Queue<T> kø, int antall){
        int n=kø.size(); // n= antall kø
        if(antall<0){ //Antall er ikke mindre enn null
            throw new IllegalArgumentException("Negativt antall!");
        }
        if(antall>=n){ // if antall er større eller lik null, fjern alle
            kø.clear();
        }
        for(int i=n-antall; i>0; i--){ //
            kø.add(kø.remove());
            System.out.println(kø.toString());
        }
        for(int i=0;i<antall;i++){
            kø.remove();
        }
        return antall;
    }

    public static void main(String[] args) {
        Integer[] a = {5,3,8,1,4,7};
        SBinTree<Integer> tre = new SBinTree<>(Comparator. naturalOrder ());
        for ( int verdi : a) tre.leggInn(verdi);
        System.out.println(tre.min());
        tre.leggInn(6);
        System.out.println(tre.høyde());
        tre.leggInn(9);
        tre.leggInn(10);
        System.out.println(tre.høyde());
    }
}
