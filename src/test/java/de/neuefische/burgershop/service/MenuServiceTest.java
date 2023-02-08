package de.neuefische.burgershop.service;

import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.repo.MenuRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuServiceTest {

    MenuRepo menuRepo = mock(MenuRepo.class);
    MenuService menuService = new MenuService(menuRepo);

    @Test
    void getAllMenus() {

        // GIVEN
        List<Menu> expected = Collections.emptyList();

        // WHEN
        when(menuRepo.getMenuList()).thenReturn(Collections.emptyList());

        List<Menu> actual = menuService.getAllMenus();

        // THEN
        assertEquals(expected, actual);
        verify(menuRepo).getMenuList();
    }
}