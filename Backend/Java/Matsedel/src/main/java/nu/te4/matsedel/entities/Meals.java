/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.matsedel.entities;

import java.util.ArrayList;

/**
 *
 * @author T4User
 */
public class Meals {
    private int id;
    private int week;
    private int date;

    ArrayList <Daily> meals; 

    public ArrayList<Daily> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Daily> meals) {
        this.meals = meals;
    }

    public Meals() {
        meals = new ArrayList();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
