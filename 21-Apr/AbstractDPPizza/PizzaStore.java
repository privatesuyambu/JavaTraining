package AbstractDPPizza;


public abstract class PizzaStore {
	 
	protected abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

class ThickCrustDough implements Dough {
	public String toString() {
		return "ThickCrust style extra thick crust dough";
	}
}
class ThinCrustDough implements Dough {
	public String toString() {
		return "Thin Crust style extra thick crust dough";
	}
}

class Spinach implements Veggies {

	public String toString() {
		return "Spinach";
	}
}
class Olives implements Veggies {

	public String toString() {
		return "Olives";
	}
}

class RedPepper implements Veggies {

	public String toString() {
		return "Red Pepper";
	}
}

class SlicedPepperoni implements Pepperoni {

	public String toString() {
		return "Sliced Pepperoni";
	}
}

class ItalCheese implements Cheese {

	public String toString() {
		return "Italian Cheese";
	}
}

class ParmesanCheese implements Cheese {

	public String toString() {
		return "Shredded Parmesan";
	}
}

class PlumTomatoSauce implements Sauce {
	public String toString() {
		return "Tomato sauce with plum tomatoes";
	}
}

class NYPizzaStore extends PizzaStore {
	 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		}  
		else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
}

class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} 

		 else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}




class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}
 
	public Cheese createCheese() {
		return new ItalCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Olives(), new RedPepper()};
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	
}

class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory 
{

public Dough createDough() {
	return new ThickCrustDough();
}

public Sauce createSauce() {
	return new PlumTomatoSauce();
}

public Cheese createCheese() {
	return new ParmesanCheese();
}

public Veggies[] createVeggies() {
	Veggies veggies[] = { new Olives(), 
	                      new Spinach(), 
	                      new RedPepper() };
	return veggies;
}

public Pepperoni createPepperoni() {
	return new SlicedPepperoni();
}


}



 