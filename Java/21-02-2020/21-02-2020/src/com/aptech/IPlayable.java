/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

public interface IPlayable {
    //this interfaces contains methods relating to "play.."
    //implements = override
    //-interfaces are public, default, BUT NOT "protected", "private"
    public void playFootball(String address);
    public void playTennis();//method CANNOT BE "private", "protected"
}
