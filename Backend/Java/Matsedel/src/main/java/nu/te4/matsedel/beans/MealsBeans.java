/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.matsedel.beans;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.swing.JLabel;
import nu.te4.matsedel.ConnectionFactory;
import nu.te4.matsedel.entities.Daily;
import nu.te4.matsedel.entities.Meals;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Stateless
public class MealsBeans {

    public int persist(Meals meal) {

        int id = meal.getId();
        int week = meal.getWeek();
        int date = meal.getDate();
        
        String mdish1 = meal.getMeals().get(0).getDish();
        String mdish2 = meal.getMeals().get(0).getDish2();
        String tudish1 = meal.getMeals().get(1).getDish();
        String tudish2 = meal.getMeals().get(1).getDish2();
        String weddish1 = meal.getMeals().get(2).getDish();
        String weddish2 = meal.getMeals().get(2).getDish2();
        String thdish1 = meal.getMeals().get(3).getDish();
        String thdish2 = meal.getMeals().get(3).getDish2();
        String fdish1 = meal.getMeals().get(4).getDish();
        String fdish2 = meal.getMeals().get(4).getDish2();

        try ( Connection connection = ConnectionFactory.GetConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO menu VALUES (NULL, %d, '%s',"
                    + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s',%d)",
                    week, mdish1, mdish2, tudish1, tudish2, weddish1,
                    weddish2, thdish1, thdish2, fdish1, fdish2, date);
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error ProductBean.Persist: " + e.getMessage());
        }

        return 0;
    }

    public Meals getMeal() {
        Meals meal;
        java.util.Calendar date = java.util.Calendar.getInstance();
        meal = getFromDatabase(date.get(java.util.Calendar.WEEK_OF_YEAR));
        if (meal == null) {
            meal = scrape();
            persist(meal);
            System.out.println("Skrapar");
        }
        else{
            System.out.println("Hämtar");
        }
        
        return meal;
    }

    private Meals getFromDatabase(int week) {
        try (Connection connection = ConnectionFactory.GetConnection()){
            Meals meal = new Meals();
            Statement stmt = connection.createStatement();
            String sql ="SELECT * FROM menu WHERE week = "+week;
            ResultSet data = stmt.executeQuery(sql);
            data.next();
            meal.setWeek(week);
            String mdish1 = data.getString("mon_dish1");
            String mdish2 = data.getString("mon_dish2");
            String tuedish1 = data.getString("tue_dish1");
            String tuedish2 = data.getString("tue_dish2");
            String weddish1 = data.getString("wed_dish1");
            String weddish2 = data.getString("wed_dish2");
            String thrdish1 = data.getString("thr_dish1");
            String thrdish2 = data.getString("thr_dish2");
            String fridish1 = data.getString("fri_dish1");
            String fridish2 = data.getString("fri_dish2");
            
             Daily monday = new Daily();
                monday.setDish(mdish1);
                monday.setDish2(mdish2);
                meal.getMeals().add(monday);
                
                Daily tuesday = new Daily();
                tuesday.setDish(tuedish1);
                tuesday.setDish2(tuedish2);
                meal.getMeals().add(tuesday);
                
                Daily wed = new Daily();
                wed.setDish(weddish1);
                wed.setDish2(weddish2);
                meal.getMeals().add(wed);

                
                Daily thursday = new Daily();
                tuesday.setDish(thrdish1);
                tuesday.setDish2(thrdish2);
                meal.getMeals().add(thursday);

                
                Daily friday = new Daily();
                friday.setDish(fridish1);
                friday.setDish2(fridish2);
                meal.getMeals().add(friday);

            
                return meal;
            

        } catch (Exception e) {
            System.out.println("Error MealsBean.getFormDatabase"+e.getMessage());
        }
        return null;
    }

    private Meals scrape() {
        Meals meal = new Meals();
        try {
            String url = "https://skolmaten.se/teknikum/";
            Document document = Jsoup.connect(url).get();
            int week = Integer.parseInt(document.select("h3 span").get(0).html());
            Elements rows = document.select("div#weeks div.week.visible div.row");
            
            List <String> dishes = new ArrayList();
            for (Element row : rows) {
                String day = row.select("div.date span.weekday").get(0).html();
                String dish = row.select("div.items p span").get(0).html();
                String dish2 = row.select("div.items p:nth-of-type(2n) span").get(0).html();
                Daily daily = new Daily();
                daily.setDish(dish);
                daily.setDish2(dish2);
                daily.setDay(day);
                meal.getMeals().add(daily);
            }
       meal.setWeek(week);
        } catch (Exception e) {
            System.out.println("Error Start.main: " + e.getMessage());
        }
        return meal;
    }
}
