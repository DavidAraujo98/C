import java.util.HashMap;

public class Interpreter extends CalculatorBaseVisitor<Double> {

   static HashMap<String, Double> map = new HashMap<String, Double>();

   @Override
   public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Double visitStatExpr(CalculatorParser.StatExprContext ctx) {
      System.out.println("Result: " + visit(ctx.expr()));
      return null;
   }

   @Override
   public Double visitStatAssig(CalculatorParser.StatAssigContext ctx) {
      System.out.println(ctx.assig().ID().getText() + " = " + visit(ctx.assig()));
      return null;
   }

   @Override
   public Double visitAssig(CalculatorParser.AssigContext ctx) {
      Double r = visit(ctx.expr());
      map.put(ctx.ID().getText(), r);
      return r;
   }

   @Override
   public Double visitExprMulDivMod(CalculatorParser.ExprMulDivModContext ctx) {
      Double op1 = visit(ctx.expr(0));
      Double op2 = visit(ctx.expr(1));
      switch (ctx.op.getText()) {
         case "*":
            return op1 * op2;
         case "/":
            return op1 / op2;
         case "%":
            return op1 % op2;
      }
      return null;
   }

   @Override
   public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Double op1 = visit(ctx.expr(0));
      Double op2 = visit(ctx.expr(1));
      switch (ctx.op.getText()) {
         case "+":
            return op1 + op2;
         case "-":
            return op1 - op2;
      }
      return null;
   }

   @Override
   public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Double visitExprDouble(CalculatorParser.ExprDoubleContext ctx) {
      return Double.parseDouble(ctx.getText());
   }

   @Override
   public Double visitExprId(CalculatorParser.ExprIdContext ctx) {
      Double res = map.get(ctx.getText());
      return res;
   }
}
