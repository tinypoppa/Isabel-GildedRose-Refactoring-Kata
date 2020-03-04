package com.gildedrose.service.factory;

import com.gildedrose.common.ItemType;
import com.gildedrose.service.GildedRose;
import com.gildedrose.service.GildedRoseConjured;
import com.gildedrose.service.IGildedRose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRoseFactory implements IGildedRoseFactory {
    private static final Logger logger = LoggerFactory.getLogger(GildedRoseFactory.class);

    private final static String REGULAR = "REGULAR";
    private final static String CONJURED = "CONJURED";
    private ItemType itemType;

    public GildedRoseFactory(ItemType itemType) {
        this.itemType = itemType;
    }

    public IGildedRose getGildedRose() throws Exception {
        if (itemType.name().equals(REGULAR)) {
            return new GildedRose();
        } else if (itemType.name().equals(CONJURED)) {
            return new GildedRoseConjured();
        } else {
            String error_msg = "Not a valid type of an Item";
            logger.error(error_msg, new Exception(error_msg));
            throw new Exception();
        }

    }
}
