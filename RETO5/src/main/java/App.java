import java.awt.EventQueue;
import view.VistaRequerimientosReto5;

/**
 * Persistencia Proyectos Construcción
 *
 */
public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try{
                    VistaRequerimientosReto5 formulario = new VistaRequerimientosReto5();
                    formulario.setVisible(true);

                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }
            
        });

    }

}
    