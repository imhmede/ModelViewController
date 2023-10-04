/**
 * This programs is the controller, and it acts as a bridge between the Model and
 * the View. It exchanges data between the model and the view.
 * @author  Essa Imhmed
 * Oct 2, 2023
 */

package com.example.helloworldsqllite;

import android.util.Log;

import java.util.List;

public class Controller {
    Model model;
    MainActivity view;

    /**
     * This is the constructor, defining model and view objects
     * @param model an object from the class Model
     * @param view an object from the class view
     */
    public Controller(Model model, MainActivity view) {
        this.model = model;
        this.view = view;
    }

    /**
     *  This function receives data passed by the view and deliver it to the model
     * @param name  the name of the employee
     * @param title the title of the employee
     * @param phone the employee's phone number
     * @param office the employee's office number
     * @param station the station at where the employee's office is located
     */
    void addUser(String name, String title, String phone, String office, String station) {
        model.addUser(new User(name, title, phone, office, station));
        view.acknowledge("Data has been received!");
    }

    /**
     *  This function retrieves data from model and deliver it to the view
     */
    public void viewUsers(){
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<User> Contacts = model.getAllContacts();

        for (User cn : Contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + ", Title: "
                    + cn.getTitle() + " ,Phone: " + cn.getPhone() + ", Office: " + cn.getOffice()
                    + ", Station: " + cn.getStation();
            view.acknowledge(log);
        }
    }
}
