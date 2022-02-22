import java.util.ArrayList;
import java.util.List;

public class Products {
    protected String milk = "Молоко";
    protected String bread = "Хлеб";
    protected String sugar = "Сахар";
    protected String butter = "Масло";
    protected String water = "Вода";
    protected int milkPrice = 70;
    protected int breadPrice = 45;
    protected int sugarPrice = 30;
    protected int butterPrice = 100;
    protected int waterPrice = 40;

    @Override
    public String toString() {
        return "В наличии имеются следующие товары:\n" + milk + " - " + milkPrice + " рублей\n" + bread + " - " + breadPrice + " рублей\n" + sugar + " - " + sugarPrice + " рублей\n"
                + butter + " - " + butterPrice + " рублей\n" + water + " - " + waterPrice + " рублей\n";
    }

    public List<String> getProduct() {
        List<String> product = new ArrayList<>();
        product.add(milk);
        product.add(bread);
        product.add(sugar);
        product.add(butter);
        product.add(water);
        return product;
    }

    public List<Integer> getPrice() {
        List<Integer> price = new ArrayList<>();
        price.add(milkPrice);
        price.add(breadPrice);
        price.add(sugarPrice);
        price.add(butterPrice);
        price.add(waterPrice);
        return price;
    }
}
