interface MealPlan {
    void prepareMeal();
}

class VegetarianMeal implements MealPlan {
    public void prepareMeal() {
        System.out.println("Preparing a Vegetarian Meal.");
    }
}

class VeganMeal implements MealPlan {
    public void prepareMeal() {
        System.out.println("Preparing a Vegan Meal.");
    }
}

class KetoMeal implements MealPlan {
    public void prepareMeal() {
        System.out.println("Preparing a Keto Meal.");
    }
}

class HighProteinMeal implements MealPlan {
    public void prepareMeal() {
        System.out.println("Preparing a High-Protein Meal.");
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void serveMeal() {
        meal.prepareMeal();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generating a personalized meal plan...");
        meal.prepareMeal();
    }
}

public class Main {
    public static void main(String[] args) {
        MealPlan vegetarian = new VegetarianMeal();
        MealPlan vegan = new VeganMeal();
        MealPlan keto = new KetoMeal();
        MealPlan highProtein = new HighProteinMeal();

        MealPlanGenerator.generateMealPlan(vegetarian);
        MealPlanGenerator.generateMealPlan(vegan);
        MealPlanGenerator.generateMealPlan(keto);
        MealPlanGenerator.generateMealPlan(highProtein);

        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        vegMeal.serveMeal();
    }
}
