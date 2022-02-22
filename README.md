## Задача Магазин

### *SOLID*

1. S - Принцип единой ответственности

В качестве примера приведен метод класса Wallet. Этот клас предназначен только для операций связаных с оплатой заказа.

```java
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
```


2. O - Принцип открытости/закрытости
   В качестве примера приведены параметры класса Products. При написании кода, старался, чтобы расширение функционала и ассортимета магазина было максимально простым. При увеличении ассортимента необходимо изменить класс Products и метод add() класса Basket.

```java
    protected String milk = "Молоко";
    protected String bread = "Хлеб";
    protected String sugar = "Сахар";
    protected String butter = "Масло";
    protected String water = "Вода";
    protected int milkPrice = 70;
    protected int breadPrice = 45;
    protected int sugarPrice = 30;
    protected int butterPrice = 100;
    protected int waterPrice = 40;product.get(chose - 1)
```

3. I - Принцип сегрегации интерфейса
   В качестве примера приведен интерфейс CardPayable. В функционале имеется возможность оплаты денежной картой и бонусной картой. Т.к. они схожи их можно было бы объединить в один интерфейс, но при дальнейшем расширении функционала могут появиться значительные различия в реализации, следовательно для каждой возможности оплаты создан свой интерфейс и пререопределены его методы в классе Wallet

```java
public interface CardPayable {
    void cardPay(int sum);
}
```

4. D - принцин инверсии зависимостей

   ```java
   List<String> product = new ArrayList<>();
   ```

Так же при написании был реализован принцип DRY. Все повторяющиеся эллементы функционала вынесены в отдельные методы. Единственный метод в котором осуществляется повторение - это метод add() класса Basket.
