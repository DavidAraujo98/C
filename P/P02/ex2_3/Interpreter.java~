public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      System.out.println("Result: " + visit(ctx.expr));
      return null;
   }

   @Override public Integer visitExprMulDivMod(CalculatorParser.ExprMulDivModContext ctx) {
      Integer res = 0;
      switch(ctx.op.getText()){
        case "*":
            res = visit(ctx.expr(0)) * visit(ctx.expr(1));
            break;
        case "/":
            res = visit(ctx.expr(0)) / visit(ctx.expr(1));
            break;
        case "%":
            res = visit(ctx.expr(0)) % visit(ctx.expr(1));
            break;    
      }
      return res;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer res = 0;
      switch(ctx.op.getText()){
        case "+":
            res = visit(ctx.expr(0)) + visit(ctx.expr(1));
            break;
        case "-":
            res = visit(ctx.expr(0)) + visit(ctx.expr(1));
            break; 
      }
      return res;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return res = Integer.parseInt(ctx.getText());
   }
}
