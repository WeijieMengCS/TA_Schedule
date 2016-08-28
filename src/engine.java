import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;

/**
 * Created by meng on 8/26/16.
 */
public class engine extends JFrame {
    private File inputFile;
    public engine(){



    }

    public static void createAndShow(){

        engine frame = new engine("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    private void addComponentsToPane(Container contentPane) {




    }

    public void setUpWindow(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JTextField labTwoNameField = new JTextField("LWSN B148");
        JTextField labThreeNameField = new JTextField("LWSN B158");


        //select cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });



        JButton startButton = new JButton("Start");
        startButton.setEnabled(false);

//        startButton.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                if (!(labOneNameField.getText().equals(""))
//                        && !(labTwoNameField.getText().equals(""))
//                        && !(labThreeNameField.getText().equals(""))) {
//                    frame.dispose();
////                    labOneName = labOneNameField.getText();
////                    labTwoName = labTwoNameField.getText();
////                    labThreeName = labThreeNameField.getText();
////                    showTableView();
//                }
//            }
//        });

        //select excel file
        JTextField selectFile = new JTextField("Click here to select an excel file");
        selectFile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showOpenDialog(panel);
                if (jfc.getSelectedFile() != null) {
                    selectFile.setText(jfc.getSelectedFile().getName());
                    inputFile = jfc.getSelectedFile();
                    startButton.setEnabled(true);
                }
            }
        });


        //set up panel
        panel.add(new JLabel("Enter title"));
        JTextField enterTitle = new JTextField("Please enter a title for this assignment");
        panel.add(enterTitle);
        panel.add(new JLabel("Select file"));
        panel.add(selectFile);
        frame.add(panel);
        frame.setTitle("Lab Room Selection");
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    public static void main(String[] args ){

        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setUpWindow();
            }
        });

    }

}
