import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by meng on 8/26/16.
 */
public class engine extends JFrame {
    private File inputFile;
    //GridLayout mainLayout = new GridLayout(0, 2);


    public engine() {
        super("TA Schedule Assistant");
        setResizable(false);

    }

    public static void createAndShow() {

        engine frame = new engine();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        /*frame.pack();
        frame.setVisible(true);*/

        frame.setTitle("");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


    private void addComponentsToPane(Container contentPane) {

        //create pane for title
        JPanel titlePane = new JPanel();
        titlePane.setLayout(new GridLayout(0, 1));
        JLabel titleLabel = new JLabel("TA Schedule Assistant");
        titleLabel.setSize(50,50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        //titleLabel.se
        // titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titlePane.add(titleLabel);

    /*    //set up file choose
        DemoJFileChooser panel = new DemoJFileChooser();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
*/


        //create pane for main part
        JPanel mainPane = new JPanel(new GridLayout(0,2,20,20));
       // mainPane.setLayout(mainLayout);


        //set up components preferred size
        JButton b = new JButton("test button");
        Dimension buttonSize = b.getPreferredSize();
        mainPane.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 2.5) + 20,
                (int) (buttonSize.getHeight() * 3.5) + 20 * 2));


        //create components for the mainPane

        JLabel enterTitleLabel = new JLabel("Title");
        enterTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel selectFileLabel = new JLabel("File");
        selectFileLabel.setHorizontalAlignment(JLabel.CENTER);

     //   JTextField titleTextField = new JTextField(20);
        JTextField titleTextField = new JTextField(20);

        //add components to the mainPane
        mainPane.add(enterTitleLabel);
        mainPane.add(titleTextField);

        JButton selectFileButton = new JButton("Select File");

        selectFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        String filename = f.getName().toLowerCase();

                        return filename.endsWith(".csv")  ;
                    }

                    @Override
                    public String getDescription() {
                        return "csv (*.csv)";
                    }
                });
                chooser.showOpenDialog(contentPane);
                if (chooser.getSelectedFile()!=null){

                    inputFile = chooser.getSelectedFile();


                }


            }
        });

        mainPane.add(selectFileLabel);
        mainPane.add(selectFileButton);


        JButton startButton = new JButton("START");

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //todo call function
                if (inputFile==null){

                    JOptionPane.showMessageDialog(null, "Please select a file !", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }else {

                    String titleName = titleTextField.getText();
                    //TODO inputFile: csv file
                    //     titleName: title for this assignment
                    System.out.println("title: "+ titleName+ "    fileName: "+inputFile.getName());

                    JOptionPane.showMessageDialog(null, "Title :" + titleName +"\nFile :"+inputFile.getName(), "",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
        mainPane.add(startButton);
        mainPane.add(cancelButton);
        //Add two panes and separator to the Container
        contentPane.add(titlePane, BorderLayout.NORTH);
        contentPane.add(new JSeparator(), BorderLayout.CENTER);
        contentPane.add(mainPane, BorderLayout.CENTER);


    }


    public static void main(String[] args) {

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
        javax.swing.SwingUtilities.invokeLater(() -> createAndShow());

    }

}
