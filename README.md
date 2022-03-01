## Задача Магазин

### *SOLID*

1. S - Принцип единой ответственности

В качестве примера приведен объект класса Wallet и сам класс Wallet. Этот клас предназначен только для операций
связанных с оплатой заказа. Это и является ответственностью класса Wallet. Поведение объект wallet направленно на
исключительно на обеспечение этой ответственности.

```java
public class Main {
    public static void menu() {
        Wallet wallet = Wallet.get();
        payMenu(wallet);
    }

    public static void payMenu(Wallet wallet) {
        wallet.cardPay(sum);
    }
}
```

```java
public class Wallet implements CardPayable, BonusCardPayable {
    @Override
    public void cardPay(int sum) {
        if (sum == 0) {
            System.out.println("Корзина пуста");
        } else if (sum < bankAccount) {
            bankAccount -= sum;
            System.out.println("₽ Заказ оплачен ₽");
            System.out.println("Произошло списание средств.\nОстаток на счете = " + bankAccount);
            System.out.println("Спасибо, что выбрали наш магазин");
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }
}
```

2. O - Принцип открытости/закрытости В качестве примера приведены параметры класса Products. При написании кода,
   старался, чтобы расширение функционала и ассортимента магазина было максимально простым. При увеличении ассортимента
   необходимо изменить класс Products и метод add() класса Basket.

```java
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
}
```

```java
class Basket {
    public Map<String, Integer> add() {
        //...
    }
}
```

Остальные метода класса Basket не зависят от ИД (от того какие именно продукты находятся в классе Product).

```java
class Basket {
    public void showBasket(Map<String, Integer> basket) {
        int number = 1;
        System.out.println("Ваша корзина состоит из следующих позиций");
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(number++ + "." + entry + " шт.");
            }
        }
    }
}
```

3. I - Принцип сегрегации интерфейса В качестве примера приведен интерфейсы CardPayable и BonusCardPayable. В
   функционале имеется возможность оплаты денежной картой и бонусной картой. Т.к. они схожи их можно было бы объединить
   в один интерфейс, но при дальнейшем расширении функционала могут появиться значительные различия в реализации,
   следовательно, для каждой возможности оплаты создан свой интерфейс и переопределены его методы в классе Wallet,

```java
public interface CardPayable {
    void cardPay(int sum);
}

public interface BonusCardPayable {
    void bonusCardPay(int sum);
}

public class Wallet implements CardPayable, BonusCardPayable {
    public void cardPay(int sum) {
        if (sum == 0) {
            System.out.println("Корзина пуста");
        } else if (sum < bankAccount) {
            bankAccount -= sum;
            System.out.println("₽ Заказ оплачен ₽");
            System.out.println("Произошло списание средств.\nОстаток на счете = " + bankAccount);
            System.out.println("Спасибо, что выбрали наш магазин");
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }

    @Override
    public void bonusCardPay(int sum) {
        if (sum == 0) {
            System.out.println("Корзина пуста");
        } else if (sum < bonusCount) {
            bonusCount -= sum;
            System.out.println("₽ Заказ оплачен ₽");
            System.out.println("Заказ оплачен бонусной картой.\nОстаток на счете = " + bonusCount);
            System.out.println("Спасибо, что выбрали наш магазин");
        } else {
            System.out.println("Недостаточно бонусных баллов");
        }
    }
}
```

4. D - принцип инверсии зависимостей

   ```java
   public class Products {
      public List<String> getProduct() {
         List<String> product = new ArrayList<>();
      }
   }
   ```

Так же при написании был реализован принцип DRY. Все повторяющиеся элементы функционала вынесены в отдельные методы.
Единственный метод в котором осуществляется повторение - это метод add() класса Basket.
