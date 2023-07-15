package youtube;
public class annotaions {

    public static void main(String[] args) {
    
    Product product = new Product("Iphone", 200, 50);
    System.out.println(product.getClass().isAnnotationPresent(VeryImportant.class));

    }
}