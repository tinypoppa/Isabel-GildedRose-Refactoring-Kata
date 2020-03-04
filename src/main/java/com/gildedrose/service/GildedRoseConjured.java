package com.gildedrose.service;

import com.gildedrose.model.Item;

public class GildedRoseConjured implements IGildedRose {
    Item[] items;

    public GildedRoseConjured(Item[] items) {
        this.items = items;
    }

    @Override
    public void setItems(Item[] items) {
        this.items = items;
    }

    public GildedRoseConjured() {

    }

    @Override
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            try {
                if (items[i].quality > 0) {
                    items[i].quality = 0;
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
    }

    private void processUpdateSellin(String name, int sellIn) {
        //TODO Implementation
    }

    private void processUpdateQuality(String name, int quality, int sellIn) {
        //TODO Implementation
    }
}
