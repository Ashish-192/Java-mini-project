import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConvert extends JFrame {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TempConvert frame = new TempConvert();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TempConvert() {

        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, -33, 385, 272);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtTempIn = new JTextPane();
        txtTempIn.setBounds(12, 46, 124, 26);
        contentPane.add(txtTempIn);

        JRadioButton celRadio = new JRadioButton("Celcius");
        buttonGroup.add(celRadio);
        celRadio.setBounds(212, 34, 67, 24);
        contentPane.add(celRadio);

        JRadioButton fahrenRadio = new JRadioButton("Fahrenheit");
        buttonGroup.add(fahrenRadio);
        fahrenRadio.setBounds(212, 62, 85, 24);
        contentPane.add(fahrenRadio);

        JLabel lblTem = new JLabel("Degrees");
        lblTem.setBounds(154, 49, 78, 16);
        contentPane.add(lblTem);

        JTextPane tempOutput = new JTextPane();
        tempOutput.setBackground(UIManager.getColor("Button.background"));
        tempOutput.setEditable(false);
        tempOutput.setBounds(12, 138, 267, 22);
        contentPane.add(tempOutput);

        JButton btnNewButton = new JButton("Convert");
        btnNewButton.setBounds(12, 84, 98, 26);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if(celRadio.isSelected()){
                    try{
                        double temp=Double.parseDouble(txtTempIn.getText());
                        temp = temp * 1.8 + 32;
                        tempOutput.setText(Double.toString(temp));
                    }catch(Exception e){
                        tempOutput.setText("Please enter a valid temperature.");
                    }
                }else{
                    try{
                        double temp=Double.parseDouble(txtTempIn.getText());
                        temp = (temp - 32) * (5.0/9.0);
                        tempOutput.setText(Double.toString(temp));
                    }catch(Exception e){
                        tempOutput.setText("Please enter a valid temperature.");
                    }
                }
            }
        });
    }
}

