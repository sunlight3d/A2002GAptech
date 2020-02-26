/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.util.ArrayList;

public class TableManagement {
    //This is better, but I am not sure it is the best
    ArrayList<Table> tables = new ArrayList<>();
    public void inputTables() {
        for(int i = 0; i < 10; i++) {
            //random = min + Math.random() * (max - min);
            Table newTable = new Table(Table.randomAFloat(50.0, 250.0), 
            Table.randomAFloat(50.0, 250.0));
            this.tables.add(newTable);            
        }
    }
    public void displayTables() {
        //Display a list
        int j = 0;
        for(Table eachTable: this.tables) {
            j++;
            System.out.println(j+"."+eachTable);
        }
    }
}
