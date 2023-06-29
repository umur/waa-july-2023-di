public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Container container = new Container();

        container.registerDependency(UserRepository.class);
        container.registerDependency(EmailSender.class);

        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        System.out.println(userService.getRepository().getUser());
        System.out.println(userService.getEmailSender() == null);
    }
}