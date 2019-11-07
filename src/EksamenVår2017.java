import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Queue<Character> kø = new LinkedList<>();
        char[] c = "ABCDEFGHI".toCharArray();
        for (char d : c) kø.add(d);
        System.out.println(kø.toString());                  // [A, B, C, D, E, F, G, H, I]
        int antall = fjernBakerst(kø,5);
        System.out.println(antall + " " + kø);   // 5 [A, B, C, D]
        //antall = fjernBakerst(kø,5);
        //System.out.println(antall + " " + kø);   // 4 []
        Stack<Character> stakk = new Stack<>();
        char[] bokstaver = "EDCBA".toCharArray();

        for (char b : bokstaver) stakk.add(b);
        System.out.println(stakk);  // Utskrift: [A, B, C, D, E]
        Stack<Character> hjelp = new Stack<>();

        int n = stakk.size();
        for (int i = 0; i < n - 1; i++) hjelp.add(stakk.pop());
        Character temp = stakk.pop();
        while (!hjelp.empty()) stakk.add(hjelp.pop());
        stakk.add(temp);
        System.out.println(stakk);

    }
}
