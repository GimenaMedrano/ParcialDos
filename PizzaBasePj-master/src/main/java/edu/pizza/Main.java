package edu.pizza;


import edu.formularios.fmrPizza1;
import edu.formularios.frmPizza;
import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaItaliana;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

       // JFrame frame =new JFrame("fmrPizza");
       // frame.setContentPane(new frmPizza().getjPanelPincipal());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

        // Crear una instancia del formulario fmrPizza1
        fmrPizza1 formularioPizza = new fmrPizza1();

        // Configurar la ventana
        JFrame frame = new JFrame("Formulario de Pizza");
        frame.setContentPane(formularioPizza.getjPanelPincipal1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajustar el tamaño de la ventana automáticamente
        frame.setSize(500, 800);
        frame.setVisible(true); // Hacer que la ventana sea visible

        //ejercicio 1
//       Pizza pizza = new Pizza("Pizza Margherita");
//       pizza.addTopping(new Topping("Champiñones", 10));
//       pizza.addTopping(new Topping("Mozzarella",20));
//        pizza.addTopping(new Topping("Cebolla",15));
//        pizza.addTopping(new Topping("Tomate",8));
//        pizza.prepare();

        //quiten la mozarella
        //vuelvan a preparar
        //pizza.removeTopping(1);
        //pizza.prepare();










//        Ejercicio 2 heredar
//        Creamos una instancia de la clase PizzaItaliana y agregamos varios toppings
//        a ella utilizando
//        el método "agregar" de la clase Topping.
//        PizzaItaliana pizzaItaliana =
//                new PizzaItaliana("Pizza Italiana", 10.99, "Salsa de tomate", new Topping("Tomato"), new Topping("Mozzarella"), new Topping("Basil"));
//        pizzaItaliana.prepare();


//        Ejercicio 3
//        Topping pepperoni = new Topping("Pepperoni");
//        pepperoni.agregarIngrediente("queso");
//        pepperoni.agregarIngrediente("champiñones");
//        System.out.println(pepperoni); // Salida: Topping{nombre='Pepperoni', ingredientes=['queso']}


    }
}
