package Interfaz;

import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelTurno extends JPanel
{

   
    private JLabel lblTurno;
    private JTextField txtTurno;
    public int turno;

    public PanelTurno( )
    {
        turno = 0;
        setLayout( new GridLayout( 1, 2 ) );
        setBorder( new EmptyBorder( 8, 20, 8, 20 ) );

        lblTurno = new JLabel( "Turno: " );
        lblTurno.setHorizontalAlignment( getWidth( ) );
        add( lblTurno );
        
        txtTurno = new JTextField( );
        txtTurno.setEditable( false );
        add( txtTurno );
        
        this.actualizarCaja();
    }

    public void setTurno( int turno)
    {
        this.turno = turno;
    }

    public void actualizarCaja() {
        txtTurno.setText( this.turno + "");
    }
    
}
