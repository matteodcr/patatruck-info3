package info3.game.tests;

import info3.game.content.Assembly;
import info3.game.content.Item;
import info3.game.content.ItemType;
import info3.game.content.Sauce;

public class TestRecipes {
	public static void main(String[] args) {
		assert new Item(ItemType.FRIES).fry().getType() == ItemType.COOKED_FRIES;
		assert new Item(ItemType.SALAD).fry() == null;

		assert new Item(ItemType.MEAT).cook().getType() == ItemType.COOKED_MEAT;
		assert new Item(ItemType.TOMATO_SLICE).cook() == null;

		assert new Item(ItemType.BREAD).cut().getType() == ItemType.BREAD_SLICE;
		assert new Item(ItemType.TOMATO_SLICE).cut() == null;

		Assembly burger = new Assembly();
		burger.addItem(new Item(ItemType.BREAD_SLICE));
		burger.addItem(new Item(ItemType.COOKED_GALETTE));
		burger.addItem(new Item(ItemType.CHEESE));
		assert burger.getItems().size() == 1;
		assert burger.getItems().get(0).getType() == ItemType.VEGI_BURGER;

		burger = new Assembly();
		burger.addItem(new Item(ItemType.BREAD_SLICE));
		burger.addItem(new Item(ItemType.COOKED_GALETTE));
		burger.addItem(new Item(ItemType.CHEESE));
		assert burger.getItems().size() == 1;
		assert burger.getItems().contains(new Item(ItemType.VEGI_BURGER));

		burger = new Assembly();
		burger.addItem(new Item(ItemType.CHEESE));
		burger.addItem(new Item(ItemType.BREAD_SLICE));
		burger.addItem(new Item(ItemType.COOKED_GALETTE));
		burger.addItem(new Item(ItemType.CHEESE));
		assert burger.getItems().size() == 1;
		assert burger.getItems().contains(new Item(ItemType.FAILED_Item));

		Assembly poutine = new Assembly();
		poutine.addItem(new Item(ItemType.COOKED_FRIES));
		poutine.addItem(new Item(ItemType.CHEESE));
		poutine.addItem(new Item(ItemType.CHEESE));
		assert poutine.getItems().size() == 1;
		assert poutine.getItems().contains(new Item(ItemType.POUTINE));

		burger = new Assembly();
		burger.addItem(new Item(ItemType.BREAD_SLICE));
		burger.addItem(new Item(ItemType.SALAD_LEAF));
		burger.addItem(new Item(ItemType.COOKED_MEAT));
		burger.addItem(new Item(ItemType.CHEESE));
		assert burger.getItems().size() == 1;
		assert burger.getItems().get(0).getType() == ItemType.CLASSIC_BURGER_SALAD;

		// test sauce
		burger.getItems().get(0).setSauce(Sauce.KETCHUP);
		assert burger.getItems().get(0).getSauce() == Sauce.KETCHUP;
		burger.getItems().get(0).setSauce(Sauce.MAYO);
		assert burger.getItems().get(0).getSauce() == Sauce.KETCHUP_MAYO;

		Assembly frite = new Assembly();
		frite.addItem(new Item(ItemType.COOKED_FRIES));
		frite.getItems().get(0).setSauce(Sauce.MAYO);
		assert frite.getItems().get(0).getSauce() == Sauce.MAYO;
		assert frite.getItems().get(0).getType().isFinalItem() == true;

		// random recette
		Item.getRandomItem();

		System.out.println("Everything works");
	}

}
