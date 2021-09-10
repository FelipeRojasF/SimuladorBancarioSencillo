package Logica;

/**
 *
 * @author Felipe
 */
public class Persona{
    
    private int numeroTransacciones;
    private int numeroTurno;
    private int id;
    private String nombre;
    private String apellido;
    private String rutaImagen;
    private String cliente;
    
    public int numeroCliente = 1;
    
    private String[] Nombres = {"Juan", "Pedro", "Carlos","Angel","Pablo","Luis","Fernando","Adrian","Diego","Salvador",
                                "Ivan","Henrique","Alvaro","Ruben","Ramon","Oscar","Vicente","Andres","Joaquin","Santiago",
                                "Eduardo","Victor","Mario","Francisco","Marcos","Ignacio","Alfonso","Raul","Hugo","Emilio"};//30

    private String[] Apellidos = {"Rodriguez","Lopez","Gomez","Gonzales","Garcia","Martinez","Ramirez","Sanchez","Hernandez","Dias",
                                  "Perez","Torres","Rojas","Vargas","Moreno","Gutierrez","Jimenez","Muños","Castro","Ortiz",
                                  "Alvares","Ruiz","Suarez","Romero","Herrera","Valencia","Quintero","Restrepo","Giraldo","Morales"};

    public Persona(Fila fila) {
        
        if(fila.estaVacia()){
            id = 101902433;
            numeroTurno = 1;
        }else{
            Persona p = fila.verUltimo();
            id = p.id+738;
            numeroTurno = p.numeroTurno+1;
        }
        int numeroImagen = (int) Math.floor(Math.random()*6+1);
        cliente = "Cliente_"+numeroCliente;
        numeroCliente ++;
        numeroTransacciones = (int) Math.floor(Math.random()*6+1);
        nombre = Nombres[(int) Math.floor(Math.random()*Nombres.length)];
        apellido = Apellidos[(int) Math.floor(Math.random()*Apellidos.length)];
        rutaImagen = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\SimuladorBancario\\imagenes\\avatar_"+numeroImagen+".jpg";
        
    }

    public int getNumeroTransacciones() {
        return numeroTransacciones;
    }

    public void setNumeroTransacciones(int numeroTransacciones) {
        this.numeroTransacciones = numeroTransacciones;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }   
}
