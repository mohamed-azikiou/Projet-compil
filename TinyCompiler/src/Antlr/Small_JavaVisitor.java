// Generated from C:/Users/pc/IdeaProjects/TinyCompiler\Small_Java.g4 by ANTLR 4.7.2
package Antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Small_JavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Small_JavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(Small_JavaParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(Small_JavaParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#single_import}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_import(Small_JavaParser.Single_importContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#code_bloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode_bloc(Small_JavaParser.Code_blocContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#dec_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_class(Small_JavaParser.Dec_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(Small_JavaParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(Small_JavaParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(Small_JavaParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(Small_JavaParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(Small_JavaParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(Small_JavaParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(Small_JavaParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(Small_JavaParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#read_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_expression(Small_JavaParser.Read_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#write_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_expression(Small_JavaParser.Write_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(Small_JavaParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#mov}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMov(Small_JavaParser.MovContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Small_JavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Small_JavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(Small_JavaParser.AtomContext ctx);
}