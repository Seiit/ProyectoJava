package views.components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

public class Card {
   
    public JPanel getBackground(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(225,226,225)); 
        return panel;
    }

    public JPanel getCard(int ejeX,int ejeY,int ancho,int alto){
        JPanel card = new JPanel();
        card.setSize(ancho,alto);
        card.setLocation(ejeX,ejeY );
        card.setLayout(null);
        card.setBackground(Color.white); 
        return card;
    }

    public JScrollPane getCardScroll(int ejeX,int ejeY,int ancho,int alto){
        JScrollPane card = new JScrollPane();
        card.setSize(ancho,alto);
        card.setLocation(ejeX,ejeY );
        card.setLayout(null);
        card.setBackground(Color.white); 
        return card;
    }

}
