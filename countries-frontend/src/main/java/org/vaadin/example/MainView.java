package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     * @throws InterruptedException 
     * @throws IOException 
     * @throws URISyntaxException 
     */
    public MainView(@Autowired GreetService service) throws URISyntaxException, IOException, InterruptedException {
      Button button = new Button("Click me");
      ComboBox<Country> comboBox = new ComboBox<>("Country");

      ArrayList<Country> countries = DataService.getCountries();
      comboBox.setItems(countries);
      comboBox.setItemLabelGenerator(Country::getCapitalCity);

      Grid<Country> grid = new Grid<>(Country.class, false);
      grid.addColumn(Country::getName).setHeader("Name");
      grid.addColumn(Country::getCapitalCity).setHeader("Capital city");
      grid.setItems(countries);

      button.addClickListener(e->{
        try {
          Country country3 = new Country("Italy", "Rome");
          DataService.createCountry(country3);

          countries.add(country3);
          comboBox.setItems(countries);
          grid.setItems(countries);
        } catch (Exception ex) {
          System.out.println(ex);
        }
      });

      add(comboBox);
      add(button);
      add(grid);
    }
}
