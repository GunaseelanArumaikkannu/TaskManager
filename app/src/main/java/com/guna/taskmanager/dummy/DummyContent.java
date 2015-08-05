package com.guna.taskmanager.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample title for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of title.
     */
    public static class DummyItem {
        public String id;
        public String title;
        public String path;
        public String description;

        public DummyItem(String id, String title, String path, String description) {
            this.id = id;
            this.title = title;
            this.path = path;
            this.description = description;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
