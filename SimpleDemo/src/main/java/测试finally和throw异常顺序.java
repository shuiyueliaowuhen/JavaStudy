public class 测试finally和throw异常顺序 {

    public static void main(String[] args) {
        int i = 0;
        try {
            System.out.println(i);
            int j = 1/0;
        }finally {
            i++;
            System.out.println("finally"+i);
        }
    }


}
