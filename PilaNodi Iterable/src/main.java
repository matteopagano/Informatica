public class main {
    public static void main(String[] args){
        PilaNodi p=new PilaNodi();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.goTesta());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
    }
}
