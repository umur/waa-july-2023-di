public class MyService {
    @Inject
    private MyRepository1 myRepository1;

    @Inject
    private MyRepository2 myRepository2;

    public MyRepository1 getMyRepository1() {
        return myRepository1;
    }

    public MyRepository2 getMyRepository2() {
        return myRepository2;
    }
}
