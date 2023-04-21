import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientDBTest extends Database{
    private final List<Ingredient> ingredients = new ArrayList<>();


    @Mock
    Database database;
    @Test
    public void availableIngredientTest(){
        Database database = new Database();
      int actual = database.availableIngredients().size();
      int expected = 6;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkAvailableBuns(){
        Database database = new Database();
        int actual = database.availableBuns().size();
        int expected = 3;
        Assert.assertEquals(expected,actual);
    }
}
