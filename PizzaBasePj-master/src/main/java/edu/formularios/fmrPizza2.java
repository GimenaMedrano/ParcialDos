package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaDeSobras;
import edu.pizza.especialidades.PizzaExotica;
import edu.pizza.especialidades.PizzaSushi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fmrPizza2 {
    private JPanel jPanelPincipal;
    private JComboBox ComboPrepararPizza;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JList LISTA;
    private JButton preparaPizzaButton;
    private JList list2;
    private JComboBox comboTipoPizza;

    private JRadioButton smalRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton grandeRadioButton;
    private JRadioButton extraGrandeRadioButton;
    private List<Topping> ingredientes=new ArrayList<>();
    private DefaultListModel modeloLista=new DefaultListModel();
    private DefaultListModel<String> modeloLista2 = new DefaultListModel<>();
    private List<String> tiposPizza=new ArrayList<>();

    private Map<String, List<Topping>> pizzaToppings = new HashMap<>();


    private double total;

    private double precioAdicional = 0;


    private void aplicarBorde(JComponent componente, Border borde) {
        componente.setBorder(borde);
    }


    public fmrPizza2() {

        Border bordeNegroGrueso = BorderFactory.createLineBorder(Color.BLACK, 2);

        aplicarBorde(jPanelPincipal, bordeNegroGrueso);

        aplicarBorde(btnAddIngrediente, bordeNegroGrueso);
        aplicarBorde(preparaPizzaButton, bordeNegroGrueso);


        //aplicarBorde(ComboRemoverIngredientes, bordeNegroGrueso);
        aplicarBorde(smalRadioButton, bordeNegroGrueso);
        aplicarBorde(medianaRadioButton, bordeNegroGrueso);
        aplicarBorde(grandeRadioButton, bordeNegroGrueso);
        aplicarBorde(extraGrandeRadioButton, bordeNegroGrueso);



        cargarTipoPizza();

        cargarToppings();

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smalRadioButton);
        sizeGroup.add(medianaRadioButton);
        sizeGroup.add(grandeRadioButton);
        sizeGroup.add(extraGrandeRadioButton);

        // Establece Small como seleccionado por defecto
        smalRadioButton.setSelected(true);

        comboTipoPizza.addActionListener(new ActionListener() {//comboListadePizzas
            public void actionPerformed(ActionEvent e) {



                // Obtén el tipo de pizza seleccionado por el usuario
                String tipoPizzaSeleccionada = (String) comboTipoPizza.getSelectedItem();
                modeloLista2.clear();



                // Limpia la lista actual
                modeloLista.clear();

                // Obtén la lista de toppings asociados a ese tipo de pizza desde el mapa pizzaToppings
                List<Topping> toppingsPizza = pizzaToppings.get(tipoPizzaSeleccionada);


                // Agrega los toppings de la pizza seleccionada a la lista
                for (Topping topping : toppingsPizza) {
                    modeloLista.addElement(topping.toString());
                    lista1.setModel(modeloLista);
                }

                // Calcula el total de los precios de los toppings
                total = toppingsPizza.stream().mapToDouble(Topping::getPrecio).sum();
                lblTotal.setText(String.valueOf(total));

                txtPizza.setText(tipoPizzaSeleccionada);
                smalRadioButton.setSelected(true);


            }
        });











        btnAddIngrediente.addActionListener(new ActionListener() {//agragar ingredinetes
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista2.clear();
                Topping ingrediente=(Topping)  ComboPrepararPizza.getSelectedItem();

                modeloLista.addElement(ingrediente.toString());
                lista1.setModel(modeloLista);
                total +=ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));

                Pizza pizza =new Pizza(txtPizza.getName());
                Topping topi;
                for (int i=0; i < lista1.getModel().getSize(); i++){

                    topi=(Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }

            }

        });

        preparaPizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista2.clear();
                prepararPizza();

            }

        });
        lista1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String tipoPizzaSeleccionada = (String) comboTipoPizza.getSelectedItem();

                List<Topping> toppingsPizza = pizzaToppings.get(tipoPizzaSeleccionada);

                if (e.getClickCount() == 2) {

                    if (lista1.getSelectedIndex()!= -1) {

                        String toppingSeleccionado = (String) modeloLista.getElementAt(lista1.getSelectedIndex());

                        // Encuentra el topping correspondiente en la lista de toppingsPizza
                        Topping topping = null;
                        for (Topping t : toppingsPizza) {
                            if (t.toString().equals(toppingSeleccionado)) {
                                topping = t;
                                break;
                            }
                        }


                        // Encuentra el topping correspondiente en la lista de ComboPrepararPizza

                        for (int i = 0; i < ComboPrepararPizza.getItemCount(); i++) {
                            Topping temp = (Topping) ComboPrepararPizza.getItemAt(i);
                            if (temp.toString().equals(toppingSeleccionado)) {
                                topping = temp;
                                break;
                            }
                        }

                        if (topping != null) {
                            // Resta el precio del topping al total
                            total -= topping.getPrecio();
                            lblTotal.setText(String.valueOf(total));

                            // Elimina el topping de la lista
                            modeloLista.removeElementAt(lista1.getSelectedIndex());
                        }
                    }
                }
            }
        });





        smalRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (smalRadioButton.isSelected()) {
                    modeloLista2.clear();
                    precioAdicional = 0;
                    actualizarTotal();

                }
            }
        });

        medianaRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (medianaRadioButton.isSelected()) {
                    modeloLista2.clear();
                    precioAdicional = total * 0.2; // Aumenta el precio en un 20%
                    actualizarTotal();

                }
            }
        });

        grandeRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (grandeRadioButton.isSelected()) {
                    modeloLista2.clear();
                    precioAdicional = total * 0.3; // Aumenta el precio en un 30%
                    actualizarTotal();

                }
            }
        });

        extraGrandeRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (extraGrandeRadioButton.isSelected()) {
                    modeloLista2.clear();
                    precioAdicional = total * 0.4; // Aumenta el precio en un 40%
                    actualizarTotal();

                }
            }
        });



    }

    public JPanel getjPanelPincipal1() {
        return jPanelPincipal;
    }
    //cargar toppings

    private void cargarToppings(){
        ingredientes.add(new Topping("tomate", 30));
        ingredientes.add(new Topping("champiniones", 30));
        ingredientes.add(new Topping("salsa", 30));
        ingredientes.add(new Topping("carne", 30));

        DefaultComboBoxModel model= new DefaultComboBoxModel(ingredientes.toArray());
        ComboPrepararPizza.setModel(model);

    }
    private void cargarTipoPizza(){
        PizzaDeSobras pizzadesobras = new PizzaDeSobras("Pizza de Sobras");

        tiposPizza.add(pizzadesobras.getName());

        PizzaExotica pizzaexotica = new PizzaExotica("Pizza Exotica");
        tiposPizza.add(pizzaexotica.getName());

        PizzaSushi pizzasushi = new PizzaSushi("Pizza Sushi");
        tiposPizza.add(pizzasushi.getName());

        Pizza pizz= new Pizza("Pizza para crear");
        tiposPizza.add(pizz.getName());

        DefaultComboBoxModel model = new DefaultComboBoxModel(tiposPizza.toArray());
        comboTipoPizza.setModel(model);

        pizzaToppings.put(pizzadesobras.getName(), pizzadesobras.getToppings());
        pizzaToppings.put(pizzaexotica.getName(), pizzaexotica.getToppings());
        pizzaToppings.put(pizzasushi.getName(), pizzasushi.getToppings());
        pizzaToppings.put(pizz.getName(),pizz.getToppings());




    }



    private void actualizarTotal() {
        double nuevoTotal = total + precioAdicional;
        lblTotal.setText(String.valueOf(nuevoTotal));
    }

    private void prepararPizza() {
        String tipoPizzaSeleccionada = (String) comboTipoPizza.getSelectedItem();
        if (tipoPizzaSeleccionada == null) {
            mostrarError("Selecciona un tipo de pizza antes de prepararla.");
            return;
        }

        if (modeloLista.isEmpty()) {
            mostrarError("Agrega al menos un ingrediente a la pizza antes de prepararla.");
            return;
        }

        String nombrePizza = txtPizza.getText().trim();
        if (nombrePizza.isEmpty()) {
            mostrarError("Ingresa un nombre para la pizza antes de prepararla.");
            return;
        }




        modeloLista2.addElement("Preparando.... " + tipoPizzaSeleccionada);
        modeloLista2.addElement("Agregando toppings");

        for (int i = 0; i < lista1.getModel().getSize(); i++) {
            String ingrediente = (String) lista1.getModel().getElementAt(i);
            String nombreIngrediente = ingrediente.split("Q")[0].trim();
            modeloLista2.addElement("- " + nombreIngrediente);
        }

        modeloLista2.addElement("Pizza lista!");

        list2.setModel(modeloLista2);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }



}

