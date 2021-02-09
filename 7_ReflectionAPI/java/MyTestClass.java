public class MyTestClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @Test(priority = 4)
    public void priority4() {
        System.out.println("priority4");
    }

    @Test(priority = 2)
    public void priority2() {
        System.out.println("priority2");
    }

    @Test(priority = 7)
    public void priority7() {
        System.out.println("priority7");
    }

    @Test(priority = 6)
    public void priority6() {
        System.out.println("priority6");
    }

    @Test(priority = 6)
    public void priority6double() {
        System.out.println("priority6double");
    }

    @Test(priority = 1)
    public void priority1() {
        System.out.println("priority1");
    }

    @Test
    public void priorityDefault() {
        System.out.println("priorityDefault");
    }

    @AfterSuite
    public void sfterSuite() {
        System.out.println("AfterSuite");
    }

}
