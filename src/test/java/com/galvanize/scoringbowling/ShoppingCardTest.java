package com.galvanize.scoringbowling;

import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCardTest extends TestCase {
    private ShoppingCard shoppingCard;
    private ShoppingCard.Item item;
    /*Given that I visit the site, when I begin shopping then I expect my card to be empty*/

    @Override
    public void setUp() throws Exception {
        super.setUp();
        shoppingCard = new ShoppingCard();
        item = shoppingCard.new Item();
    }

    public void testEmptyCard_initialization_ReturnTrue() throws Exception{
        //setup
        //exersise
        //assert
       assertEquals(true, shoppingCard.isEmpty());
    }


    /*Give I have an empty card, when I add an Item, then I expect to see totalPrice
     reflect the price of the Item in my card, times the quantities of the Item*/

    public void testAddNewItem_emptyCard_ReturnTotalPrice() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        shoppingCard.addNewItem(item);
        //exersise

        //assert
        assertEquals(false, shoppingCard.isEmpty());
        assertEquals(new BigDecimal(35.00), shoppingCard.getTotalPrice());
    }



    /*Given I have an empty card, when I add more then one of an Item then I expect
    ItemQuantities() to show the number of Items I have added*/

    public void testAddMoreThanOneItem_emptyCard_ReturnTotalNumberOfItems() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 10);
        shoppingCard.addNewItem(item);
        //exersise

        //assert
        assertEquals(false, shoppingCard.isEmpty());
        assertEquals(new BigDecimal(305.00), shoppingCard.getTotalPrice());
        assertEquals(2, shoppingCard.ItemQuantities());
    }

    public void testAddMoreThanOneItemRepeated_emptyCard_ReturnTotalNumberOfItems() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 10);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 2);
        shoppingCard.addNewItem(item);
        //exersise
        //assert
        assertEquals(false, shoppingCard.isEmpty());
        assertEquals(new BigDecimal(359.00), shoppingCard.getTotalPrice());
        assertEquals(2, shoppingCard.ItemQuantities());
        assertEquals(7, shoppingCard.items.get(0).getQuantity());
        assertEquals("type", shoppingCard.items.get(0).getType());
        assertEquals(12, shoppingCard.items.get(1).getQuantity());
        assertEquals("type2", shoppingCard.items.get(1).getType());
    }

    /*Given I have an empty card, when I add items, then I expect itemizedList()
    reflect the items I have added along with their price and quantity*/

    public void testAddNewItem_emptyCard_ReturnItemDetails() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 10);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type3", new BigDecimal(27.00), 2);
        shoppingCard.addNewItem(item);
        List<ShoppingCard.Item> itemList = shoppingCard.itemizedList();
        //exersise
        //assert
        assertEquals(3, itemList.size());
        assertEquals(7, itemList.get(0).getQuantity());
        assertEquals("type", itemList.get(0).getType());
        assertEquals(new BigDecimal(5.00), itemList.get(0).getPrice());
        assertEquals(10, itemList.get(1).getQuantity());
        assertEquals("type2", itemList.get(1).getType());
        assertEquals(new BigDecimal(27.00), itemList.get(1).getPrice());
        assertEquals(2, itemList.get(2).getQuantity());
        assertEquals("type3", itemList.get(2).getType());
        assertEquals(new BigDecimal(27.00), itemList.get(2).getPrice());
    }
    /*Given I have an empty card,  when I add more then one of an Item,
    Then I expect total price to reflect both the itemPrice and quantity*/

    public void testAddSomeItems_emptyCard_ReturnTotalPrice() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 10);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type3", new BigDecimal(8.00), 2);
        shoppingCard.addNewItem(item);
        //exersise
        //assert
        assertEquals(new BigDecimal(321.00), shoppingCard.getTotalPrice());

//        List m = new LinkedList();
//        m.add("lll");
//        m.add(2);
//        List<LinkedList> n = new LinkedList<LinkedList>();
//        n.add((LinkedList) m);
//        m = new LinkedList();
//        m.add("ppp");
//        m.add(27);
//        n.add((LinkedList) m);
//        ListIterator<LinkedList> listIterator = n.listIterator();
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }
    }
    /*Given I have a card with items that are not on sale, when I add Items that are on sale,
    * I expect onSaleItems() to include only the items on sale*/
    public void testAddOnSaleAndNotOnSaleItems_notEmptyCard_ReturnOnlyOnSale() throws Exception{
        //setup
        item = shoppingCard.new Item("type", new BigDecimal(5.00), 7);
        item.setOnSale(false);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type2", new BigDecimal(27.00), 10);
        item.setOnSale(false);
        shoppingCard.addNewItem(item);
        item = shoppingCard.new Item("type3", new BigDecimal(7.00), 7);
        shoppingCard.addNewItem(item);

        //exersise
        //assert
        assertEquals(1, shoppingCard.onSaleItems().size());
        assertEquals(item, shoppingCard.onSaleItems().get(0));
    }

}
