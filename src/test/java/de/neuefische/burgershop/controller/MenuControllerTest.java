package de.neuefische.burgershop.controller;

import de.neuefische.burgershop.model.Beverage;
import de.neuefische.burgershop.model.Dish;
import de.neuefische.burgershop.model.Menu;
import de.neuefische.burgershop.repo.MenuRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MenuControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MenuRepo menuRepo;

    @Test
    @DirtiesContext
    void getAllMenus_whenStatusIsOk_thenExpectEmptyList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    @DirtiesContext
    void getMenu_whenStatusIsOk_thenReturnMenu() throws Exception {
        menuRepo.addMenu(
                new Menu(
                        "1",
                        "Spaghetti",
                        3.40,
                        new Dish("1", "Spaghetti"),
                        new Dish("1", "Salad"),
                        new Beverage("1", "Sprite")
                ));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "name": "Spaghetti",
                            "price": 3.40,
                            "mainDish": {
                                "id": "1",
                                "name": "Spaghetti"
                            },
                            "sideDish": {
                                "id": "1",
                                "name": "Salad"
                            },
                            "beverage": {
                                "id": "1",
                                "name": "Sprite"
                            }
                        }
                        """));
    }

    @Test
    @DirtiesContext
    void addMenu() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.post("/api/menus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Spaghetti",
                                    "price": 3.40,
                                    "mainDish": {
                                        "id": "1",
                                        "name": "Spaghetti"
                                    },
                                    "sideDish": {
                                        "id": "1",
                                        "name": "Salad"
                                    },
                                    "beverage": {
                                        "id": "1",
                                        "name": "Sprite"
                                    }
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                {
                                    "name": "Spaghetti",
                                    "price": 3.40,
                                    "mainDish": {
                                        "id": "1",
                                        "name": "Spaghetti"
                                    },
                                    "sideDish": {
                                        "id": "1",
                                        "name": "Salad"
                                    },
                                    "beverage": {
                                        "id": "1",
                                        "name": "Sprite"
                                    }
                                }
                                """))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    @DirtiesContext
    void updateMenu() throws Exception {
        menuRepo.addMenu(
                new Menu(
                        "1",
                        "Spaghetti",
                        3.40,
                        new Dish("1", "Spaghetti"),
                        new Dish("1", "Salad"),
                        new Beverage("1", "Sprite")
                ));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/menus/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": "1",
                                    "name": "Spaghetti",
                                    "price": 10.99,
                                    "mainDish": {
                                        "id": "1",
                                        "name": "Spaghetti"
                                    },
                                    "sideDish": {
                                        "id": "1",
                                        "name": "Salad"
                                    },
                                    "beverage": {
                                        "id": "1",
                                        "name": "Sprite"
                                    }
                                }
                                """)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "name": "Spaghetti",
                            "price": 10.99,
                            "mainDish": {
                                "id": "1",
                                "name": "Spaghetti"
                            },
                            "sideDish": {
                                "id": "1",
                                "name": "Salad"
                            },
                            "beverage": {
                                "id": "1",
                                "name": "Sprite"
                            }
                        }
                        """));
    }

    @Test
    @DirtiesContext
    void deleteMenu() throws Exception {
        menuRepo.addMenu(
                new Menu(
                        "1",
                        "Spaghetti",
                        3.40,
                        new Dish("1", "Spaghetti"),
                        new Dish("1", "Salad"),
                        new Beverage("1", "Sprite")
                ));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/menus/1"))
                .andExpect(status().isOk());
    }
}