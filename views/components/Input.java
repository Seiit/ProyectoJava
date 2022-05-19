package views.components;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    public final JTextField getNumberInput(String contenido,int x ,int y ,int largo,int alto){
        JTextField input = new JTextField();
        input.setBounds(x, y, largo,alto);
        input.setFont(new Font("roboto",Font.PLAIN,30));
        input.setBorder(new TitledBorder(contenido));
        input.setForeground(Color.gray);

        input.setText("");
        
        input.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                String text = input.getText();
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != '.') {
                    e.consume();  // if it's not a number, ignore the event
                }
                if(c == '.' && text.contains(".")){
                    e.consume();
                } 

                if(text.length() > 10){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
         });

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
