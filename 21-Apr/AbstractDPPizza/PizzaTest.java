package AbstractDPPizza;

public class PizzaTest {
	 
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
 
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("I ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("My sis ordered a " + pizza + "\n");


		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("I ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("My sis ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("I ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("My sis ordered a " + pizza + "\n");
	}
}