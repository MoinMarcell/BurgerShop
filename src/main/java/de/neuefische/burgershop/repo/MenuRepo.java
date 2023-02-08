package de.neuefische.burgershop.repo;

import de.neuefische.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepo {

    private final List<Menu> menuList;

    public MenuRepo(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
