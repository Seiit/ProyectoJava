package views.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

public class Submit {
    public JButton getActionButton(String contenido,int x ,int y ,int largo,int alto){
        JButton button = new JButton(contenido);
        button.setBackground(new Color(3,155,229));
        button.setBounds(x, y, largo,alto);
        button.setFont(new Font("roboto",Font.PLAIN,30));
        button.setForeground(Color.white);
        return button;
    }
}