package ru.job4j.tracker;

import org.junit.After;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @After
    public void wipeTable() throws SQLException {
        try (HbmTracker hbmTracker = new HbmTracker()) {
            Item item = hbmTracker.add(new Item("item"));
            assertThat(hbmTracker.findById(item.getId())).isEqualTo(item);
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
    void findAll() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findById() {
    }
}