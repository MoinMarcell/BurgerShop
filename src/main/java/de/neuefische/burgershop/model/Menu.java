package de.neuefische.burgershop.model;
public record Menu(
        String id,
        String name,
        double price,
        Dish mainDish,
        Dish sideDish,
        Beverage beverage
) {
}
