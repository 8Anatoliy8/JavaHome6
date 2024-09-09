import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main() {

        Set<Laptop> laptops = Set.of(
                new Laptop("Dell", 8, 512, "Windows", "Black"),
                new Laptop("HP", 16, 1024, "Windows", "Silver"),
                new Laptop("Apple", 8, 256, "MacOS", "Gray"),
                new Laptop("Lenovo", 4, 500, "Linux", "Black")
        );


        LaptopStore store = new LaptopStore(laptops);
        Scanner scanner = new Scanner(System.in);


        Map<String, Object> filters = LaptopStore.getFilterCriteria(scanner);


        Set<Laptop> filteredLaptops = store.filterLaptops(filters);


        store.displayLaptops(filteredLaptops);
    }
}