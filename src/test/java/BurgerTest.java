import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotEquals;
import static praktikum.IngredientType.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public List<Ingredient> ingredients = new ArrayList<>();

    @Test
    public void checkAddIngredient(){

        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        Assert.assertEquals(2,burger.ingredients.size());

    }
    @Test
    public void checkRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(FILLING,"dinosaur",200));
        burger.removeIngredient(1);
        Assert.assertEquals(1,burger.ingredients.size());

    }


    @Test
    public void checkMoveIngredient() {
        List<Ingredient> ingredients = new ArrayList<>();
        Bun bun = new Bun("black bun",100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(FILLING,"dinosaur",200);
        Ingredient ingredient2 = new Ingredient(FILLING,"cutlet",100);
        Ingredient ingredient3 = new Ingredient(SAUCE,"hot sauce",100);
;
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String oldReceipt = burger.getReceipt();
            System.out.println(oldReceipt);
            burger.moveIngredient(1,2);
            String newReceipt = burger.getReceipt();
        System.out.println(newReceipt);
        assertNotEquals(oldReceipt,newReceipt);

    }

    @Test
    public void checkReceipt() {

        Bun bun = new Bun("black bun", 100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(FILLING, "dinosaur", 200);
        burger.addIngredient(ingredient1);
        System.out.println(burger.getReceipt());
        String receipt = burger.getReceipt();
        Assert.assertThat(receipt,containsString("filling dinosaur"));
    }

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void checkPriceBurger(){
        Mockito.when(bun.getPrice()).thenReturn((float)100);
        Mockito.when(ingredient.getPrice()).thenReturn((float)300);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(500,burger.getPrice(),0);

    }


}
