public interface Kø<T>
{
    public void leggInn(T verdi);      // legger verdi bakerst
    public T kikk();                   // ser på den første
    public T taUt();                   // tar ut den første
    public int antall();               // antall i køen
    public boolean tom();              // er køen tom?
    public void nullstill();           // tømmer køen
    public String toString();          // fra den første til den bakerste
}