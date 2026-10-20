package Ejercicio3_UD02;

public class HebraGet implements Runnable {
    private VariableCompartida variable;
    public HebraGet(VariableCompartida variable) {this.variable=variable;}

    public VariableCompartida getVariable() {
        return variable;
    }

    @Override
    public void run(){
        System.out.println("get : "+ variable.obtener());
    }
}
