import javax.swing.*;
import java.awt.*;

public class EnigmaFrame extends JFrame{
    private JTextField Initialpos;
    private JComboBox<String> inner;
    private JComboBox<String> middle;
    private JComboBox<String> out;
    private JButton Decrypt;
    private JButton Encrypt;
    private JTextArea input;
    private JTextArea output;

    private final String[] rotornums = {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };
      public EnigmaFrame() {
        super();
        JFrame f = new JFrame();
        f.setTitle("Enigma GUI");
        f.setSize(300, 400);
        f.setLocation(100, 100);
        f.setLayout(new BorderLayout());

        inner = new JComboBox<String>(rotornums); 
        middle   = new JComboBox<String>(rotornums);
        out = new JComboBox<String>(rotornums); 
        Initialpos = new JTextField("EST");
        input = new JTextArea(10,20);
        output = new JTextArea(10,20);
    

        JPanel dpanel = new JPanel(new FlowLayout()); 
        dpanel.add (new JLabel("Inner"));
        dpanel.add(inner);
        dpanel.add (new JLabel("middle"));
        dpanel.add(middle);
        dpanel.add (new JLabel("out"));
        dpanel.add(out);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(Initialpos);
        Encrypt = new JButton("Encrypt");
        Decrypt = new JButton("Decrypt");

        dpanel.add(Encrypt);
        dpanel.add(Decrypt);


        JPanel TextPanel = new JPanel(new GridLayout());
        TextPanel.add(new JLabel("Input", JLabel.LEFT), BorderLayout.NORTH);
        TextPanel.add(new JLabel("Output", JLabel.LEFT), BorderLayout.SOUTH);
        JPanel textareapanel = new JPanel (new GridLayout(2,1));
        textareapanel.add(input);
        textareapanel.add(output);
        TextPanel.add(textareapanel, BorderLayout.CENTER);

        // Add everything to the frame
        f.add(dpanel, BorderLayout.NORTH);
        f.add(TextPanel, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);  
    }
}
