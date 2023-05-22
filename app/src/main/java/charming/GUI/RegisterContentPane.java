package charming.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import charming.actualCode.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
        //centerPanel.setPreferredSize(new Dimension(320,250));
        centerPanel.setBackground(orange);

        
        JPanel usernameContainer = new JPanel(new FlowLayout());
        
        JLabel userIcon= new JLabel(new ImageIcon("/app/src/resources/imags/usericon.png"));
        userIcon.setText("Username");

        JTextField usernameInput = new JTextField();
        usernameInput.setFont(new Font("MV Boli",Font.PLAIN,15));
        usernameInput.setPreferredSize(new Dimension(200,30));
        
        usernameContainer.add(userIcon);
        usernameContainer.add(usernameInput);

        JPanel emailContainer= new JPanel();

        JLabel emailicon= new JLabel(new ImageIcon("/app/src/resources/imags/usericon.png"));
        emailicon.setText("Email");

        JTextField emailInput = new JTextField();
        emailInput.setFont(new Font("MV Boli",Font.PLAIN,15));
        emailInput.setPreferredSize(new Dimension(200,30));
        
        emailContainer.add(emailicon);
        emailContainer.add(emailInput);

        JPanel passwordContainer= new JPanel(new FlowLayout());
        
        JLabel passIcon = new JLabel(new ImageIcon("../resources/imags/usericon.png"));
        passIcon.setText("Password");

        JTextField passwordInput = new JPasswordField();
        passwordInput.setFont(new Font("MV Boli",Font.PLAIN,15));
        passwordInput.setPreferredSize(new Dimension(200,30));

        passwordContainer.add(passIcon);
        passwordContainer.add(passwordInput);

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
            System.out.println(Validator.validateEmail(emailInput.getText()));
        
        });
       
        centerPanel.add(usernameContainer);
        centerPanel.add(emailContainer);
        centerPanel.add(passwordContainer);
        centerPanel.add(registerButton);
                
        add(centerPanel);
        
        
    };
}
