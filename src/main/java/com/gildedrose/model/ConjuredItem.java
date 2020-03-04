package com.gildedrose.model;

import com.gildedrose.service.strategy.ConjuredItemGildedRoseStrategy;

public class ConjuredItem extends Item {

    private static final String ITEM_CONJURED = "item_conjured";

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.gildedRoseStrategy = new ConjuredItemGildedRoseStrategy();
    }

    @Override
    public String toString() {
        return ITEM_CONJURED + ", " + this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
