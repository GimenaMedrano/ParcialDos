package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaDeSobras extends Pizza {

    public PizzaDeSobras(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesSobras();
    }

    public void IngredientesSobras() {
        addTopping(new Topping("Frutos secos", 15));
        addTopping(new Topping("Pasas", 10));
        addTopping(new Topping("Pipas de girasol", 10));
        addTopping(new Topping("Calabaza", 20));
        addTopping(new Topping("Bacon cocido", 30));
        addTopping(new Topping("Sobras de pollo", 35));

    }
}

