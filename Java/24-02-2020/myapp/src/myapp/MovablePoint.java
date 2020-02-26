/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

/**
 *
 * @author User
 */
public class MovablePoint implements Movable{
    private int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    @Override
    public void moveUp() {
        System.out.println("moveUp");
    }

    @Override
    public void moveDown() {
        System.out.println("moveDown");
    }

    @Override
    public void moveLeft() {
        System.out.println("moveLeft");
    }

    @Override
    public void moveRight() {
        System.out.println("moveRight");
    }

    @Override
    public String toString() {
        //toString = detail object's content = object's body
        return "x = "+this.x+"\n"+
                "y = "+this.y+"\n"+
                "xSpeed = "+this.xSpeed+"\n"+
                "ySpeed = "+this.ySpeed+"\n";
    }
    
}
