package it.inventaryManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InventaryManager {

	private Map<String,Integer> inventory=Collections.synchronizedMap(new HashMap<>());
	
	
	public void addProduct(String productId,int quantity) {
		synchronized (inventory) {
			if(inventory.containsKey(productId)) {
				int currentQuantity=inventory.get(productId);
				inventory.put(productId, currentQuantity+quantity);
			}
			else {
				inventory.put(productId, quantity);
			}
		}
		
	}
	public void removeProduct(String productId,int quantity){
		synchronized (inventory) {
			if(inventory.containsKey(productId)) {
				int currentQuantity=inventory.get(productId);
				
				if(currentQuantity>=quantity) {
					inventory.put(productId, currentQuantity-quantity);
				}
				else {
					System.out.println("Quantita insuficente per rimuovere il porodotto");
				}
				
			}
			else {
				System.out.println("Prodotto nn trovato nel inventario  "+productId);
			}
			
		}
		
		
	}
	public int getAvaliableQuantity(String productId) {

		synchronized (inventory) {
			return inventory.getOrDefault(productId, 0);

		}
				
	}
}
