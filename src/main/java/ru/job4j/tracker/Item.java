package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"created", "description"})
@Data
public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String description;
    private Timestamp created = Timestamp.valueOf(LocalDateTime.now());

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, Timestamp created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Timestamp created) {
        this.name = name;
        this.created = created;
    }

    public Item(String name, String description, Timestamp created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
}