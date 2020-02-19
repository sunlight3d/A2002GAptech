package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private Integer row, column;
    private double mat[][];

    public Matrix(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        this.mat = new double[row][column];
    }
    Matrix() {}
    public double getValue(Integer row, Integer columm){
        return mat[row][columm];
    }

    //set the current value at row,column
    public void setValue(Integer column, Integer row, double value) {
        this.mat[column][row] = value;
        System.out.println("aaa");
    }
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
    public void input() {
        System.out.println("Enter row: ");
        Scanner scanner = new Scanner(System.in);
        this.row = scanner.nextInt();
        System.out.println("aa: ");

        System.out.println("Enter column: ");
        this.column = scanner.nextInt();
        this.mat = new double[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.println("Enter value  at : "+i+", "+j);
                Double value = scanner.nextDouble();
                this.setValue(i, j, value);
            }
        }
    }
    public void add(Matrix m2){
        if(this.row == m2.getRow() || this.column == m2.getColumn()){
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    this.mat[i][j] = this.mat[i][j] + m2.getValue(i, j);
                    //this.mat[i][j] = this.mat[i][j] + m2.mat[i][j];//why ok ?
                }
            }
        }
    }

    @Override
    public String toString() {
        String matDetail = "";
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matDetail += "mat at i = "+
                        i+"j = "+
                        this.mat[i][j]+"\n";
            }
        }
        return "Matrix{" +
                "row=" + row +
                ", column=" + column +
                ", mat=" + matDetail +
                '}';
    }
}
