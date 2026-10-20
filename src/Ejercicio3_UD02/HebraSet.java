package Ejercicio3_UD02;

public class HebraSet implements Runnable {
    private VariableCompartida variable;
    public HebraSet(VariableCompartida variable) {this.variable=variable;}


    public void setVariable() {
        this.variable = variable;
    }


    @Override
    public void run() {
        for (int i = 0; i < 99 ; i++){
            variable.establecer(i);
            System.out.println("Set : "+ variable.obtener());
        }
    }
}
