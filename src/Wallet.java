public class Wallet implements CardPayable, BonusCardPayable {
    private int bankAccount = 23445;
    private int bonusCount = 765;
    private static Wallet instance = null;

    private Wallet(){}

    public static Wallet get() {
        if (instance == null) {
            instance = new Wallet();
        }
        return instance;
    }

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

    public void cashPay() {
        System.out.println("Заказ будет оплачен наличными при получении");
    }
}
