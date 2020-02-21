/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

import java.util.ArrayList;

public interface ILearning {
    public void gotoLibrary(String libraryName);
    //Interface doesn't contain method's body 
    public void borrowSomeBooks(ArrayList<String> bookNames);
}
