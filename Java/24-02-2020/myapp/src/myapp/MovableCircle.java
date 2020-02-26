/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;//is null

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        System.out.println("moveUp");
    }

    @Override
    public void moveDown() {
        System.out.println("moveDown");
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
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
        return "radius : "+this.radius + "\n"+
                "center : "+this.center.toString();
    }
    
}
