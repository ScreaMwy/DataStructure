public class Main {
    public static void main(String[] args) throws Exception {
        Array<Double> a = new Array();
        a.add(1.00);
        a.add(2.00);
        a.add(3.00);
        a.add(4.00);
        a.add(5.00);
        a.add(6.00);
        a.add(7.00);
        a.add(8.00);
        a.add(9.00);
        a.add(10.00);
        a.add(11.00);
        a.add(12.00);
        //a.add(23, 5);
        System.out.printf("插入後：");
        a.display();
        System.out.printf("\n");

        a.remove(4.00);
        System.out.printf("刪除後：");
        a.display();
        System.out.printf("\n");

         double target = a.get(12.00);
        if (target > 0) {
            System.out.printf("元素存在：%.4f\n", target);
        } else {
            System.out.printf("元素不存在：%.4f\n", target);
        }
    }
}
