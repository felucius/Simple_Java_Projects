/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Breakfast;
import Domain.CustomComparator;
import Domain.Dinner;
import Domain.Food;
import Domain.Lunch;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author Maxime de Lange
 */
public class FoodInformationLogController implements Initializable {

    // FXML controller
    @FXML
    private TreeView<String> treeView;
    private TreeItem<String> dinnerTree;
    private TreeItem<String> lunchTree;
    private TreeItem<String> breakfastTree;

    // Fields
    private ObservableList<Food> foods;
    private ObservableList<Dinner> dinners;
    private ObservableList<Lunch> lunches;
    private ObservableList<Breakfast> breakfasts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createDinner();
        createLunch();
        createBreakfast();
        //createFoodTree();
        createNewTree(dinnerTree, lunchTree, breakfastTree);
    }

    public void createNewTree(TreeItem<String> dinnerTree, TreeItem<String> lunchTree, TreeItem<String> breakfastTree) {
        TreeItem<String> foodTree = new TreeItem<>("Food"); // Creating the first and Root branch
        TreeItem<String> calTree = new TreeItem<>("Calories"); // Creating the second branch
        
        for (Dinner dinner : dinners) {
            TreeItem<String> dinnerItem = new TreeItem<>(dinner.getName());
            boolean isFound = false;
            int calories = dinner.getAmountOfCalories();

            // Products that are found are going to be added to the designated tree branch.
            for (TreeItem<String> fo : foodTree.getChildren()) { // Retrieving value from the foodTree (root)
                for (TreeItem<String> f : calTree.getChildren()) { // Retrieving value from the calTree (second branch)
                    if (fo.getValue().contentEquals("Dinner")) {
                        if (f.getValue().contentEquals("cal" + calories)) {
                            System.out.println("Found product with amount of calories: " + calories);
                            f.getChildren().add(dinnerItem); // Adding dinner item to the calorie tree
                            isFound = true;
                        }
                    }
                }
            }

            /*
            Products that have not been found are going to be added as a new section/branch
            to the tree.
             */
            if (!isFound) {
                TreeItem<String> foo = new TreeItem<>("Dinner");
                TreeItem<String> fo = new TreeItem<>("cal" + calories);
                System.out.println("Not yet found product with amount of calories: " + calories);
                foodTree.getChildren().add(foo); // Adding new root dinner branch
                calTree.getChildren().add(fo); // Adding new calories branch
                foo.getChildren().add(fo); // Adding calories to dinner branch
                fo.getChildren().add(dinnerItem); // Adding dinner item to calorie branch
            }
        }

        for (Lunch lunch : lunches) {
            TreeItem<String> lunchItem = new TreeItem<>(lunch.getName());
            boolean isFound = false;
            int calories = lunch.getAmountOfCalories();

            // Products that are found are going to be added to the designated tree branch.
            for (TreeItem<String> fo : foodTree.getChildren()) {
                for (TreeItem<String> f : calTree.getChildren()) {
                    if (fo.getValue().contentEquals("Lunch")) {
                        if (f.getValue().contentEquals("cal" + calories)) {
                            System.out.println("Found product with amount of calories: " + calories);
                            f.getChildren().add(lunchItem);
                            isFound = true;
                        }
                    }
                }
            }

            /*
            Products that have not been found are going to be added as a new section/branch
            to the tree.
             */
            if (!isFound) {
                TreeItem<String> foo = new TreeItem<>("Lunch");
                TreeItem<String> fo = new TreeItem<>("cal" + calories);
                System.out.println("Not yet found product with amount of calories: " + calories);
                foodTree.getChildren().add(foo); // Adding new root lunch branch
                calTree.getChildren().add(fo); // Adding new calories branch
                foo.getChildren().add(fo); // Adding calories to lunch branch
                fo.getChildren().add(lunchItem); // Adding lunch item to calorie branch
            }
        }

        for (Breakfast breakfast : breakfasts) {
            TreeItem<String> breakfastItem = new TreeItem<>(breakfast.getName());
            boolean isFound = false;
            int calories = breakfast.getAmountOfCalories();

            // Products that are found are going to be added to the designated tree branch.
            for (TreeItem<String> fo : foodTree.getChildren()) {
                for (TreeItem<String> f : calTree.getChildren()) {
                    if (fo.getValue().contentEquals("Breakfast")) {
                        if (f.getValue().contentEquals("cal" + calories)) {
                            System.out.println("Found product with amount of calories: " + calories);
                            f.getChildren().add(breakfastItem);
                            isFound = true;
                        }
                    }
                }
            }

            /*
            Products that have not been found are going to be added as a new section/branch
            to the tree.
             */
            if (!isFound) {
                TreeItem<String> foo = new TreeItem<>("Breakfast");
                TreeItem<String> fo = new TreeItem<>("cal" + calories);
                System.out.println("Not yet found product with amount of calories: " + calories);
                foodTree.getChildren().add(foo); // Adding new root breakfast branch
                calTree.getChildren().add(fo); // Adding new calories branch
                foo.getChildren().add(fo); // Adding calories to breakfast branch
                fo.getChildren().add(breakfastItem); // Adding breakfast item to calorie branch
            }
        }

        foodTree.getChildren().addAll(dinnerTree, lunchTree, breakfastTree);
        treeView.setRoot(foodTree); // Start of the tree
        treeView.setEditable(true); // Makes the tree editable
    }

    public void createFoodTree() {
        TreeItem<String> foodTree = new TreeItem<>("Food");
        foodTree.setExpanded(true);
        for (Food food : foods) {
            TreeItem<String> dinner = new TreeItem<>(food.getName());
            boolean isFound = false;
            int calories = food.getAmountOfCalories();

            // Products that are found are going to be added to the designated tree branch.
            for (TreeItem<String> fo : foodTree.getChildren()) {
                if (fo.getValue().contentEquals("Dinner" + " /cal: " + calories)) {
                    System.out.println("Found product with amount of calories: " + calories);
                    fo.getChildren().add(dinner);
                    isFound = true;
                }
            }

            /*
            Products that have not been found are going to be added as a new section/branch
            to the tree.
             */
            if (!isFound) {
                TreeItem<String> foo = new TreeItem<>("Dinner" + " /cal: " + calories);
                System.out.println("Not yet found product with amount of calories: " + calories);
                foodTree.getChildren().add(foo); // Adding new root branch
                foo.getChildren().add(dinner); // Adding child to branch
            }

            treeView.setRoot(foodTree); // Start of the tree
            treeView.setEditable(true); // Makes the tree editable

            // Compare on calories
            treeView.getRoot().getChildren().sort(new CustomComparator());
        }
    }

    public void createDinner() {
        dinners = FXCollections.observableArrayList();
        dinners.add(new Dinner("Lasagna", 400, 12, 30, true));
        dinners.add(new Dinner("Spaghetti", 500, 12, 30, true));
        dinners.add(new Dinner("Meatloaf", 300, 12, 30, true));
        dinners.add(new Dinner("Pasta carbonara", 550, 12, 30, true));
        dinners.add(new Dinner("Bread meal", 300, 12, 30, false));
        dinners.add(new Dinner("Chicken salad", 200, 12, 30, false));
        dinners.add(new Dinner("Brocolli soup", 150, 12, 30, true));
        dinners.add(new Dinner("Chicken w potatoes", 350, 12, 30, true));

        dinners.add(new Dinner("Chicken tonight", 150, 12, 30, true));
        dinners.add(new Dinner("Tosti cheese", 350, 12, 30, true));
    }

    public void createLunch() {
        lunches = FXCollections.observableArrayList();
        lunches.add(new Lunch("Tosti egg and cheese", 350, 2, 25, true));
        lunches.add(new Lunch("Panini bacon cheese", 400, 5, 15, false));
        lunches.add(new Lunch("Bread with salami", 250, 6, 15, false));
        lunches.add(new Lunch("Bread with peanutbutter", 250, 0, 15, true));
        lunches.add(new Lunch("Pancakes", 300, 20, 50, false));
        lunches.add(new Lunch("Croissant with buns and cheese", 500, 11, 20, true));
    }

    public void createBreakfast() {
        breakfasts = FXCollections.observableArrayList();
        breakfasts.add(new Breakfast("Bacon and eggs", 250, 8, 15, true));
        breakfasts.add(new Breakfast("Beans and toast", 250, 4, 40, true));
        breakfasts.add(new Breakfast("Oatmeal", 200, 30, 50, true));
        breakfasts.add(new Breakfast("Porage", 200, 4, 30, false));
        breakfasts.add(new Breakfast("Cereals", 100, 50, 40, true));
    }
}
