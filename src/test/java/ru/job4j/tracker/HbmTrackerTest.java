package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @AfterEach
    public void clearData() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
            hbmTracker.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
            Item item = hbmTracker.add(new Item("item"));
            assertThat(hbmTracker.findById(item.getId())).isEqualTo(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
            Item item1 = hbmTracker.add(new Item("item1"));
            Item item2 = new Item("item2");
            hbmTracker.replace(item1.getId(), item2);
            item2.setId(item1.getId());
            assertThat(hbmTracker.findById(item1.getId())).isEqualTo(item2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void whenAddSeveralItemsAndFindAllThenMustBeTheSame() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
        Item item1 = hbmTracker.add(new Item("item1"));
        Item item2 = hbmTracker.add(new Item("item2"));
        List<Item> items = List.of(item1, item2);
        assertThat(hbmTracker.findAll()).isEqualTo(items);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void whenAddItemAndFindByNameThenMustBeTheSame() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
        Item item1 = hbmTracker.add(new Item("item1"));
        Item item2 = hbmTracker.add(new Item("item2"));
        Item item3 = hbmTracker.add(new Item("item3"));
        Item item4 = hbmTracker.add(new Item("item3"));
        assertThat(hbmTracker.findByName(item3.getName())).isEqualTo(List.of(item3, item4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void whenAddItemAndDeleteThenMustBeNull() {
        try (HbmTracker hbmTracker = new HbmTracker()) {
            Item item = hbmTracker.add(new Item("item"));
            hbmTracker.delete(item.getId());
            assertThat(hbmTracker.findById(item.getId())).isNull();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}