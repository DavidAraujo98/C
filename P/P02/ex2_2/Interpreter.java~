public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      System.out.println("Result: " + visit(ctx.expr()));  
      return null;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      Double res = Double.parseDouble(ctx.getText());
      return res;
   }

   @Override public Double visitExprNormal(SuffixCalculatorParser.ExprNormalContext ctx) {
      Double res = 0.0;
      Double op1 = visit(ctx.expr(0));
      Double op2 = visit(ctx.expr(1));
      switch(ctx.op.getText()){
        case "+":
            res = op1 + op2;
            break;
        case "-":
            res = op1 - op2;
            break;
        case "*":
            res = op1 * op2;
            break;
        case "/":
            res = op1 / op2;
            break;
      }
      return res;
   }
}
