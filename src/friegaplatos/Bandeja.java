package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bandeja {

    private List<Plato> bandejaPlatos = new ArrayList<>();

    public Bandeja(List<Plato> bandejaPlatos) {
        this.bandejaPlatos = bandejaPlatos;
    }
    public Bandeja() {}

    protected synchronized void añadir(Plato plato) {

            System.out.printf(
                    "%s - %s plato núm %d\n",
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    Thread.currentThread().getName(),
                    plato.getNum()
                    );
            bandejaPlatos.add(plato);
            notifyAll();

    }
    protected Plato quitar() throws InterruptedException {
        Plato plato = null;
        synchronized (this) {
                while (bandejaPlatos.isEmpty()) {
                    wait();
                }
                plato = bandejaPlatos.remove(0);
                notifyAll();
                return plato;
        }
    }
}
