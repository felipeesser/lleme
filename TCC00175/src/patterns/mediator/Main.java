package patterns.mediator;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        MediadorCalculo expr = new MediadorCalculo();
        expr.editExpr.setExpressaoStr("2 _a * _b + _b *");
        expr.editVar.listVars();
        expr.editVar.setVar("_a", 5.0);
        expr.editVar.setVar("_b", 3.0);
        System.out.println(expr.editExpr.expressao.calcular());
        expr.editExpr.setExpressaoStr("2 _a * _b + _b * _c -");
        expr.editVar.setVar("_c", 6.0);
        expr.editVar.listVars();
        System.out.println(expr.editExpr.expressao.calcular());
        
    }
}
