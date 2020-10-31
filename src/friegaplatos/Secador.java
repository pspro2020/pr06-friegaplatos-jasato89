package friegaplatos;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Secador implements Runnable {

    private final Bandeja platosLimpios;
    private final Bandeja platosSecos;

    public Secador(Bandeja platosLimpios, Bandeja platosSecos) {
        this.platosLimpios = platosLimpios;
        this.platosSecos = platosSecos;
    }

    @Override
    public void run()  {
        Plato plato;
        while (!Thread.currentThread().isInterrupted()) {
            plato = platosLimpios.quitar();
            secarPlato(plato);

        }

    }

    private void secarPlato(Plato plato) {
        Random random = new Random();
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(3)+1);
        } catch (InterruptedException e) {
            System.out.println("Error en el proceso de secado");
            e.printStackTrace();
        }
        platosSecos.añadir(plato);
    }
}
