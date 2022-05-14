package views.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Title{

    public final JLabel getH1(String contenido,int x ,int y ,int largo,int alto){
        JLabel label = new JLabel(contenido);
        label.setOpaque(true);
        label.setBounds(x, y, largo,alto);
        label.setBackground(new Color(3,155,229));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("roboto",Font.PLAIN,40));
        label.setForeground(Color.white);
        return label;
    }
    
    public final JLabel getH2(String contenido,int x ,int y ,int largo,int alto){
        JLabel label = new JLabel(contenido);
        label.setOpaque(true);
        label.setBounds(x, y, largo,alto);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("roboto",Font.PLAIN,30));
        label.setForeground(Color.gray);
        label.setBackground(Color.white); 
        label.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        return label;
    }
    public final JLabel getTH2(String contenido,int x ,int y ,int largo,int alto){
        JLabel label = new JLabel(contenido);
        label.setOpaque(true);
        label.setBounds(x, y, largo,alto);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("roboto",Font.PLAIN,30));
        label.setForeground(Color.gray);
        label.setBackground(Color.white); 
        label.setBorder(new TitledBorder(contenido));
        return label;
    }
}
