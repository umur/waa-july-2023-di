public class AnotherClass {

    @MyAutoWired
    UserService userService;

    public void print() {
        System.out.println("This is call from Another Class");
        userService.print();
    }
}
