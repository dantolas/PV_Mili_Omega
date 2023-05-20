package charming.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class RegisterContentPane extends JPanel{

    JFrame parentFrame;

    public RegisterContentPane(JFrame parent){

        this.parentFrame = parent;


        Color orange = new Color(0xEC5800);
        Color midBlue = new Color(0x191970);

        setLayout(new GridBagLayout());
        setBackground(midBlue);



        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setPreferredSize(new Dimension(320,250));
        centerPanel.setBackground(orange);
       
        JPanel usernameContainer = new JPanel(new FlowLayout());

        JTextField usernameInput = new JTextField();
        usernameInput.setFont(new Font("MV Boli",Font.BOLD,30));
        usernameInput.setText("Username");        
        JPanel emailContainer= new JPanel(new FlowLayout());
        JTextField emailInput = new JTextField();
        emailInput.setFont(new Font("MV Boli",Font.BOLD,30));
        emailInput.setText("E-mail");        
        
        JPanel passwordContainer= new JPanel(new FlowLayout());
        JTextField passwordInput = new JTextField();
        passwordInput.setFont(new Font("MV Boli",Font.BOLD,30));
        passwordInput.setText("Password");        




        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("MV Boli",Font.BOLD,30));
        registerButton.setFocusable(false); 
        
        //Border also serves as padding for button text
        registerButton.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new EmptyBorder(1,5, 1, 5))); 
        registerButton.setForeground(orange);
        registerButton.setBackground(midBlue);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        registerButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(e -> {
            //Remove all components, then revalidate to repaint frame
            parent.getContentPane().removeAll(); 
            parent.setContentPane(registerButton); 
            parent.revalidate();
            parent.repaint();        
        });
       
        centerPanel.add(usernameInput);
        centerPanel.add(emailInput);
        centerPanel.add(passwordInput);
        centerPanel.add(registerButton);
                
        add(centerPanel);
        
        
    };
}
