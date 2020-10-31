package friegaplatos;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Organizador implements Runnable{
    private final Bandeja bandejaSecos;
    private final Bandeja bandejaGuardar;

    public Organizador(Bandeja bandejaSecos, Bandeja bandejaGuardar) {
        this.bandejaSecos = bandejaSecos;
        this.bandejaGuardar = bandejaGuardar;
    }

    @Override
    public void run() {
        Plato plato;
        while (!Thread.currentThread().isInterrupted()) {
            plato = bandejaSecos.quitar();
            guardarPlato(plato);
        }

    }

    private void guardarPlato(Plato plato) {
        Random random = new Random();
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(2)+1);
        } catch (InterruptedException e) {
            System.out.println("Error guardando plato");
            e.printStackTrace();
        }
        bandejaGuardar.añadir(plato);
    }
}
