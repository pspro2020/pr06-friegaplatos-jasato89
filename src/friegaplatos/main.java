package friegaplatos;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws InterruptedException {
    ArrayList<Plato> platos = crearPlatos(8);
    Bandeja bandejaSucios = new Bandeja(platos);
    Bandeja bandejaFregar = new Bandeja();
    Bandeja bandejaSecar = new Bandeja();
    Bandeja bandejaGuardar = new Bandeja();

    Thread fregar = new Thread(new Fregador(bandejaSucios, bandejaFregar));
    Thread secar = new Thread(new Secador(bandejaFregar, bandejaSecar));
    Thread organizar = new Thread(new Organizador(bandejaSecar, bandejaGuardar));

    fregar.start();
    secar.start();
    organizar.start();
    fregar.interrupt();
    secar.interrupt();
    organizar.interrupt();
    fregar.join();
    secar.join();
    organizar.join();



    }

    private static ArrayList<Plato> crearPlatos(int i) {
        ArrayList<Plato> platos = new ArrayList<>();
        for (int x = 0; x < i; x++) {
            platos.add(new Plato(x));
        }
        return platos;
    }
}
