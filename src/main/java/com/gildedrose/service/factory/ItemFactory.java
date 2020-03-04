package com.gildedrose.service.factory;

import com.gildedrose.common.ItemType;
import com.gildedrose.model.ConjuredItem;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
* This class facilitates the correct creation of the Item object
* Base on the correct strategy to implement*/

public class ItemFactory implements IItemFactory {
    private static final Logger logger = LoggerFactory.getLogger(ItemFactory.class);
    private final static String REGULAR = "REGULAR";
    private final static String CONJURED = "CONJURED";
    private Item[] items;
    private final static String CONJURED_KEY = "Conjured";

    public ItemFactory(Item[] items) {
        this.items = items;
    }

    @Override
    public Item[] getItems(ItemType itemType) throws Exception {
        if (itemType.name().equals(REGULAR)) {
            return getNormalItems();
        } else if (itemType.name().equals(CONJURED)) {
            return getConjuredItems();
        } else {
            String error_msg = "Not a valid type of an Item";
            logger.error(error_msg, new Exception(error_msg));
            throw new Exception();
        }
    }

    private Item[] getNormalItems() {
        Item[] newItems = new Item[items.length];
        for (int i = 0, index = 0; i < items.length; i++) {
            if (!items[i].name.contains(CONJURED_KEY)) {
                newItems[index] = items[i];
                ++index;
            }
        }
        return newItems;
    }

    private Item[] getConjuredItems() {
        ConjuredItem[] newItems = new ConjuredItem[items.length];
        for (int i = 0, index = 0; i < items.length; i++) {
            if (items[i].name.contains(CONJURED_KEY)) {
                ConjuredItem conjuredItem = new ConjuredItem(items[i].name, items[i].sellIn, items[i].quality);
                newItems[index] = conjuredItem;
                ++index;
            }
        }
        return newItems;
    }
}
