package model;

import java.time.LocalDateTime;

public class Player {
    private String name;
    private int id;
    private LocalDateTime created_at;

    // An Empty constructor
    public Player() {}

    // Constructor when making a new player with just the name.
    public Player(String name) {
        this.name = name;
        this.created_at = LocalDateTime.now();
    }

    // Constructor when reading for DB and passing all parameters.
    public Player(String name, int id, LocalDateTime created_at) {
        this.name = name;
        this.id = id;
        this.created_at = created_at;
    }

    // All the setters and getters
    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreation(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getCreation() {
        return created_at;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name=" + name +
                ", createdAt=" + created_at + "}";
    }

}
