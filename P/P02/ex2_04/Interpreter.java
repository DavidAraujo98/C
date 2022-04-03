public class Interpreter extends PreffixCalculatorBaseVisitor<Double> {

   @Override
   public Double visitProgram(PreffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Double visitStat(PreffixCalculatorParser.StatContext ctx) {
      System.out.println("Result: " + visit(ctx.expr()));
      return null;
   }

   @Override
   public Double visitExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx) {
      double res = 0.0;

      switch (ctx.op.getText()) {
         case "+":
            res = visit(ctx.expr(1)) + visit(ctx.expr(0));
            break;
         case "-":
            res = visit(ctx.expr(0)) - visit(ctx.expr(1));
            break;
         case "*":
            res = visit(ctx.expr(1)) * visit(ctx.expr(0));
            break;
         case "/":
            res = visit(ctx.expr(0)) / visit(ctx.expr(1));
            break;
      }

      return res;
   }

   @Override
   public Double visitExprNumber(PreffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.getText());
   }
}
