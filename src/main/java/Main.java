import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // получение кол-ва человек
        int cntPerson;
        System.out.println("Введите число человек, на которых необходимо разделисть счет:");
        while (true){
            try {
                cntPerson=new Scanner(System.in).nextInt();
                if (cntPerson<2){
                    System.out.println("Некорректное значение!");
                    System.out.println("Введите целое число больше единицы:");
                }
                else {
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Некорректное значение!");
                System.out.println("Ведите целое число больше единицы:");
            }
        }

        // добавление товаров в массив
        CalculateProducts calculateProducts = new CalculateProducts();
        System.out.println("Далее Вам будет необходимо ввести наименование товара и его стоимость в формате рубли.копейки");
        String command="";
        while (true){
            if (command.trim().equalsIgnoreCase("завершить")){
                // вывод ранее введенных товаров и суммы оплаты для каждого человека
                System.out.println("Добавленные товары:");
                for (Product p: calculateProducts.getProducts()) {
                    System.out.println(p.getName());
                }
                double result=calculateProducts.getFullPrice()/cntPerson;
                ResultFormatted.outFormatted(result);
                break;
            }
            else {
                try {
                    System.out.println("Ведите наименование товара:");
                    String product = new Scanner(System.in).nextLine().trim();
                    System.out.println("Введите стоимость товара:");
                    double price= Double.parseDouble(new Scanner(System.in).next().trim());
                    if (price<1){ // предположим, что стоимость товара не может быть менее одного рубля
                        System.out.println("Некорректное значение, товар не был добавлен!");
                        System.out.println("Повторите попытку ввода данных");
                    }
                    else {
                        calculateProducts.addProduct(new Product(product, price));
                        calculateProducts.setFullPrice(price);
                        System.out.println(calculateProducts.getFullPrice());
                        System.out.println("Товар успешно добавлен!");
                        System.out.println("Если хотите добавить еще один товар, то введите любую команду, иначе введите команду `завершить`");
                        command = new Scanner(System.in).nextLine();
                    }
                }
                catch (Exception e) {
                    System.out.println("Некорректное значение, товар не был добавлен!");
                    System.out.println("Повторите попытку ввода данных");
                }
            }
        }
    }
}
