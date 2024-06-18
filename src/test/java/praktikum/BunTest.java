package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunTest(){
        return new Object[][]{
                {"Черная булка", 100f},
                {"Белая булка", 200f},
                {"Красная булка", 300f}
        };
    }

    @Test
    public void getNameWorksCorrectly(){
        Bun bun = new Bun(name, price);
        String actualBun = bun.getName();
        Assert.assertEquals(name, actualBun);
    }

    @Test
    public void getPriceWorksCorrectly(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
