package it.inventaryManager;

public class Test {

	public static void main(String[] args) {

		
		
		InventaryManager im=new InventaryManager();
		
		im.addProduct("Armadio", 5);
		
		im.removeProduct("Armadio", 22);
		
		
		
		System.out.println(im.getAvaliableQuantity("Armadio"));
	}

}
