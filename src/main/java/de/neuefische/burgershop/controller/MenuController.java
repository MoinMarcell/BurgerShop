package de.neuefische.burgershop.controller;

import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenu(@PathVariable String id){
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable String id, @RequestBody Menu menu){
        return menuService.updateMenu(id, menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String id){
        menuService.deleteMenu(id);
    }

}
