package com.gildedrose.service.strategy;

import com.gildedrose.common.ItemType;
import com.gildedrose.service.IGildedRose;
import com.gildedrose.service.factory.GildedRoseFactory;

public class ConjuredItemGildedRoseStrategy implements IGildedRoseStrategy {
    private ItemType itemType = ItemType.CONJURED;

    @Override
    public IGildedRose getGildedRoseStrategy() throws Exception {
        return new GildedRoseFactory(itemType).getGildedRose();
    }
}

