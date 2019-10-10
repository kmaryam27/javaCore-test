package com.galvanize.scoringbowling;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ShoppingCard {
    List<Item> items = new LinkedList<>();
    private BigDecimal totalPrice = new BigDecimal(0.00);

    class Item {
        private String type;
        private BigDecimal price;
        private int quantity;
        private boolean onSale;

        public Item(String type, BigDecimal price, int quantity) {
            this.type = type;
            this.price = price;
            this.quantity = quantity;
            this.onSale = true;
        }
        public Item() { }

        public String getType() { return type; }

        public void setType(String type) { this.type = type; }

        public BigDecimal getPrice() { return price; }

        public void setPrice(BigDecimal price) { this.price = price; }

        public int getQuantity() { return quantity; }

        public void setQuantity(int quantity) { this.quantity = quantity; }

        public boolean isOnSale() { return onSale; }

        public void setOnSale(boolean onSale) { this.onSale = onSale; }
    }

    public boolean isEmpty() {
        if ((totalPrice.equals(new BigDecimal(0.00))) &&(items.size() == 0))
            return true;
        return false;
    }


    public int ItemQuantities() {
        return items.size();
    }

    public BigDecimal getTotalPrice() { return totalPrice; }

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public void addNewItem(Item item) {
        int quantity = item.getQuantity();
        Iterator iterator = items.iterator();
        while (iterator.hasNext()){
            Item savedItem = (Item) iterator.next();
            if((savedItem.getType().toLowerCase().equals(item.getType()))&&(savedItem.getPrice().equals(item.getPrice()))){
                item.setQuantity(item.getQuantity() + savedItem.getQuantity());
                iterator.remove();
            }
        }
        items.add(item);
        totalPrice = totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public List itemizedList() {
        return items;
    }

    public List onSaleItems() {
        List<Item> onSaleItems = new LinkedList<>();
        Iterator iterator = items.iterator();
        while (iterator.hasNext()){
            Item savedItem = (Item) iterator.next();
            if(savedItem.isOnSale() == true)
                onSaleItems.add(savedItem);
        }
        return onSaleItems;
    }
}
