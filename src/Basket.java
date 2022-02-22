import java.util.*;

class Basket {
    protected Products products;
    protected List<String> product;
    protected List<Integer> price;
    protected static Scanner scanner = new Scanner(System.in);


    public Basket(Products products, List<String> product, List<Integer> price) {
        this.products = products;
        this.product = product;
        this.price = price;
    }

    public Map<String, Integer> add() {
        Map<String, Integer> basket = new HashMap<>();
        boolean bol = true;
        int chose;
        while (bol) {
            try {
                System.out.println("Введите цифру товара, чтобы добавить его в козину");
                for (int i = 0; i < product.size(); i++) {
                    System.out.println((i + 1) + "." + " " + product.get(i) + " - " + price.get(i) + " рублей"); //Молоко - 70 рублей, Хлеб - 45 рублей, Сахар - 30 рублей, Масло - 100 рублей, Вода - 40 рублей
                }
                System.out.println("Для выхода нажмите \"0\"");
                chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1 -> {
                        System.out.println(products.milk + ". Введите необходимое количество продукта в упаковках");
                        basket.put(products.milk, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Товар добавлен в корзину");
                    }
                    case 2 -> {
                        System.out.println(products.bread + ". Введите необходимое количество продукта в упаковках");
                        basket.put(products.bread, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Товар добавлен в корзину");
                    }
                    case 3 -> {
                        System.out.println(products.sugar + ". Введите необходимое количество продукта в упаковках");
                        basket.put(products.sugar, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Товар добавлен в корзину");
                    }
                    case 4 -> {
                        System.out.println(products.butter + ". Введите необходимое количество продукта в упаковках");
                        basket.put(products.butter, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Товар добавлен в корзину");
                    }
                    case 5 -> {
                        System.out.println(products.water + ". Введите необходимое количество продукта в литрах");
                        basket.put(products.water, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Товар добавлен в корзину");
                    }
                    case 0 -> bol = false;
                    default -> System.out.println("!!! Введено неверное значение !!!");
                }

            } catch (NumberFormatException e) {
                System.out.println("!!! Введено неверное значение !!!");
            }
        }
        return basket;
    }

    public void showBasket(Map<String, Integer> basket) {
        int number = 1;
        System.out.println("Ваша корзина состоит из следующих позиций");
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(number++ + "." + entry + " шт.");
            }
        }
    }

    public Integer getSum(Map<String, Integer> basket) {
        int sum = 0;
        for (String pr : basket.keySet()) {
            for (int i = 0; i < product.size(); i++) {
                if (pr.equals(product.get(i))) {
                    sum = sum + price.get(i) * basket.get(pr);
                }
            }
        }
        System.out.println("Общая сумма к оплате -> " + sum + " рублей.");
        return sum;
    }

    public Map<String, Integer> remove(Map<String, Integer> basket) {
        if (basket.isEmpty()) {
            System.out.println("Отсутствуют позиции для удаления");
        } else {
            showBasket(basket);
            boolean t = true;
            while (true) {
                System.out.println("Введите наименование продукта для удаления или \"0\" для выхода");
                String d = scanner.nextLine();
                if (d.equalsIgnoreCase("0")) {
                    t = false;
                    return basket;
                } else if (basket.containsKey(d)) {
                    basket.remove(d);
                    System.out.println("Позиция удалена");
                    showBasket(basket);
                } else {
                    System.out.println("Данной позицией нет в корзине");
                    return basket;
                }
            }
        }
        return basket;
    }
}
