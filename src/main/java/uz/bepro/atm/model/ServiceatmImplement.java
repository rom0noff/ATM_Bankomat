package uz.bepro.atm.model;

import uz.bepro.atm.model.uzbek.UzbekchaLogics;

import java.util.Scanner;

public class ServiceatmImplement implements ServiceATM {

    static int num;

//    public  void Logics() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Qaysi til siz uchun qulay?");
//        System.out.println("1.O'zbekcha");
//        System.out.println("2.English");
//        System.out.println("3.Ruski");
//
//        switch (num = scanner.nextInt()){
//            case 1 : {
//                UzbekchaLogics uzbek = new UzbekchaLogics();
//                uzbek.Logicsinfo();
//                    break;
//            }
////            case 2 : {
////                English english = new English();
////                english.LogicsEnglish();
////                break;
////            }
////            case 3 : {
////                Ruski ruski = new Ruski();
////                ruski.LogicsRuski();
////                break;
////            }
//            default:
//                System.out.println("Kechirasiz | sorry | извине ");
//        }
//    }
    Scanner scanner = new Scanner(System.in);
    @Override
    public void changePin(Card card) {
        String password;
        System.out.println("Hozirgi parolingizni yozing.");
        password = scanner.nextLine();
        if(card.getPin().equals(password)){
            System.out.println("Yangi parolingzini yozing");
            card.setPin(scanner.nextLine());
            System.out.println("");
            System.out.println("");
            System.out.println("Omadli yakunlandi. Parolingiz o'zgartirildi.");
        }else System.out.println("Hozirgi parolingiz xato!!!");

    }

    @Override
    public void balance(Card card) {
        System.out.println("Sizning kartangiz hisobida : " + card.getBalance());
    }

    @Override
    public void withdraw(Card card) {
        System.out.println("1. 50 000 ");
        System.out.println("----------------------");
        System.out.println("2. 100 000 ");
        System.out.println("----------------------");
        System.out.println("3. 150 000 ");
        System.out.println("----------------------");
        System.out.println("4. 200 000 ");
        System.out.println("----------------------");
        System.out.println("5. Boshqa summa kiritish");
        double money;
        switch (scanner.nextInt()){
            case 1 : {
                money = (50000 + 50000 * 0.01);
                if(card.getBalance() >= money){
                    System.out.println("       ==========Chek:========");
                    System.out.println("Pulingizni oling : 50 000 sum");
                    System.out.println("1 ta 50 000 talik chiqazadi.");
                    System.out.println("Hisobingizda " + (card.getBalance() - money) + " so'm mablag' qoldi.");
                }else System.out.println("Hisobingizda mablag' yetarli emas.!");
                break;
            }
            case 2 : {
                money = (100000 + 100000 * 0.01);
                if(card.getBalance() >= money){
                    System.out.println("       ==========Chek:========");
                    System.out.println("Pulingizni oling : 100 000 sum");
                    System.out.println("1 ta 100 000 talik chiqazadi.");
                    System.out.println("Hisobingizda " + (card.getBalance() - money) + " so'm mablag' qoldi.");
                }else System.out.println("Hisobingizda mablag' yetarli emas.!");
                break;
            }
            case 3 : {
                money = (150000 + 150000 * 0.01);
                if(card.getBalance() >= money){
                    System.out.println("       ==========Chek:========");
                    System.out.println("Pulingizni oling : 150 000 sum");
                    System.out.println("1 ta 50 000 talik 1 ta 100 000 talik chiqazadi.");
                    System.out.println("Hisobingizda " + (card.getBalance() - money) + " so'm mablag' qoldi.");
                }else System.out.println("Hisobingizda mablag' yetarli emas.!");
                break;
            }
            case 4 : {
                money = (200000 + 200000 * 0.01);
                if(card.getBalance() >= money){
                    System.out.println("       ==========Chek:========");
                    System.out.println("Pulingizni oling : 200 000 sum");
                    System.out.println("2 ta 100 000 talik chiqazadi.");
                    System.out.println("Hisobingizda " + (card.getBalance() - money) + " so'm mablag' qoldi.");
                }else System.out.println("Hisobingizda mablag' yetarli emas.!");
                break;
            }
            case 5 : {
                System.out.println("Summani kiriting : ");
                money = scanner.nextDouble();
                if(money >= 10000){
                double moneySum = (money + money * 0.01);
                if(card.getBalance() >= moneySum){
                    System.out.println("       ==========Chek:========");
                    System.out.println("Pulingizni oling : " + money + " sum.");
//                    while (moneySum >= 100000) {
//                        moneySum = money / 100000;
//                    }
//                    while (money >= 50000) {
//                        double sum1 = ((money - moneySum * 100000) / 50000);
//                    }
//                    while (moneySum >= 20000) {
//                        moneySum = money / 20000;
//                    }
//                    while (moneySum >= 10000) {
//                        moneySum = money / 10000;
//                    }
//                    System.out.println("2 ta 100 000 talik chiqazadi.");
                    System.out.println("Hisobingizda " + (card.getBalance() - moneySum) + " so'm mablag' qoldi.");
                }else {
                    System.out.println("Hisobingizda mablag' yetarli emas.!");
                }
                break;

                }else System.out.println("Minimal summa 10 000 so'm.");
            }

        }
    }

