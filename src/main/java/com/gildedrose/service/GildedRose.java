package com.gildedrose.service;

import com.gildedrose.common.Constants;
import com.gildedrose.model.Item;

public class GildedRose implements IGildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public GildedRose() {

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            try {
                if (!items[i].name.equals(Constants.AGED_BRIE)
                        && !items[i].name.equals(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        if (items[i].name.equals(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }

                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }
                    }
                }

                //This function can be moved to the updateSellin() method
                if (!items[i].name.equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                    items[i].sellIn = items[i].sellIn - 1;
                }

                if (items[i].sellIn < 0) {
                    if (!items[i].name.equals(Constants.AGED_BRIE)) {
                        if (!items[i].name.equals(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                            if (items[i].quality > 0) {
                                if (!items[i].name.equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality;
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            } catch (NullPointerException e) {
                break;
            }
        }
    }
}