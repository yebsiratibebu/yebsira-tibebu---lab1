import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        "1", "2", "3", "4", "5"
    };
      public EnigmaFrame() {
   
   
        this.setTitle("Enigma GUI");
        this.setSize(300, 400);
        this.setLocation(100, 100);
        this.setLayout(new BorderLayout());

        inner = new JComboBox<String>(rotornums); 
        middle   = new JComboBox<String>(rotornums);
        out = new JComboBox<String>(rotornums); 
        Initialpos = new JTextField(5);
        input = new JTextArea(5,60);
        input.setEditable(true); 
        output = new JTextArea(5,60);
        output.setEditable(false); 
        
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


        JPanel TextPanelin = new JPanel(new FlowLayout());
        TextPanelin.add(new JLabel("Input", JLabel.LEFT), BorderLayout.NORTH);
        TextPanelin.add(input);


        JPanel TextPanelout = new JPanel(new FlowLayout());
        TextPanelout.add(new JLabel("Output", JLabel.LEFT), BorderLayout.SOUTH);
        TextPanelout.add(output);

        JPanel TextPanel = new JPanel(new GridLayout(2,2));
        TextPanel.add(TextPanelin);
        TextPanel.add(TextPanelout);

        // Add everything to the frame
        this.add(dpanel, BorderLayout.NORTH);
        this.add(TextPanel, BorderLayout.WEST);

           //did the actionlistner based on a youtube video tutorial i watched
        Encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
           
               int rotor0 =  inner.getSelectedIndex();
               int rotor1 =  middle.getSelectedIndex();
               int rotor2 =  out.getSelectedIndex();
  
  
               String pos = Initialpos.getText();
               String inputtxt = input.getText();
            
             
               Enigma enigma = new Enigma(rotor0+1, rotor1+1, rotor2+1, pos);
               String encrypttxt = enigma.encrypt(inputtxt);
           

               output.setText(encrypttxt);
              
            }
          
           });
           //did the actionlistner based on a youtube video tutorial i watched
       Decrypt.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
           int rotor0 = inner.getSelectedIndex();
           int rotor1 = middle.getSelectedIndex();
           int rotor2 = out.getSelectedIndex();
           String pos = Initialpos.getText();
           String inputtxt = input.getText();
        
           Enigma enigma = new Enigma(rotor0 +1, rotor1+1, rotor2+1, pos);
           String decrypttxt = enigma.decrypt(inputtxt);
           output.setText(decrypttxt);
        }
      
       });
 
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  
    }
    public static void main(String[] args) {
        
        EnigmaFrame u = new EnigmaFrame();
        u.setVisible(true);
        
     }

}