    @Override
    public void tocount(Card card) {

    }

    @Override
    public boolean checkPin(Card card) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("Parolingizni kiriting.");
            String pin = scanner.nextLine();
            if (pin.equals(card.getPin())) {
                return true;
            } else {
                System.out.println("Parolingiz xato!!!");
                if (i == 2) {

                    return false;
                }
            }
        }
        card.setState(false);
        return false;
    }

    @Override
    public boolean replenishaccount(Card card) {
        double moneySum = card.getBalance();
        boolean shart = true;
        while (shart) {
            System.out.println("Naqt pulinigizni kiriting.");
            double money = scanner.nextDouble();
            moneySum += money;
            System.out.println("Hisobingizda : " + (moneySum));
            System.out.println("1. Pul kiritshni davom etish ->");
            System.out.println("2. Pulni plastik kartaga tashlash.");
            switch (scanner.nextInt()){
                case 1 : {
                    break;
                }
                case 2 : {
                    shart = false;
                    break;
                }
            }
        }
        card.setState(false);
        return false;
    }

    @Override
    public void currencyexchange(Card card) {
        double money;
        System.out.println("=====================");
        System.out.println("-=Hozirda kurs SOTIB OLISH: 1 USD -> 11 260,00 sum.    SOTISH: 11 300.00=-");
        System.out.println("");
        System.out.println("1. UZS -> USD");
        System.out.println("2. USD -> UZS");
        switch (scanner.nextInt()){
            case 1 : {
                System.out.println("Summani kiriting.");
                money = scanner.nextDouble();
                if(card.getBalance() >= (money+money * 0.01)){
                    System.out.println("Mavjud bo'lgan valyuta : " + (money / 11300) + " $");
                    System.out.println("Kartangizda qolgan mablag' : " + (card.getBalance() - (money + money*0.01)));
                }else System.out.println("Kartangizda mablag' yetarli emas.");
                break;
            }
            case 2 : {
                System.out.println("Kartangizdagi valyuta USD bo'lsagina ishlaydi!");
                System.out.println("USDni kiriting.");
                money = scanner.nextDouble();
                if(card.getBalance() < 10000) {
                    if (card.getBalance() >= (money + money * 0.01)) {
                        System.out.println("Mavjud bo'lgan summa : " + (money * 11300) + " SUM");
                        System.out.println("Kartangizda qolgan mablag' : " + (card.getBalance() - (money + money * 0.01)));
                    } else System.out.println("Kartangizda yetarli USD yo'q.");
                }else System.out.println("Kartangiz balansi USD emas!");
                break;
            }
        }

    }
}
