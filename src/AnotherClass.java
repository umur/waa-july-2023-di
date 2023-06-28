import dependencyInjection.Inject;

public class AnotherClass {
    @Inject
    private OtherDependency otherDependency;
    public AnotherClass(){
        System.out.println("this is another class");
    }
}
