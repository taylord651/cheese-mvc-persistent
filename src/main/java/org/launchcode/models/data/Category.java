package org.launchcode.models.data;

import org.launchcode.models.Cheese;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @NotNull
    @Size(min=3, max=15, message = "Category name must be between 3 and 15 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {}
}
