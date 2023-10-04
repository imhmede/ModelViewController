/**
 * This program demonstrates the use of Model View Controller pattern - Active Model
 * Observable changes --> update Observer
 * Model changes --> update View
 * @author  Essa Imhmed
 * Sep 26, 2023
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

interface Observer {
		void update(String event);
}

class View implements Observer{
		private String name;

		public View(String name) {
				this.name = name;
		}

		@Override
		public void update(String event) {
				System.out.println(name + " received a message: " + event);
		}
}

interface Observable {
		void notifyObservers(String event);
		void addObserver(Observer observer);
		void scanSystemIn();
}

class Model implements Observable {
		List<Observer> observers = new ArrayList<>();

		@Override
		public void notifyObservers(String event) {
				for (Observer observer : observers) {
						observer.update(event);
				}
		}

		@Override
		public void addObserver(Observer observer) {
				observers.add(observer);
		}

		@Override
		public void scanSystemIn() {
				Scanner in = new Scanner(System.in);
				while (in.hasNextLine()) {
						System.out.println("Enter Text : ");
						String line = in.nextLine();
						notifyObservers(line);
				}
		}
}

public class ActiveMvcModel {

		public static void main(String[] args) {
				Model model = new Model();
				Observer observer1 = new View("View 1");
				Observer observer2 = new View("View 2");
				Observer observer3 = new View("View 3");

				model.addObserver(observer1);
				model.addObserver(observer2);
				model.addObserver(observer3);

				model.scanSystemIn();

		}
}
