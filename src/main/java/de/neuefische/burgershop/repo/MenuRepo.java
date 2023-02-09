package de.neuefische.burgershop.repo;

import de.neuefische.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class MenuRepo {

    private final List<Menu> menuList;

    public MenuRepo(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public Optional<Menu> getMenuById(String id){
        return menuList.stream()
                .filter(menu -> menu.id().equals(id)).findFirst();
    }

    public Menu addMenu(Menu menu){
        menuList.add(menu);
        return menu;
    }

    public Menu updateMenu(String id, Menu menu){
        Menu menuToDelete = getMenuById(id).orElseThrow(NoSuchElementException::new);
        menuList.remove(menuToDelete);
        menuList.add(menu);
        return menu;
    }

    public void deleteMenu(String id){
        Menu menuToDelete = getMenuById(id).orElseThrow(NoSuchElementException::new);
        menuList.remove(menuToDelete);
    }
}
