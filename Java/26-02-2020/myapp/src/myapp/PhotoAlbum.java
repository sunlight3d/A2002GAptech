/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
public class PhotoAlbum {
    private int numberOfPages;

    public int getNumberOfPages() {
        return this.numberOfPages;
    }
    PhotoAlbum(){
        numberOfPages = 16;                
    }
    PhotoAlbum(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    //detail object to a string
    public String toString() {
        return "number of page : "+numberOfPages;
    }
    
}
