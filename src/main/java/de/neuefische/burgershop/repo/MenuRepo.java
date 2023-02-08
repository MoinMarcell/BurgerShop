package de.neuefische.burgershop.repo;

import de.neuefische.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class MenuRepo {

    private final List<Menu> menuList;

    public MenuRepo(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public Menu getMenuById(String id){
        for(Menu menu : menuList){
            if(menu.id().equals(id)){
                return menu;
            }
        }
        throw new NoSuchElementException("Menu with id " + id + " does not exist!");
    }

    public Menu addMenu(Menu menu){
        menuList.add(menu);
        return menu;
    }
}
