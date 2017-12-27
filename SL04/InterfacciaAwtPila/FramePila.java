import java.awt.*;
import java.awt.event.*;

public class FramePila<T> extends Frame implements ActionListener, ItemListener, MouseListener {

    PilaNodi pila;
    Label top, vuoto, corrente;
    Button push, pop, sinistra, destra;
    TextField in;
    Visitatore<T> it;

    public FramePila(String title, PilaNodi pila) {
        super(title);
        this.pila = pila;
        this.top = new Label();
        this.vuoto = new Label("isEmpty: ");
        this.corrente = new Label();
        this.push = new Button("Push");
        this.pop = new Button("Pop");
        this.sinistra = new Button("<<");
        this.destra = new Button(">");
        this.in = new TextField();
        this.push.addActionListener(this);
        this.pop.addActionListener(this);
        this.sinistra.addActionListener(this);
        this.destra.addActionListener(this);
        it = pila.getIterator();

        this.in.addMouseListener(this);
        setSize(600, 400);
        setLayout(new GridLayout(3, 3));
        add(new Label());
        add(in);
        add(this.push);
        add(this.top);
        add(this.vuoto);
        add(pop);
        add(sinistra);
        add(corrente);
        add(destra);

        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                              }
                          }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == push) {
            if (in.getText().compareTo("") != 0) {
                pila.push(in.getText());
                setTop();
                setIfEmpty();
                this.it = pila.getIterator();
                corrente.setText("   " + (String) it.goBottom());
                destra.setBackground(Color.green);
                sinistra.setBackground(Color.green);
            }
        }
        if (e.getSource() == pop) {
            if (pila.getLunghezza() > 0) {
                pila.pop();
                setTop();
                setIfEmpty();
                corrente.setText((String) it.goBottom());
                if (pila.getLunghezza() == 0) {
                    top.setText("   top");
                    destra.setBackground(Color.red);
                    sinistra.setBackground(Color.red);
                    corrente.setText("   Pila vuota");
                }
                it = pila.getIterator();
            }
        }

        if (e.getSource() == destra) {
            if (pila.getLunghezza() != 0) {
                if (it.hasNext() == false) {
                    destra.setBackground(Color.red);
                    sinistra.setBackground(Color.green);
                } else {
                    destra.setBackground(Color.green);
                    sinistra.setBackground(Color.green);
                }

                corrente.setText("   " + (String) it.next());
            } else {
                corrente.setText("   Pila vuota");
            }
        }

        if (e.getSource() == sinistra) {
            if (pila.getLunghezza() != 0) {
                destra.setBackground(Color.green);
                sinistra.setBackground(Color.red);
                corrente.setText("   " + (String) it.goTesta());
            } else {
                corrente.setText("   Pila vuota");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    public void setIfEmpty() {
        this.vuoto.setText("   isEmpty: " + pila.isEmpty());
        if (pila.isEmpty() == true) {
            vuoto.setBackground(Color.green);
        } else {
            vuoto.setBackground(Color.red);
        }
    }

    public void setTop() {
        this.top.setText("   top:" + pila.top());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == in) {
            if (in.getText().compareTo("") == 0) {
                push.setBackground(Color.red);
            }
        }
    }

        @Override
        public void mouseExited (MouseEvent e){
            if (e.getSource() == in) {
                if (in.getText().compareTo("") != 0) {
                    push.setBackground(Color.green);
                }
            }
        }
    }




