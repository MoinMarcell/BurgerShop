package de.neuefische.burgershop.service;

import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.repo.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepo;
    private final IdService idService;

    public MenuService(MenuRepo menuRepo, IdService idService) {
        this.menuRepo = menuRepo;
        this.idService = idService;
    }

    public List<Menu> getAllMenus() {
        return menuRepo.getMenuList();
    }

    public Menu getMenuById(String id){
        return menuRepo.getMenuById(id);
    }

    public Menu addMenu(Menu menu){
        Menu menuToAdd = new Menu(
                idService.generateIt(),
                menu.name(),
                menu.price(),
                menu.mainDish(),
                menu.sideDish(),
                menu.beverage()
        );
        return menuRepo.addMenu(menuToAdd);
    }
}
