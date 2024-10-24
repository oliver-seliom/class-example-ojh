package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
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
@Route(value="")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {

        NativeLabel header = new NativeLabel("Hello world");
        NativeLabel header2 = new NativeLabel("My name is Oliver");
        add(header);
        add(header2);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        NativeLabel header3 = new NativeLabel("Hello world");
        NativeLabel header4 = new NativeLabel("My name is Oliver");

        TextField name = new TextField("First Name");

        layout.add(header3);
        layout.add(header4);
        layout.add(name);

        Button button = new Button("Click me!");
        button.addClickShortcut(Key.ENTER);
        button.addClickListener(e->{
          System.out.println(name.getValue());
          name.clear();
          remove(button);
          Notification.show("Financial report generated");
        });
        // add(button);

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Dashboard",
                new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", layout);
        tabSheet.add("Shipping", button);
        add(tabSheet);

        Dialog dialog = new Dialog();

        TextField name1 = new TextField("Name");
        TextField name2 = new TextField("Name 2");
        
        dialog.setHeaderTitle("New employee");

        VerticalLayout dialogLayout = new VerticalLayout();
        dialog.add(dialogLayout);
        dialogLayout.add(name1, name2);

        Button saveButton = new Button("Save", e -> dialog.close());
        Button cancelButton = new Button("Cancel", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);

        Button openButton = new Button("Show dialog", e -> dialog.open());

        add(dialog, openButton);


        // TextField textField = new TextField("Your name");
        // textField.addClassName("bordered");

        // // Button click listeners can be defined as lambda expressions
        // Button button = new Button("Say hello", e -> {
        //     add(new Paragraph(service.greet(textField.getValue())));
        // });

        // // Theme variants give you predefined extra styles for components.
        // // Example: Primary button has a more prominent look.
        // button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // // You can specify keyboard shortcuts for buttons.
        // // Example: Pressing enter in this view clicks the Button.
        // button.addClickShortcut(Key.ENTER);

        // // Use custom CSS classes to apply styling. This is defined in
        // // styles.css.
        // addClassName("centered-content");

        // add(textField, button);
    }
}
