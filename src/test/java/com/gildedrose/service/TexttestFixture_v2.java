package com.gildedrose.service;

import com.gildedrose.common.ItemType;
import com.gildedrose.model.Item;
import com.gildedrose.service.factory.IItemFactory;
import com.gildedrose.service.factory.ItemFactory;
import com.gildedrose.service.strategy.IGildedRoseStrategy;

public class TexttestFixture_v2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Process Begins....");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};


        ItemType itemTypes[] = ItemType.values();
        IItemFactory itemFactory = new ItemFactory(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }


        // For each type
        for (ItemType itemType : itemTypes) {
            System.out.println("Item Type : " + itemType + " Item in Process");
            System.out.println();
            items = itemFactory.getItems(itemType);
            IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
            IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
            for (int i = 0; i < days; i++) {
                System.out.println("-------- day " + i + " --------");
                app.setItems(items);
                System.out.println("name, sellIn, quality");
                for (Item item : items) {
                    if (item != null)
                        System.out.println(item);
                }
                System.out.println();
                app.updateQuality();
            }
        }
    }
}
