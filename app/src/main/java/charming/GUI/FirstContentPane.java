package charming.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstContentPane extends JPanel{

    public FirstContentPane(){
        setLayout(new GridBagLayout());
        setBackground(new Color(0x191970));
        setPreferredSize(new Dimension(650,550));

        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(300, 300));
        centerPanel.setBackground(new Color(0xEC5800));
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
       
        centerPanel.add(loginButton);
        centerPanel.add(registerButton);
        add(centerPanel);
        
        
    };
}
