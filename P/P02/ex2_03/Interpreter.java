public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override
   public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Integer visitStat(CalculatorParser.StatContext ctx) {
      System.out.println("Result: " + visit(ctx.expr()));
      return null;
   }

   @Override
   public Integer visitExprMulDivMod(CalculatorParser.ExprMulDivModContext ctx) {
      int x = visit(ctx.expr(0));
      int y = visit(ctx.expr(1));
      switch (ctx.op.getText()) {
         case "*":
            return x * y;
         case "/":
            return x / y;
         case "%":
            return x % y;
      }
      return 0;
   }

   @Override
   public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      int x = visit(ctx.expr(0));
      int y = visit(ctx.expr(1));
      switch (ctx.op.getText()) {
         case "+":
            return x + y;
         case "-":
            return x - y;
      }
      return 0;
   }

   @Override
   public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.getText());
   }
}
