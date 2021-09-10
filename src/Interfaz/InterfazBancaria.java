package Interfaz;

import Logica.Fila;
import Logica.Persona;
import java.awt.BorderLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InterfazBancaria extends JFrame {

    private PanelTurno panelTurno;

    private PanelFila panelFila;

    public Fila fila;

    public InterfazBancaria() {
        setTitle("Interfaz Bancaria");
        setSize(750, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());

        panelTurno = new PanelTurno();
        centro.add(panelTurno, BorderLayout.NORTH);
        panelFila = new PanelFila(this);
        centro.add(panelFila, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void iniciar() {

        fila = new Fila();
        int numeroPersonas = (int) Math.floor(Math.random() * 9 + 1);
        for (int i = 0; i < numeroPersonas; i++) {
            Persona p = new Persona(fila);
            fila.insertar(p);
        }
        panelTurno.turno = 1;

        this.actualizar();

    }

    public void atender() {
        if (!fila.estaVacia()) {
            Persona cliente = fila.extraer();
//            int iterador = 0;
            if (panelTurno.turno == cliente.getNumeroTurno()) {
//                while (cliente.getNumeroTransacciones() > 0 && iterador < 3) {
                cliente.setNumeroTransacciones(cliente.getNumeroTransacciones() - 3);
//                    iterador++;
//                }
                if (cliente.getNumeroTransacciones() > 0) {
                    if (fila.contar() == 0) {
                        cliente.setNumeroTurno(cliente.getNumeroTurno() + 1);
                    } else {
                        cliente.setNumeroTurno(fila.verUltimo().getNumeroTurno() + 1);
                    }
                    fila.insertar(cliente);

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No coincide el numero de turno_ cliente y el numero de turno caja");
            }
            panelTurno.turno++;
            this.actualizar();

        } else {
            JOptionPane.showMessageDialog(rootPane, "La cola esta vacia");
        }
    }

    public void añadir_1() {
        Persona p = new Persona(fila);
        if (fila.estaVacia()) {
            panelTurno.turno = 1;
        }
        fila.insertar(p);
        this.actualizar();
    }

    public void atender_todo() throws InterruptedException {
        while (!fila.estaVacia()) {
            this.atender();
            Thread.sleep(1000);
            JOptionPane.showMessageDialog(null, "El cliente está siendo atendido");
        }
    }

    public void actualizar() {
        if (fila != null) {
            ArrayList<Persona> catalogo = fila.toArray();
            panelFila.refrescar(catalogo);
            if (!catalogo.isEmpty()) {
                panelFila.cambiarSeleccionado(catalogo.get(0));
            }
            panelTurno.actualizarCaja();
        }
    }

    public static void main(String[] pArgs) {
        try {
            InterfazBancaria ventana = new InterfazBancaria();
            ventana.setVisible(true);
            ventana.actualizar();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
