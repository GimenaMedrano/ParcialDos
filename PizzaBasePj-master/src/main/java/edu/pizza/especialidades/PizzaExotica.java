package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaExotica extends Pizza {

    public PizzaExotica(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesExoticos();
    }

    public void IngredientesExoticos() {
        addTopping(new Topping("Serpiente (pitón)", 150));
        addTopping(new Topping("Cocodrilo", 250));
        addTopping(new Topping("Rana", 60));
    }
}
