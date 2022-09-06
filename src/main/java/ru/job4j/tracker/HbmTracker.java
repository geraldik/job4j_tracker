package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private static final String REPLACE_ITEM = "update Item i set i.name = :newName, "
            + "i.description = :newDescription, i.created = :newCreated where i.id = :fId";
    public static final String DELETE_ITEM = "delete from Item i where i.id = :fId";
    public static final String FIND_ALL_ITEMS = "from Item";
    public static final String FIND_BY_NAME_ITEM = "from Item i where i.name = :fName";
    public static final String FIND_BY_ID_ITEM = "from Item i where i.id = :fId";
    public static final String DELETE_ALL_ITEMS = "delete from Item i";
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery(REPLACE_ITEM)
                .setParameter("newName", item.getName())
                .setParameter("newDescription", item.getDescription())
                .setParameter("newCreated", item.getCreated())
                .setParameter("fId", id);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery(DELETE_ITEM)
                .setParameter("fId", id);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery(FIND_ALL_ITEMS).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery(FIND_BY_NAME_ITEM)
                .setParameter("fName", key).list();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery(FIND_BY_ID_ITEM)
                .setParameter("fId", id);
        Item result = (Item) query.uniqueResult();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public void deleteAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery(DELETE_ALL_ITEMS).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}