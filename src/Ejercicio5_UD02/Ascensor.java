package Ejercicio5_UD02;

import java.util.LinkedList;
import java.util.Queue;


    public class Ascensor implements Runnable {
        private int pisoActual=0;
        private Queue<Usuario>usuariosPendientes= new LinkedList<>();
        private boolean andando = true;

        public synchronized void agregarUsuario(Usuario u){
            usuariosPendientes.add(u);
            notifyAll();
        }
        @Override
        public void  run(){

            try {
                while (andando){
                    synchronized (this){
                        while (usuariosPendientes.isEmpty()){
                            if (pisoActual>-1){
                                pisoActual--;
                                System.out.println("ascensor en piso: "+ pisoActual);
                                Thread.sleep(500);
                            }else {
                                andando=false;
                                System.out.println("Ascensor llego a piso -1. Fin del programa.");
                                break;
                            }
                        }
                    }

                    if (!andando) break;

                    Usuario actual= null;
                    synchronized (this){
                        actual=usuariosPendientes.peek();
                    }
                    moverHasta(actual.getPisoOrigen());
                    System.out.println("Ususario" + actual.getnombre()+ "sube el ascensor.");

                    synchronized (actual){
                        actual.subido=true;
                        actual.notify();

                        moverHasta(actual.getPisoDestino());
                        System.out.println("Usuario"+ actual.getnombre()+ "baja en piso"+ actual.getPisoDestino());

                        synchronized (actual){
                            actual.bajado=true;
                            actual.notify();
                        }
                        synchronized (this){
                            usuariosPendientes.poll();
                        }

                    }
                }

            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void moverHasta(int pisoDestino) throws InterruptedException{
            while (pisoActual != pisoDestino){
                if (pisoActual<pisoDestino){
                    pisoActual++;
                }else {

                    pisoActual--;
                }

                System.out.println("Ascensor en piso:"+ pisoActual);
                Thread.sleep(500);
            }
        }



    }



