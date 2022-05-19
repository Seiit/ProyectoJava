package views.components;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewModel extends JFrame{

    private JPanel cont = new JPanel();
    private JPanel leftContent = new JPanel();
    private JPanel rightContent = new JPanel();

    public ViewModel(int globalX,int globalY){
        this(globalX,globalY,globalX,globalY,0,0,0,0);
    }

    public ViewModel(int globalX,int globalY,int contX,int contY){
        this(globalX,globalY,contX,contY,contX,contY,0,0);
    }

    public ViewModel(int globalX,int globalY,int contX,int contY,int lContX,int lContY,int rContX,int rContY){
        this.setSize(globalX, globalY);
        this.setLocationRelativeTo(null);

        this.cont.setSize(contX,contY);
        this.leftContent.setSize(lContX,lContY);
        this.rightContent.setSize(rContX,rContY);
        
    }

    public JPanel getCont() {
        return cont;
    }

    public void setCont(JPanel cont) {
        this.cont = cont;
    }

    public JPanel getLeftContent() {
        return leftContent;
    }
    public void setLeftContent(JPanel leftContent) {
        this.leftContent = leftContent;
    }

    public JPanel getRightContent() {
        return rightContent;
    }
    public void setRightContent(JPanel rightContent) {
        this.rightContent = rightContent;
    }

    public void apply(){
        cont.add(leftContent);
        cont.add(rightContent);
        this.add(cont);
    }

    public void update(){
        this.repaint();
    }

    public void close(){
        this.dispose();
    }

}
