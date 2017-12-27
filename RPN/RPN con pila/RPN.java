public class RPN {
    private static final String[] operators={"+","-","*","/"};




    private static boolean isOperator(String Op){
        for (int i=0;i<operators.length;i++){
            if(operators[i].equals(Op)){
                return true;
            }
        }
        return false;
    }


    private static double operations(double term1,double term2,String op){
        double operation=0;
        switch(op){
            case "+": operation=term1+term2;break;
            case "-": operation=term1-term2;break;
            case "*": operation=term1*term2;break;
            case "/": operation=term1/term2;break;
            default:return 0.0;
        }
        return operation;
    }

    public static double expression(String[] op){
        PilaNodi<Double> p=new PilaNodi<>();
        for (int i=0;i<op.length;i++){
            if(isOperator(op[i])){
                p.push(operations(p.pop(),p.pop(),op[i]));
            }else{
                p.push((Double.parseDouble(op[i])));
            }
        }
        return p.pop();
    }
}
