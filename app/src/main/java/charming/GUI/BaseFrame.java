package charming.GUI;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame{
    public BaseFrame(){


        //region <this configs>
        this.setTitle("ChatApp");
        this.setSize(720,480);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLayout(null); 
        ImageIcon image = new ImageIcon("/main/resources/images/keboard.icon.png");        
        this.setIconImage(image.getImage()); 
        this.getContentPane().setBackground(new Color(0X00004C)); 
        //endregion


    }    

    public static void main(String[] args) {
        BaseFrame frame = new BaseFrame();
        frame.setContentPane(new FirstContentPane());    
    }
}
