package com.gildedrose.model;

import com.gildedrose.service.strategy.IGildedRoseStrategy;
import com.gildedrose.service.IGildedRose;
import com.gildedrose.service.strategy.ItemGildedRoseStrategy;

public class Item {

    public IGildedRoseStrategy gildedRoseStrategy;
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.gildedRoseStrategy = new ItemGildedRoseStrategy();
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public IGildedRose getGildedRose() throws Exception {
        return gildedRoseStrategy.getGildedRoseStrategy();
    }

}
