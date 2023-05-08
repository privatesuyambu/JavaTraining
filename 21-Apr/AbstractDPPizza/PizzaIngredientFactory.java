package AbstractDPPizza;

public interface PizzaIngredientFactory {

	   public Dough createDough();
		public Sauce createSauce();
		public Cheese createCheese();
		public Veggies[] createVeggies();
		public Pepperoni createPepperoni();
		
	 
	}

	 interface Sauce {
			public String toString();
		}

	 interface Dough {
			public String toString();
		}

	  interface Cheese {
	 	public String toString();
	 }
	  
	  interface Veggies {
			public String toString();
		}
	  interface Pepperoni {
			public String toString();
		}
