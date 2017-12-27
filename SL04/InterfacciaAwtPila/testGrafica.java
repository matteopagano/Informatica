public class testGrafica {
    public static void main(String[] args) {
        PilaNodi<String> p=new PilaNodi<>();
        FramePila f=new FramePila("Pila",p);
        f.setVisible(true);
    }
}
