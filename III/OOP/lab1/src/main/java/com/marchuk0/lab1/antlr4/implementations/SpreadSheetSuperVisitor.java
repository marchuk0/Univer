package com.marchuk0.lab1.antlr4.implementations;

import com.marchuk0.lab1.antlr4.SpreadSheetBaseVisitor;
import com.marchuk0.lab1.antlr4.SpreadSheetParser;

public class SpreadSheetSuperVisitor extends SpreadSheetBaseVisitor<Integer> {

    @Override
    public Integer visitFormula(SpreadSheetParser.FormulaContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override
    public Integer visitMinimum(SpreadSheetParser.MinimumContext ctx) {
        return this.visit(ctx.minargs());
    }

    @Override
    public Integer visitMaximum(SpreadSheetParser.MaximumContext ctx) {
        return this.visit(ctx.maxargs());
    }

    @Override
    public Integer visitNumber(SpreadSheetParser.NumberContext ctx) {
        return Integer.parseInt(ctx.NUMBER().getText());
    }

    @Override
    public Integer visitParentheses(SpreadSheetParser.ParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }


    @Override
    public Integer visitPower(SpreadSheetParser.PowerContext ctx) {
        return (int) Math.pow(this.visit(ctx.left), this.visit(ctx.right));
    }


    @Override
    public Integer visitMultiplication(SpreadSheetParser.MultiplicationContext ctx) {
        return this.visit(ctx.left) * this.visit(ctx.right);
    }


    @Override
    public Integer visitDivision(SpreadSheetParser.DivisionContext ctx) {
        return this.visit(ctx.left) / this.visit(ctx.right);
    }


    @Override
    public Integer visitAddition(SpreadSheetParser.AdditionContext ctx) {
        return this.visit(ctx.left) + this.visit(ctx.right);
    }


    @Override
    public Integer visitSubtraction(SpreadSheetParser.SubtractionContext ctx) {
        return this.visit(ctx.left) - this.visit(ctx.right);
    }

    @Override
    public Integer visitSimpleMinArgs(SpreadSheetParser.SimpleMinArgsContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override
    public Integer visitRecursiveMinArgs(SpreadSheetParser.RecursiveMinArgsContext ctx) {
        return Math.min(this.visit(ctx.expression()), this.visit(ctx.minargs()));
    }

    @Override
    public Integer visitSimpleMaxArgs(SpreadSheetParser.SimpleMaxArgsContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override
    public Integer visitRecursiveMAxArgs(SpreadSheetParser.RecursiveMAxArgsContext ctx) {
        return Math.max(this.visit(ctx.expression()), this.visit(ctx.maxargs()));
    }
}
