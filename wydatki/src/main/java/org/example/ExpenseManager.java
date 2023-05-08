package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {

    List<Expense> expenses= new ArrayList<>();

    public void displayAllExpenses(){
        expenses.forEach(ExpenseManager::displayExpenses);
    }

    private static void displayExpenses(Expense expense) {
        System.out.println(expense.description());
        System.out.println(expense.type());
        System.out.println(expense.month());
        System.out.println(expense.value());
        System.out.println("-----------------");
    }

    public void displayMonthlyExpenses(Scanner scanner){
        System.out.println("From which month do you want to see expenses?");
        int month = Integer.parseInt(scanner.nextLine());

        expenses.stream().filter(expense -> expense.month()==month).forEach(ExpenseManager::displayExpenses);
    }

    public void displayEntireCost(){
        double cost=0;
        for(Expense expense:expenses){
            cost+=expense.value();
        }
        System.out.println("The entire cost is: "+cost);
    }


    public void addExpense(Scanner scanner){
        System.out.println("What expenses do you want to add?(description)");
        String description = scanner.nextLine();
        System.out.println("What type of expenses is it?");
        String type = scanner.nextLine();
        System.out.println("How much did it cost?");
        double value= Double.parseDouble(scanner.nextLine());
        System.out.println("From which month is the expenses (number of month)");
        int month = Integer.parseInt(scanner.nextLine());

        Expense expense = new Expense(type,month,value,description);
        expenses.add(expense);

    }
}
