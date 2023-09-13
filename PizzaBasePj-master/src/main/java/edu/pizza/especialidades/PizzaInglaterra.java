package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaInglaterra extends Pizza {

    public PizzaInglaterra(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesIngleses();
    }

    public void IngredientesIngleses() {
        addTopping(new Topping("Salchicha", 20));
        addTopping(new Topping("Huevo", 15));
        addTopping(new Topping("Frijoles", 10));
        addTopping(new Topping("Pudin", 25));
        addTopping(new Topping("Rebanadas de pan tostado", 15));
        addTopping(new Topping("Tomates", 10));
        addTopping(new Topping("Mangos", 20));
        addTopping(new Topping("Panecillos dulces", 15));
    }
}
