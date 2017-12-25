import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ascoltatoreBottoni implements MouseListener{
    Button bottoni[];
    ArrayList lista;
    int count;
    TextField text = new TextField("");
    Label lb1 = new Label();
    Label lb2 = new Label();

    public ascoltatoreBottoni(Button[] b, ArrayList a) {
        this.bottoni = b;
        this.lista = a;
        this.count = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public TextField getText() {
        return this.text;
    }

    public Label getLb1() {
        return lb1;
    }

    public Label getLb2() {
        return lb2;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bottoni[0]&&this.lista.size() !=1&&this.lista.size() !=0) {
            count = 1;
            lb2.setText("" + lista.get(count-1));
            if (count == 1) {
                bottoni[0].setBackground(Color.red);
                bottoni[1].setBackground(Color.green);
                bottoni[2].setBackground(Color.red);
                bottoni[3].setBackground(Color.green);
            }
        }
        if (e.getSource() == bottoni[1]&&this.lista.size() !=1&&this.lista.size() !=0) {
            count = lista.size();
            lb2.setText("" + lista.get(count - 1));
            if (count == lista.size()) {
                bottoni[1].setBackground(Color.red);
                bottoni[0].setBackground(Color.green);
                bottoni[3].setBackground(Color.red);
                bottoni[2].setBackground(Color.green);
            }
        }
        if (e.getSource() == bottoni[2]&&this.lista.size() !=1) {
            if (count > 1) {
                count--;
                lb2.setText("" + lista.get(count));
                if (count == 0) {
                    System.out.println(count);
                    lb2.setText("" + lista.get(count));
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.green);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.green);
                } else if (count == 1) {
                    lb2.setText("" + lista.get(count - 1));
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.green);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.green);
                } else {
                    lb2.setText("" + lista.get(count - 1));
                    bottoni[0].setBackground(Color.green);
                    bottoni[1].setBackground(Color.green);
                    bottoni[2].setBackground(Color.green);
                    bottoni[3].setBackground(Color.green);
                }
            }
        }
        if (e.getSource() == bottoni[3]&&this.lista.size() !=1) {
            if (count < this.lista.size()) {
                count++;
                lb2.setText("" + lista.get(count - 1));
                if (count == lista.size()) {
                    lb2.setText("" + lista.get(count - 1));
                    bottoni[0].setBackground(Color.green);
                    bottoni[1].setBackground(Color.red);
                    bottoni[2].setBackground(Color.green);
                    bottoni[3].setBackground(Color.red);
                } else {
                    lb2.setText("" + lista.get(count - 1));
                    bottoni[0].setBackground(Color.green);
                    bottoni[1].setBackground(Color.green);
                    bottoni[2].setBackground(Color.green);
                    bottoni[3].setBackground(Color.green);
                }
            }
        }
        if (e.getSource() == bottoni[4]) {
            if (!text.getText().equals("")) {
                lista.add(text.getText());
                bottoni[4].setBackground(Color.green);
                this.lb1.setText("lunghezza : " + lista.size());
                if (this.lista.size()==1){
                    this.lb2.setText("" + lista.get(count));
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.red);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.red);
                }
            } else if (this.lista.size()==0){
                bottoni[4].setBackground(Color.red);
            }
            if(this.lista.size()>1){
                bottoni[3].setBackground(Color.red);
                count=this.lista.size();
                this.lb2.setText("" + lista.get(count-1));
                bottoni[0].setBackground(Color.green);
                bottoni[2].setBackground(Color.green);
            }
        }
        if (e.getSource() == bottoni[5]) {
            if ((this.lista.contains(text.getText()))) {
                if (this.lb2.getText().equals(text.getText())&&this.lista.size()!=1) {
                    lista.remove(text.getText());
                    count = 1;
                    lb2.setText("" + lista.get(count-1));
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.green);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.green);
                }else{
                    lista.remove(text.getText());
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.red);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.red);
                    this.lb1.setText("lunghezza : " + lista.size());
                    this.lb2.setText("");
                    count=0;
                }
                if (this.lista.size()==0){
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.red);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.red);
                    this.lb1.setText("lunghezza : " + lista.size());
                    this.lb2.setText("");
                }
                if (this.lista.size()==1){
                    bottoni[0].setBackground(Color.red);
                    bottoni[1].setBackground(Color.red);
                    bottoni[2].setBackground(Color.red);
                    bottoni[3].setBackground(Color.red);
                    this.lb1.setText("lunghezza : " + lista.size());
                    lb2.setText("" + lista.get(count-1));
                }
                this.lb1.setText("lunghezza : " + lista.size());
                if ((this.lista.contains(text.getText()))) {
                    bottoni[5].setBackground(Color.green);
                } else {
                    bottoni[5].setBackground(Color.red);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.text) {
            if (!text.getText().equals("")) {
                bottoni[4].setBackground(Color.green);
            } else {
                bottoni[4].setBackground(Color.red);
            }
            if ((this.lista.contains(text.getText()))) {
                bottoni[5].setBackground(Color.green);
            } else {
                bottoni[5].setBackground(Color.red);
            }
        }if (e.getSource() == this.bottoni[5]) {
            if (!text.getText().equals("")) {
                bottoni[4].setBackground(Color.green);
            } else {
                bottoni[4].setBackground(Color.red);
            }
            if ((this.lista.contains(text.getText()))) {
                bottoni[5].setBackground(Color.green);
            } else {
                bottoni[5].setBackground(Color.red);
            }
        }
        if (e.getSource() == this.bottoni[4]) {
            if (!text.getText().equals("")) {
                bottoni[4].setBackground(Color.green);
            } else {
                bottoni[4].setBackground(Color.red);
            }
            if ((this.lista.contains(text.getText()))) {
                bottoni[5].setBackground(Color.green);
            } else {
                bottoni[5].setBackground(Color.red);
            }
        }
    }
}
