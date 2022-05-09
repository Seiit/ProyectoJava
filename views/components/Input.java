package views.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Input {
    public final JTextField getInput(String contenido,int x ,int y ,int largo,int alto){
        JTextField input = new JTextField();
        input.setBounds(x, y, largo,alto);
        input.setFont(new Font("roboto",Font.PLAIN,30));
        input.setBorder(new TitledBorder(contenido));
        input.setForeground(Color.gray);
        
        return input;
    }
    public final JTextField getPassInput(String contenido,int x ,int y ,int largo,int alto){
        JPasswordField input = new JPasswordField();
        input.setBounds(x, y, largo,alto);
        input.setFont(new Font("roboto",Font.PLAIN,30));
        input.setBorder(new TitledBorder(contenido));
        input.setForeground(Color.gray);
        
        return input;
    }
}
