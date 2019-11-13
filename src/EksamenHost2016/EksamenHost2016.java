package EksamenHost2016;

import java.util.Arrays;

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

    public static void main(String[] args) {
        char[] c = "AbaAcBbAAaCCbcAB".toCharArray();
        int antall = omorganiser4(c);
        System.out.println(antall + "  " + Arrays.toString(c));


    }

}
