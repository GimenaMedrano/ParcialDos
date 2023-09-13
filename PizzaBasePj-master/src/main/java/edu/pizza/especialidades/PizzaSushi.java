package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaSushi extends Pizza {

    public PizzaSushi(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesSushi();
    }

    public void IngredientesSushi() {
        addTopping(new Topping("Salmón fresco", 40));
        addTopping(new Topping("Aguacate", 15));
        addTopping(new Topping("Alga nori", 5));
        addTopping(new Topping("Arroz de sushi", 30));
        addTopping(new Topping("Wasabi", 5));
        addTopping(new Topping("Salsa de soja", 10));
    }
}
