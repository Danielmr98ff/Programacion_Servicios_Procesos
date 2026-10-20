package Ejercicio3_UD02;

public class VariableCompartida {
    private int i=0;

    public void establecer(int valor){
        this.i=valor;
    }
    public int obtener(){
        return i;
    }
    public void incrementar(){
        i++;
    }
}
