package com.example.android.justjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=2;


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity(quantity);


    }


    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);

    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox= (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameField= (EditText) findViewById(R.id.name_field);
        String name=nameField.getText().toString();
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        boolean hasChocolate=chocolateCheckBox.isChecked();

        int price=calculatePrice();
        String priceMessage=createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     *
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order
     *
     *@param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream
     * @param addChocolate is whether or not the user wants chocolate
     * @return text summary
     */

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage="Name: " + name;
        priceMessage+="\nAdd Whipped Cream?" + addWhippedCream;
        priceMessage+="\nAdd Chocolate?" + addChocolate;
        priceMessage+="\nQuantity:" + quantity;
        priceMessage+="\nTotal $" + price;
        priceMessage+="\nThank You!";
        return priceMessage;

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
