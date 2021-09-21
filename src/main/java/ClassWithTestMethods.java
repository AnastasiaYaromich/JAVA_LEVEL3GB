public class ClassWithTestMethods {
    @BeforeSuite
    public static void firstMethod() {
        System.out.println("В теле метода firstMethod");
    }
    @Test(priority = 5)
    public static  void methodWithPriority5() {
        System.out.println("В теле метода с приоритетом 5");
    }
    @Test(priority = 6)
    public static  void methodWithPriority6() {
        System.out.println("В теле метода с приоритетом 6");
    }
    @Test(priority = 7)
    public static  void methodWithPriority7() {
        System.out.println("В теле метода с приоритетом 7");
    }
    @AfterSuite
    public static void lastMethod() {
        System.out.println("В теле метода lastMethod");
    }
}
