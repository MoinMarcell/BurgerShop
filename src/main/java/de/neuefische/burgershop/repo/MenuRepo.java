package de.neuefische.burgershop.repo;

import de.neuefische.burgershop.model.Menu;

import java.util.List;

public class MenuRepo {

    private final List<Menu> menuList;

    public MenuRepo(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList(){
        return menuList;
    }
}
