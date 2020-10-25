// Generated from /home/olexander/important/cyb/university/III/OOP/lab1/src/main/antrl4.com.marchuk0.lab1/SpreadSheet.g4 by ANTLR 4.8
package com.marchuk0.lab1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpreadSheetParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpreadSheetVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpreadSheetParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(SpreadSheetParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minimum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinimum(SpreadSheetParser.MinimumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Maximum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaximum(SpreadSheetParser.MaximumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(SpreadSheetParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(SpreadSheetParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(SpreadSheetParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(SpreadSheetParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(SpreadSheetParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(SpreadSheetParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(SpreadSheetParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleMinArgs(SpreadSheetParser.SimpleMinArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecursiveMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecursiveMinArgs(SpreadSheetParser.RecursiveMinArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleMaxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleMaxArgs(SpreadSheetParser.SimpleMaxArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecursiveMAxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecursiveMAxArgs(SpreadSheetParser.RecursiveMAxArgsContext ctx);
}