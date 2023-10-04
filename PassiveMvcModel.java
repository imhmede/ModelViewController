/**
 * This program demonstrates the use of Model View Controller pattern - Passive Model
 * @author  Essa Imhmed
 * Sep 26, 2023
 *
 */

import java.util.Scanner;

class Model {
		private String message;

		public String getMessage() {
				return message;
		}

		public boolean setMessage(String message) {
				this.message = message;
				return true;
		}
}

class Controller {

		private Model model;
		private View view;

		public Controller(Model model, View view) {
				this.model = model;
				this.view = view;
		}

		public String getMessage() {
				return model.getMessage();
		}

		public void setMessage(String message) {
				if(model.setMessage(message)) {
						updateView("Your message (" + message + ") has been successfully saved.");
				}
		}

		public void updateView(String message) {
				view.update(message);
		}

}

interface UserInterface {
		void update(String message);
		void setController(Controller controller);
		void sendMessage();
}

class View implements UserInterface{

		private String name;
		private Controller controller;

		public View(String name) {
				this.name = name;

		}

		@Override
		public void setController(Controller controller) {
				this.controller = controller;
		}

		@Override
		public void update(String message) {
				System.out.println(name + " : " + message);
		}

		@Override
		public void sendMessage() {
				Scanner in = new Scanner(System.in);
				while (in.hasNextLine()) {
						System.out.println("Enter Text : ");
						String line = in.nextLine();
						controller.setMessage(line);;
				}
		}
}

public class PassiveMvcModel {

		public static void main(String[] args) {

				Controller controller;
				Model model = new Model();
				View view = new View("View 1");
				controller = new Controller(model, view);
				view.setController(controller);
				view.sendMessage();
		}
}



