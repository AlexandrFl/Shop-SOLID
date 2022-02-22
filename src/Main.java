import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int sum;
    public static List<String> product;
    public static List<Integer> price;
    public static Map<String, Integer> addProducts;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        Products products = new Products();
        product = products.getProduct();
        price = products.getPrice();
        Basket basket = new Basket(products, product, price);
        Wallet wallet = Wallet.get();
        System.out.println("👋" + " Здравствуйте, Добро пожаловать в наш интернет-магазин " + "👋");
        boolean tr = true;
        while (tr) {
            try {
                System.out.println("""
                        Введите "1" для просмотра ассортимента магазина
                        "2" для совершения покупок
                        "3" для просмотра корзины
                        "4" для удаления товара из корзины
                        "5" для оплаты
                        "0" для выхода""");
                int chose = Integer.parseInt(sc.nextLine());
                switch (chose) {
                    case 1 -> System.out.println(products);
                    case 2 -> addProducts = basket.add();
                    case 3 -> basket.showBasket(addProducts);
                    case 4 -> addProducts = basket.remove(addProducts);
                    case 5 -> {
                        sum = basket.getSum(addProducts);
                        payMenu(wallet);
                        tr = false;
                    }
                    case 0 -> {
                        System.out.println("Будем рады видеть вас снова");
                        tr = false;
                    }
                    default -> System.out.println("! Введено неверное значение !");
                }
            } catch (NumberFormatException e) {
                System.out.println("!!! Введено неверное значение !!!");
            }
        }
    }

    public static void payMenu(Wallet wallet) {
        System.out.println("""
                Введите "1" для оплаты банковской картой
                "2" для оплаты бонусной картой магазина
                "3" для оплаты наличными""");
        try {
            int chose = Integer.parseInt(sc.nextLine());
            switch (chose) {
                case 1 -> wallet.cardPay(sum);
                case 2 -> wallet.bonusCardPay(sum);
                case 3 -> wallet.cashPay();
                default -> System.out.println("! Введено неверное значение !");
            }
        } catch (NumberFormatException e) {
            System.out.println("!!! Введено неверное значение !!!");
        }
    }
}
