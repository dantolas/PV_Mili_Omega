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
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class FirstContentPane extends JPanel{

    JFrame parentFrame;

    public FirstContentPane(JFrame parent){

        this.parentFrame = parent;


        Color orange = new Color(0xEC5800);
        Color midBlue = new Color(0x191970);

        setLayout(new GridBagLayout());
        setBackground(midBlue);
        setPreferredSize(new Dimension(650,550));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setPreferredSize(new Dimension(220, 150));
        centerPanel.setBackground(orange);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("MV Boli",Font.BOLD,30));
        loginButton.setFocusable(false); 
        
        //Border also serves as padding for button text
        loginButton.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new EmptyBorder(1,5, 1, 5))); 
        loginButton.setForeground(orange);
        loginButton.setBackground(midBlue);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        loginButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(e -> {
            //Remove all components, then revalidate to repaint frame
            parent.getContentPane().removeAll(); 
            parent.setContentPane(new RegisterContentPane(parent)); 
            parent.revalidate();
            parent.repaint();        
        });
        
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("MV Boli",Font.BOLD,30));
        registerButton.setFocusable(false);
        
        //Border also serves as padding for button text
        registerButton.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new EmptyBorder(1,5, 1, 5))); 
        registerButton.setForeground(orange);
        registerButton.setBackground(midBlue);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        registerButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        //This is added to function as empty space
        centerPanel.add(Box.createRigidArea(new Dimension(10,10)));
        centerPanel.add(loginButton);
        //This is added to function as empty space
        centerPanel.add(Box.createRigidArea(new Dimension(10,5)));
        centerPanel.add(registerButton);
        
        add(centerPanel);
        
        
    };
}
