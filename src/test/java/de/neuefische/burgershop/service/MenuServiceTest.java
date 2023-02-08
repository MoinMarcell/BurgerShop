package de.neuefische.burgershop.service;

import de.neuefische.burgershop.model.Beverage;
import de.neuefische.burgershop.model.Dish;
import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.repo.MenuRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MenuServiceTest {

    MenuRepo menuRepo = mock(MenuRepo.class);
    IdService idService = mock(IdService.class);
    MenuService menuService = new MenuService(menuRepo, idService);

    @Test
    void getAllMenus_whenListIsEmpty_ReturnEmptyList() {
        // GIVEN
        List<Menu> expected = Collections.emptyList();

        // WHEN
        when(menuRepo.getMenuList()).thenReturn(Collections.emptyList());

        List<Menu> actual = menuService.getAllMenus();

        // THEN
        assertEquals(expected, actual);
        verify(menuRepo).getMenuList();
    }

    @Test
    void getMenuById_whenMenuExist_thenReturnMenu() {
        // GIVEN
        Menu expected = new Menu("1", "Spaghetti", 3.40, new Dish("1", "Spaghetti"), new Dish("1", "Salad"), new Beverage("1", "Sprite"));

        // WHEN
        when(menuRepo.getMenuById("1")).thenReturn(expected);

        Menu actual = menuService.getMenuById("1");

        // THEN
        assertEquals(expected, actual);
        verify(menuRepo).getMenuById("1");
    }

    @Test
    void getMenuById_whenMenuNotExist_thenThrowException() {
        // GIVEN
        String id = "1";

        // WHEN
        when(menuRepo.getMenuById(id)).thenThrow(new NoSuchElementException("Menu with id " + id + " does not exist!"));

        // THEN
        assertThrows(NoSuchElementException.class, () -> menuRepo.getMenuById(id));
    }

    @Test
    void addMenu() {
        // GIVEN
        Menu expected = new Menu("1", "Spaghetti", 3.40, new Dish("1", "Spaghetti"), new Dish("1", "Salad"), new Beverage("1", "Sprite"));

        // WHEN
        when(menuRepo.addMenu(expected)).thenReturn(expected);
        when(idService.generateIt()).thenReturn("1");

        Menu actual = menuService.addMenu(expected);

        // THEN
        assertEquals(expected, actual);
        verify(menuRepo).addMenu(expected);
    }

    @Test
    void updateMenu() {
        // GIVEN
        String id = "1";
        Menu menuToUpdate = new Menu("1", "Spaghetti", 3.40, new Dish("1", "Spaghetti"), new Dish("1", "Salad"), new Beverage("1", "Sprite"));
        Menu expected = new Menu("1", "Spaghetti", 10.99, new Dish("1", "Spaghetti"), new Dish("1", "Salad"), new Beverage("1", "Sprite"));

        // WHEN
        when(menuRepo.updateMenu(id, menuToUpdate)).thenReturn(expected);

        Menu actual = menuService.updateMenu(id, menuToUpdate);

        // THEN
        assertEquals(expected, actual);
        verify(menuRepo).updateMenu(id, menuToUpdate);

    }
}