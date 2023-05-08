package org.example;

import java.util.Scanner;

public class ExpensesApp {

    public void start(){
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();
        while (true){
            System.out.println("1. Display all expenses");
            System.out.println("2. Display expenses from the selected month");
            System.out.println("3. Add expenses");
            System.out.println("4. Display the entire cost");
            System.out.println("5. End application");
            System.out.println("Choose option:");
            int choice = Integer.parseInt(scanner.nextLine());



            switch (choice){
                case 1 ->{
                    expenseManager.displayAllExpenses();
                }
                case 2->{
                    expenseManager.displayMonthlyExpenses(scanner);
                }
                case 3->{
                   expenseManager.addExpense(scanner);
                }
                case 4->{
                    expenseManager.displayEntireCost();
                }
                case 5->{
                    scanner.close();
                    System.exit(0);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }

        }
    }
}
