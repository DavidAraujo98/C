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
      return Double.parseDouble(ctx.getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      double res = 0.0;
      
      switch(ctx.op.getText()){
        case "+":
            res = visit(ctx.expr(1)) + visit(ctx.expr(0));
            break;
        case "-":
            res = visit(ctx.expr(0)) + visit(ctx.expr(1));
            break;
        case "*":
            res = visit(ctx.expr(1)) + visit(ctx.expr(0));
            break;
        case "/":
            res = visit(ctx.expr(0)) + visit(ctx.expr(1));
            break;
      }
      
      return res;
   }
}
