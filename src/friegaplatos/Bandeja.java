package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bandeja {

    private List<Plato> bandejaPlatos;


    public Bandeja(List<Plato> bandejaPlatos) {
        this.bandejaPlatos = bandejaPlatos;
    }
    public Bandeja() {};

    protected synchronized void añadir(Plato plato) {

            System.out.printf(
                    "%s - %s  plato núm %d\n",
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    Thread.currentThread().getName(),
                    plato.getNum()
                    );
            bandejaPlatos.add(plato);
            notifyAll();

    }
    protected Plato quitar() {

        synchronized (this) {
            try {
                while (bandejaPlatos.isEmpty()) {
                    wait();
                }
                notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Error fatal extrayendo platos");
                e.printStackTrace();
            }
            return bandejaPlatos.remove(0);
        }
    }
}
