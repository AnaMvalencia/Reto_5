package view;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

public class  VistaRequerimientosReto5 extends JFrame {

    public static final Controlador controlador = new Controlador();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientosReto5(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350,50, 800,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("CONSULTAS DEL RETO 5");
        lbltitulo.setBounds(300, 6, 300, 16);
        contentPane.add(lbltitulo);

        JLabel lblautor = new JLabel("AUTOR: ANAMARIA VALENCIA CARABALI");
        lblautor.setBounds(28, 34, 350, 16);
        contentPane.add(lblautor);

        JLabel lblgrupo = new JLabel("GRUPO: 46");
        lblgrupo.setBounds(28, 50, 350, 16);
        contentPane.add(lblgrupo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 70, 737, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("CONSULTA_1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista_requerimiento_1();

            }

        });
        btnConsulta1.setBounds(28, 530, 117, 29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("CONSULTA_2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista_requerimiento_2();

            }

        });
        btnConsulta2.setBounds(157, 530, 117, 29);
        contentPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("CONSULTA_3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista_requerimiento_3();

            }

        });
        btnConsulta3.setBounds(286, 530, 117, 29);
        contentPane.add(btnConsulta3);

        JButton btnConsulta4 = new JButton("CONSULTA_4");
        btnConsulta4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista_requerimiento_4();

            }

        });
        btnConsulta4.setBounds(415, 530, 117, 29);
        contentPane.add(btnConsulta4);


        JButton btnConsulta5 = new JButton("CONSULTA_5");
        btnConsulta5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista_requerimiento_5();

            }

        });
        btnConsulta5.setBounds(544, 530, 117, 29);
        contentPane.add(btnConsulta5);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(" ");

            }

        });
        btnLimpiar.setBounds(640, 34, 117, 35);
        contentPane.add(btnLimpiar);


    }

    public static void vista_requerimiento_1() {

        try {

            ArrayList<Proyecto> rankingProyectos = controlador.Solucionar_requerimiento_1();
            String info = "*** PROYECTO CONSTRUTORA PEGASO ***\n\nFecha_Inicio:\tNº_Habitaciones:\tNº_Banos:\n\n ";
            for ( Proyecto proyectos : rankingProyectos) {
                info += proyectos.getFecha_inicio();
                info += "\t";
                info += proyectos.getNum_habitaciones();
                info += "\t\t";
                info += proyectos.getNum_banios();
                info += "\n";

            
            }
            textArea.setText(info);   

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void vista_requerimiento_2() {
        try {

            ArrayList<Proyecto> rankingProyectos = controlador.Solucionar_requerimiento_2();
            String info = "*** PROYECTO CONSTRUTORA PEGASO ***\n\nFecha_Inicio:\t\tNº_Habitaciones:\tNº_Banos:\t\tNombre_Lider:\t\tApellido_Lider:\t\tEstrato_Proyecto:\n\n ";
            for ( Proyecto proyectos : rankingProyectos) {
                info += proyectos.getFecha_inicio();
                info += "\t\t";
                info += proyectos.getNum_habitaciones();
                info += "\t\t";
                info += proyectos.getNum_banios();
                info += "\t\t";
                info += proyectos.getLider().getNombre();
                info += "\t\t";
                info += proyectos.getLider().getApellido();
                info += "\t\t";
                info += proyectos.getEstrato_proyecto();
                info += "\n";
            

        }
        textArea.setText(info); 

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void vista_requerimiento_3() {
        try {

            ArrayList<Proyecto> rankingProyectos = controlador.Solucionar_requerimiento_3();
            String info = "*** TOTAL DE HABITACIONES ***\n\nTotal_Habitaciones:\tConstructora:\n\n ";
            for ( Proyecto proyectos : rankingProyectos) {
                info += proyectos.getNum_habitaciones();
                info += "\t\t";
                info += proyectos.getNombre_constructora();
                info += "\n";
                
        }
        textArea.setText(info); 


        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void vista_requerimiento_4() {
        try {
                ArrayList<Lider> rankingLideres = controlador.Solucionar_requerimiento_4();
                String info = "*** LIDERES DE LA CONSTRUCTORA ***\n\nNombre_Lider:\t\tApellido_Lider: \n\n ";
                for ( Lider lider : rankingLideres) {
                info += lider.getNombre();
                info += "\t\t";
                info += lider.getApellido();
                info += "\n";
                
        }
        textArea.setText(info); 

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void vista_requerimiento_5() {
        try {
            ArrayList<Proyecto> rankingProyectos = controlador.Solucionar_requerimiento_5();
            String info = "*** TOTAL DE HABITACIONES DE MANERA ASCENDENTE  ***\n\nTotal_Habitaciones:\tConstructora:\n\n ";
            for ( Proyecto proyectos : rankingProyectos) {
                info += proyectos.getNum_habitaciones();
                info += "\t\t";
                info += proyectos.getNombre_constructora();
                info += "\n";

        }
        textArea.setText(info); 

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

}

