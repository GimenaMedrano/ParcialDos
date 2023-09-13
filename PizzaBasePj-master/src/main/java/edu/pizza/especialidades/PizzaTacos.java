package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaTacos extends Pizza {

    public PizzaTacos(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesTacos();
    }

    public void IngredientesTacos() {
        addTopping(new Topping("Carne Adobada", 50));
        addTopping(new Topping("Cilantro", 5));
        addTopping(new Topping("Cebolla", 5));
        addTopping(new Topping("Queso", 20));
        addTopping(new Topping("Salsa", 10));
        addTopping(new Topping("Salsa Chipotle", 15));
    }

}
