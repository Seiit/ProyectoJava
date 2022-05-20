package views.components;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
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
    public final JTable getTable(String[][] contenido,String [] nombres,int x ,int y ,int largo,int alto){
        JTable table = new JTable(contenido,nombres);
        table.setOpaque(true);
        table.setBounds(x, y, largo,alto);
        table.setFont(new Font("roboto",Font.PLAIN,14));
        table.setForeground(Color.gray);
        table.setBackground(Color.white); 
        table.setIntercellSpacing(new Dimension(4, 4));
        table.setRowHeight(35);
        return table;
    }
}
