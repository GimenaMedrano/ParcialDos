package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class Chicago extends Pizza {

    public Chicago(String name, Topping... toppings) {
        super(name, toppings);
        IngredientesChicago();
    }

    public void IngredientesChicago(){

        addTopping(new Topping("Salsa entera de Tomate",15));
        addTopping(new Topping("Salchica",20));
        addTopping(new Topping("Chorizo",25));
        addTopping(new Topping("una libra de Parmesano",35));


    }

    @Override
    public String toString() {
        return "Chicago{}";
    }
}
