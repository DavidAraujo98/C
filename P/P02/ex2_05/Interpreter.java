import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Interpreter extends TranslatorBaseListener {

   @Override public void enterProgram(TranslatorParser.ProgramContext ctx) {
   }

   @Override public void exitProgram(TranslatorParser.ProgramContext ctx) {
   }

   @Override public void enterStat(TranslatorParser.StatContext ctx) {
   }

   @Override public void exitStat(TranslatorParser.StatContext ctx) {
   }

   @Override public void enterExpr(TranslatorParser.ExprContext ctx) {
   }

   @Override public void exitExpr(TranslatorParser.ExprContext ctx) {
   }

   @Override public void enterEveryRule(ParserRuleContext ctx) {
   }

   @Override public void exitEveryRule(ParserRuleContext ctx) {
   }

   @Override public void visitTerminal(TerminalNode node) {
   }

   @Override public void visitErrorNode(ErrorNode node) {
   }
}
