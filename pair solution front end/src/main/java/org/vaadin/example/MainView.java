package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
    public MainView() throws URISyntaxException, IOException, InterruptedException {
      TabSheet tabSheet = new TabSheet();
      tabSheet.add("Calculate pre-tax", taxLayout("preTax"));
      tabSheet.add("Calculate post-tax", taxLayout("postTax"));
      add(tabSheet); 
    }

    public VerticalLayout taxLayout(String taxType) throws URISyntaxException, IOException, InterruptedException{
      VerticalLayout verticalLayout = new VerticalLayout();
      HorizontalLayout horizontalLayout = new HorizontalLayout();

      // Dropdown to select employee type
      ComboBox<String> comboBox = new ComboBox<>("Employee Type");
      ArrayList<String> employeeTypes = DataService.getEmployeeTypes();
      comboBox.setItems(employeeTypes);

      NumberField sales = new NumberField();
      sales.setLabel("Number of monthly sales");

      NumberField hoursWorked = new NumberField();
      hoursWorked.setLabel("Extra hours worked");

      NativeLabel label = new NativeLabel();

      horizontalLayout.add(comboBox);
      horizontalLayout.add(sales);
      horizontalLayout.add(hoursWorked);

      Button submit = new Button("Calculate");
      submit.addClickListener(e->{
        // Let's create the body of the request to send to the backend
        String employeeType = comboBox.getValue();
        Integer extraHours = (int) hoursWorked.getValue().doubleValue();
        Integer numberOfSales = (int) sales.getValue().doubleValue();

        RequestBody body = new RequestBody(employeeType, extraHours, numberOfSales);

        label.removeAll();
        try {
          if(taxType.equals("preTax")){
            label.add("Pre tax salary: " + DataService.calculatePreTax(body));
          } else {
            label.add("Post tax salary: " + DataService.calculatePostTax(body));
          }
        } catch(Exception ex){
          System.out.println(ex);
        }
      });

      verticalLayout.add(horizontalLayout);
      verticalLayout.add(submit);
      verticalLayout.add(label);
      
      return verticalLayout;
    }
}
