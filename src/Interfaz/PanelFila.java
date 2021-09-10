package Interfaz;

import Logica.Fila;
import Logica.Persona;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class PanelFila extends JPanel implements ActionListener, ListSelectionListener {
    
    public final static String INICIAR = "Iniciar";
    public final static String ATENDER = "Atender";
    public final static String AÑADIR = "Añadir";
    public final static String SIMULAR = "Simular";

    private JLabel lblId;
    private JLabel imagen;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblTurno;
    private JLabel lblTransacciones;
    
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTurno;
    private JTextField txtTransacciones;

    private JScrollPane scroll;

    private JList personas;

    private JButton btnIniciar;
    private JButton btnAtender;
    private JButton btnAñadir;
    private JButton btnSimular;

    private InterfazBancaria interfaz;

    public PanelFila(InterfazBancaria pPrincipal) {
        interfaz = pPrincipal;
        setLayout(new BorderLayout());

        JPanel actual = new JPanel();
        actual.setLayout(new GridLayout(5, 2));
        actual.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        lblId = new JLabel("ID: ");
        actual.add(lblId);
        txtId = new JTextField();
        txtId.setEditable(false);
        actual.add(txtId);

        lblNombre = new JLabel("Nombre: ");
        actual.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        actual.add(txtNombre);

        lblApellido = new JLabel("Apellido: ");
        actual.add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setEditable(false);
        actual.add(txtApellido);

        lblTurno = new JLabel("Turno: ");
        actual.add(lblTurno);
        txtTurno = new JTextField();
        txtTurno.setEditable(false);
        actual.add(txtTurno);

        lblTransacciones = new JLabel("Numero de transacciones: ");
        actual.add(lblTransacciones);
        txtTransacciones = new JTextField();
        txtTransacciones.setEditable(false);
        actual.add(txtTransacciones);

        JPanel botones = new JPanel();
        botones.setBorder(new EmptyBorder(10, 10, 10, 10));
        botones.setLayout(new GridLayout(1, 3));

        btnAtender = new JButton(ATENDER);
        btnAtender.addActionListener(this);
        btnAtender.setActionCommand(ATENDER);
        botones.add(btnAtender);

        btnAñadir = new JButton(AÑADIR);
        btnAñadir.addActionListener(this);
        btnAñadir.setActionCommand(AÑADIR);
        botones.add(btnAñadir);
        
        btnSimular = new JButton(SIMULAR);
        btnSimular.addActionListener(this);
        btnSimular.setActionCommand(SIMULAR);
        botones.add(btnSimular);

        imagen = new JLabel( );
        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());
        centro.setBorder(new TitledBorder("Persona Actual"));
        centro.add(actual, BorderLayout.CENTER);
        centro.add(botones, BorderLayout.SOUTH);
        centro.add( imagen, BorderLayout.NORTH );
        add(centro, BorderLayout.CENTER);

        JPanel oeste = new JPanel();
        oeste.setLayout(new BorderLayout());
        oeste.setPreferredSize(new Dimension(300, 400));
        add(oeste, BorderLayout.WEST);

        personas = new JList();
        personas.addListSelectionListener(this);
        scroll = new JScrollPane();
        setBorder(new TitledBorder("Personas en la fila"));
        scroll.setViewportView(personas);
        scroll.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnIniciar = new JButton(INICIAR);
        btnIniciar.addActionListener(this);
        btnIniciar.setActionCommand(INICIAR);
        oeste.add(scroll, BorderLayout.CENTER);
        oeste.add(btnIniciar, BorderLayout.SOUTH);
    }


    public void refrescar(ArrayList<Persona> prueba) {
        personas.setListData(prueba.toArray());
    }

    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();
        if (comando.equals(INICIAR)) {
            interfaz.iniciar();
        } else if (comando.equals(ATENDER)) {
            interfaz.atender();
        } else if (comando.equals(AÑADIR)) {
            interfaz.añadir_1();
        }else if (comando.equals(SIMULAR)) {
            try {
                interfaz.atender_todo();
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelFila.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

    }

    public void valueChanged(ListSelectionEvent pEvento) {
        if (personas.getSelectedValue() != null) {
            Persona pLibro = (Persona) personas.getSelectedValue();
            txtNombre.setText(pLibro.getNombre() + "");
            txtId.setText(pLibro.getId() + "");
            txtTransacciones.setText(pLibro.getNumeroTransacciones() + "");
            txtApellido.setText(pLibro.getApellido());
            txtTurno.setText(pLibro.getNumeroTurno() + "");
            imagen.setIcon( new ImageIcon( new ImageIcon( pLibro.getRutaImagen()).getImage( ).getScaledInstance( 84, 85, Image.SCALE_DEFAULT ) ) );
        } else {
                txtNombre.setText("");
                txtTransacciones.setText("");
                txtId.setText("");
                txtApellido.setText("");
                txtTurno.setText("");
        }
    }

    public void cambiarSeleccionado(Persona persona) {
        personas.setSelectedValue(persona, true);
    }

}
