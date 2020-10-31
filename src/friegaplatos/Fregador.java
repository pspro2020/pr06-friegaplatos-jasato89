package friegaplatos;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fregador implements Runnable {
    private Bandeja bandejaSucia;
    private Bandeja bandejaLimpia;
    private int num = 0;

    Fregador(Bandeja bandejaSucia, Bandeja bandejaLimpia) {
        this.bandejaSucia = bandejaSucia;
        this.bandejaLimpia = bandejaLimpia;
    }

    @Override
    public void run() {
        Plato plato = null;
        Random random = new Random();
        while (!Thread.currentThread().isInterrupted()) {

            plato = cogerSucio();
        }
            limpiarPlato(plato);
        }

    private Plato cogerSucio() {
        return bandejaSucia.quitar();
    }

    private void limpiarPlato(Plato plato) {
            Random random = new Random();
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5) + 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bandejaLimpia.añadir(plato);

        }

    }

