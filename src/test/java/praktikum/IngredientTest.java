package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setup(){
        ingredient = new Ingredient(IngredientType.FILLING, "Начинка", 300f);
    }

    @Test
    public void getPriceWorksCorrectly(){
        float act = ingredient.getPrice();
        float exp = 300f;
        Assert.assertEquals(exp, act, 0);
    }

    @Test
    public void getNameWorksCorrectly(){
        String act = ingredient.getName();
        String exp = "Начинка";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void getTypeWorksCorrectly(){
        IngredientType act = ingredient.getType();
        IngredientType exp = IngredientType.FILLING;
        Assert.assertEquals(exp, act);
    }
}
