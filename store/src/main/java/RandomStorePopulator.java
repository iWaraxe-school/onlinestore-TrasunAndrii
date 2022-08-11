import com.github.javafaker.Faker;

public class RandomStorePopulator {

    private static final Faker faker = new Faker();

    private static String generateRandomProductName(String category) {
        switch (category) {
            case "Beer":
                return faker.beer().name();
            case "Food":
                return faker.food().ingredient();
            case "Bike":
                return faker.pokemon().name();
            case "Milk":
                return faker.animal().name();
            case "Phone":
                return faker.commerce().productName();
            default:
                return null;
        }
    }

    private static int generateRandomProductRate() {
        return faker.number().numberBetween(1, 5);
    }

    private static int generateRandomProductPrice() {
        return faker.number().numberBetween(100, 10000);
    }

    public static Product generateRandomProduct(String category) {
        return new Product(generateRandomProductName(category), generateRandomProductRate(), generateRandomProductPrice());
    }
}
