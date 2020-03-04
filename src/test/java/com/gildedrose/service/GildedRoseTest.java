package com.gildedrose.service;

import com.gildedrose.common.Constants;
import com.gildedrose.common.ItemType;
import com.gildedrose.model.ConjuredItem;
import com.gildedrose.model.Item;
import com.gildedrose.service.factory.IItemFactory;
import com.gildedrose.service.factory.ItemFactory;
import com.gildedrose.service.strategy.IGildedRoseStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void fooItem() throws Exception {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals("foo", items[0].name);
    }

    @Test
    void fooItem_AGED_BRIE_Case() throws Exception {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 10, 3) };
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals(4, items[0].quality);
    }

    @Test
    void fooItem_BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT_Case() throws Exception {
        //whereby quality < 50 and Sellin < 6
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 5, 3) };
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
    }


    @Test
    void fooConjureItems() throws Exception {
        ConjuredItem[] items = new ConjuredItem[] { new ConjuredItem("foo", 0, 0) };
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals("foo", items[0].name);
    }

    @Test
    void fooConjureItemsMoreThan1Item() throws Exception {
        ConjuredItem[] items = new ConjuredItem[] { new ConjuredItem("foo", 1, 1) };
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void fooIItemFactory() throws Exception {
        Item[] items = new Item[] { new Item("foo", 1, 1),  new ConjuredItem("boo", 2, 1)};
        IItemFactory itemFactory = new ItemFactory(items);
        items = itemFactory.getItems(ItemType.REGULAR);
        IGildedRoseStrategy gildedRoseStrategy = items[0].gildedRoseStrategy;
        IGildedRose app = gildedRoseStrategy.getGildedRoseStrategy();
        app.setItems(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

}
