

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class demo {

    private JFrame frame;
    private JTextField titleTextField;
    private JTextField fileTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    demo window = new demo();
                    window.frame.setSize(480, 300);
                    window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.frame.setTitle("TA Schedule Assistant");
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public demo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("TA Schedule Assistant");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(93, 6, 269, 38);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(93, 59, 86, 23);
        frame.getContentPane().add(lblTitle);

        titleTextField = new JTextField();
        titleTextField.setBounds(176, 56, 134, 28);
        frame.getContentPane().add(titleTextField);
        titleTextField.setColumns(10);

        JLabel lblFile = new JLabel("File");
        lblFile.setHorizontalAlignment(SwingConstants.CENTER);
        lblFile.setBounds(103, 94, 61, 16);
        frame.getContentPane().add(lblFile);

        JButton startButton = new JButton("START");
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            //TODO
            public void mouseClicked(MouseEvent e) {
            }
        });
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        startButton.setBounds(38, 216, 101, 34);
        frame.getContentPane().add(startButton);

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        cancelButton.setBounds(178, 216, 101, 34);
        frame.getContentPane().add(cancelButton);

        JButton helpButton = new JButton("HELP");
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        helpButton.setBounds(308, 216, 101, 34);
        frame.getContentPane().add(helpButton);

        JButton chooseFileButton = new JButton("Choose File");
        chooseFileButton.setBounds(308, 91, 101, 24);
        frame.getContentPane().add(chooseFileButton);

        fileTextField = new JTextField();
        fileTextField.setColumns(10);
        fileTextField.setBounds(176, 88, 134, 28);
        frame.getContentPane().add(fileTextField);

        String[] options = { "Want to be different", "1", "2", "3", "4", "5" };
        @SuppressWarnings("unchecked")
        JComboBox comboBox = new JComboBox(options);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) comboBox.getSelectedItem();
                switch (s) {
                    case "Not Fixed":
                        break;
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    default:
                        break;
                }

            }
        });


        comboBox.setBounds(263, 139, 116, 23);
        frame.getContentPane().add(comboBox);

        JLabel lblNumerOfTas = new JLabel("Numer of TAs in each section:");
        lblNumerOfTas.setBounds(49, 138, 202, 23);
        frame.getContentPane().add(lblNumerOfTas);
    }
}
