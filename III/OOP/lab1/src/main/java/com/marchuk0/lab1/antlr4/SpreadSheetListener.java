// Generated from /home/olexander/important/cyb/university/III/OOP/lab1/src/main/antrl4.com.marchuk0.lab1/SpreadSheet.g4 by ANTLR 4.8
package com.marchuk0.lab1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpreadSheetParser}.
 */
public interface SpreadSheetListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SpreadSheetParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(SpreadSheetParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpreadSheetParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(SpreadSheetParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minimum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinimum(SpreadSheetParser.MinimumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minimum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinimum(SpreadSheetParser.MinimumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Maximum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMaximum(SpreadSheetParser.MaximumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Maximum}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMaximum(SpreadSheetParser.MaximumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnarySubtraction}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnarySubtraction(SpreadSheetParser.UnarySubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnarySubtraction}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnarySubtraction(SpreadSheetParser.UnarySubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(SpreadSheetParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(SpreadSheetParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(SpreadSheetParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(SpreadSheetParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(SpreadSheetParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(SpreadSheetParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(SpreadSheetParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SpreadSheetParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decrement}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecrement(SpreadSheetParser.DecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decrement}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecrement(SpreadSheetParser.DecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Increment}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(SpreadSheetParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Increment}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(SpreadSheetParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivision(SpreadSheetParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivision(SpreadSheetParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(SpreadSheetParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(SpreadSheetParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPower(SpreadSheetParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link SpreadSheetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPower(SpreadSheetParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 */
	void enterSimpleMinArgs(SpreadSheetParser.SimpleMinArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 */
	void exitSimpleMinArgs(SpreadSheetParser.SimpleMinArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RecursiveMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 */
	void enterRecursiveMinArgs(SpreadSheetParser.RecursiveMinArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RecursiveMinArgs}
	 * labeled alternative in {@link SpreadSheetParser#minargs}.
	 * @param ctx the parse tree
	 */
	void exitRecursiveMinArgs(SpreadSheetParser.RecursiveMinArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleMaxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 */
	void enterSimpleMaxArgs(SpreadSheetParser.SimpleMaxArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleMaxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 */
	void exitSimpleMaxArgs(SpreadSheetParser.SimpleMaxArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RecursiveMAxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 */
	void enterRecursiveMAxArgs(SpreadSheetParser.RecursiveMAxArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RecursiveMAxArgs}
	 * labeled alternative in {@link SpreadSheetParser#maxargs}.
	 * @param ctx the parse tree
	 */
	void exitRecursiveMAxArgs(SpreadSheetParser.RecursiveMAxArgsContext ctx);
}