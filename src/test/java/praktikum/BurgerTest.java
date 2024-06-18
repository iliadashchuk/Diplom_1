package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsWorksCorrectly(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actualResult = burger.bun;
        Assert.assertEquals(bun, actualResult);
    }

    @Test
    public void addIngredientWorksCorrectly(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int actualResult = burger.ingredients.size();
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientWorksCorrectly() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualResult = burger.ingredients.size();
        int expectedResult = 0;
        Assert.assertFalse(burger.ingredients.contains(ingredient));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveIngredientWorksCorrectly() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceWorksCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Assert.assertTrue(burger.getPrice() > 0.0f);
    }

    @Test
    public void getReceiptWorksCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Assert.assertFalse(burger.getReceipt().isEmpty());
    }
}
