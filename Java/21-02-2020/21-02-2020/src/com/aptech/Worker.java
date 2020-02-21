/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

import java.util.ArrayList;

public class Worker implements IPlayable, ILearning {
//1 class can implement many interfaces
    @Override
    public void playFootball(String address) {
        System.out.println("worker play football...");
    }

    @Override
    public void playTennis() {
        System.out.println("worker play tennis");
    }
    
    @Override
    public void gotoLibrary(String libraryName) {
        System.out.println("worker go to lib: "+libraryName);
    }
    @Override
    public void borrowSomeBooks(ArrayList<String> bookNames){
        System.out.println("Worker buy some books: "+bookNames);
    }
    
    
}
