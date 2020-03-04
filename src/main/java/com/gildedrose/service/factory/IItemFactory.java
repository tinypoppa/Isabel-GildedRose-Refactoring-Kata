package com.gildedrose.service.factory;

import com.gildedrose.common.ItemType;
import com.gildedrose.model.Item;

public interface IItemFactory {
    Item[] getItems(ItemType itemType) throws Exception;
}
