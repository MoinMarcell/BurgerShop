package de.neuefische.burgershop.service;

import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.repo.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepo;

    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public List<Menu> getAllMenus() {
        return menuRepo.getMenuList();
    }

    public Menu getMenuById(String id){
        return menuRepo.getMenuById(id);
    }
}
