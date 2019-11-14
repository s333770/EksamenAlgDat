package EksamenHost2016;

import java.util.*;

public class EksamenHost2016 {
    public static int omorganiser(char [] c){
        Arrays.sort(c);//Kvikksortering n*log(n) i gjennomsnitt
        System.out.println(Arrays.toString(c));
        for(int i=0, j=c.length-1; i<j;  ){  //Denne er tom
            bytt(c,i++,j--);
        }
        int antall=0;
        while(antall<c.length && c[antall]>'Z'){
            antall++;
        }


        return antall;
    }
    public static int omorganisering2(char c[]){
        char [] d=new char[c.length];
        int v=0; int h=d.length-1;
        for(char t:c){
            if(t>'Z'){
                d[v++]=t;
            }
            else{
                d[h--]=t;
            }


        }
        System.arraycopy(d,0,c,0,d.length);
        return v;
    }
    public static int omorganisering3(char c[]){
        int antall=0;
        for(int i=0; i<c.length;i++){
            if(c[i]>'Z'){
                bytt(c,i, antall++);
            }
        }
        return antall;
    }
    public static int omorganiser4(char[]c){
        int v=0; int h=c.length-1;
        while(true){
            while(v<=h&& c[v]>'Z'){
                v++;
            }
            while(v<=h && c[h]<='Z'){
                h--;
            }
            if(v<h){
                bytt(c,v++,h--);
            }
            else{
                return v;
            }

        }
    }
    public static void bytt(char[]c, int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;


    }

    public static<T> int compare(List<T> a, List<T> b, Comparator<? super T> comp){
        int m=Math.min(a.size(),b.size());
        for(int i=0; i<m;i++){
            int cmp=comp.compare(a.get(i),b.get(i));
            if(cmp!=0){
                return cmp;
            }
        }
        return a.size()-b.size();
    }
    /*
    Raskere metode som bruker Iterator
     public static <T> int compare(Liste<T> a, Liste<T> b, Comparator<? super T> comp)
  {
    Iterator<T> i = a.iterator(), j = b.iterator();
    int m = Math.min(a.antall(), b.antall());

    for (int k = 0; k < m; k++)
    {
      int cmp = comp.compare(i.next(), j.next());
      if (cmp != 0) return cmp;       // i.next() og j.next() er forskjellige
    }

    // a er nå første del av b eller b første del av a
    return a.antall() - b.antall();   // den korteste er minst
  }
    * */
    public static <T> void omvendtkopi(Stack<T> a, Stack<T> b){
        Stack<T> hjelp=new Stack<>();
        int lengde=a.size();
        for(int i=0; i<lengde;i++){
            T verdi=a.pop();
            b.add(verdi);
            hjelp.add(verdi);
        }
        while(!hjelp.isEmpty()){
            a.add(hjelp.pop());
        }

    }


    public static void main(String[] args) {
        /*
        Character[] tegn1 = {'A','B','C'}, tegn2 = {'A','B','D'};
        Integer[] tall1 = {1,2,3,4,5}, tall2 = {1,2,3,4};
        List<Character> a = new LinkedList(Arrays.asList(tegn1));  // A,B,C
        List<Character> b = new LinkedList(Arrays.asList(tegn2));// A,B,D
        List<Integer> c = new LinkedList<>(Arrays.asList(tall1));    // 1,2,3,4,5
        */
        Stack<String> a = new Stack<>(), b = new Stack<>();
        a.add("C"); a.add("B"); a.add("A");
        System.out.println(a + " " + b);  // utskrift: [A, B, C] []
        omvendtkopi(a,b);
        System.out.println(a + " " + b);  // utskrift: [A, B, C] [C, B, A]

    }

}
