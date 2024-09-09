import java.util.*;
import java.util.stream.Collectors;

public class LaptopStore {

    private final Set<Laptop> laptops;

    public LaptopStore(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    // Метод для фильтрации ноутбуков по критериям
    public Set<Laptop> filterLaptops(Map<String, Object> filters) {
        return laptops.stream().filter(laptop -> {
            boolean matches = true;
            if (filters.containsKey("ram")) {
                matches &= laptop.getRam() >= (int) filters.get("ram");
            }
            if (filters.containsKey("storage")) {
                matches &= laptop.getStorage() >= (int) filters.get("storage");
            }
            if (filters.containsKey("os")) {
                matches &= laptop.getOs().equalsIgnoreCase((String) filters.get("os"));
            }
            if (filters.containsKey("color")) {
                matches &= laptop.getColor().equalsIgnoreCase((String) filters.get("color"));
            }
            return matches;
        }).collect(Collectors.toSet());
    }

    // Метод для запроса критериев у пользователя
    public static Map<String, Object> getFilterCriteria(Scanner scanner) {
        Map<String, Object> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int option = scanner.nextInt();
        scanner.nextLine(); // Считывание остатка новой строки

        switch (option) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                criteria.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                criteria.put("storage", scanner.nextInt());
                break;
            case 3:
                System.out.print("Введите название операционной системы: ");
                criteria.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.print("Введите цвет ноутбука: ");
                criteria.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Неверный ввод.");
        }

        return criteria;
    }

    // Метод для отображения списка ноутбуков
    public void displayLaptops(Set<Laptop> laptops) {
        if (laptops.isEmpty()) {
            System.out.println("Ноутбуков, удовлетворяющих условиям, не найдено.");
        } else {
            laptops.forEach(System.out::println);
        }
    }
}