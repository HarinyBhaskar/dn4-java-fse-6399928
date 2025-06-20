import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommercePlatformSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "T-shirt", "Clothing"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Book", "Education"),
            new Product(105, "Watch", "Accessories")
        };

        // Linear Search
        System.out.println("Linear Search for 'Shoes':");
        Product foundLinear = linearSearch(products, "Shoes");
        System.out.println(foundLinear != null ? foundLinear : "Product not found.");

        // Sort for Binary Search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
        System.out.println("\nBinary Search for 'Shoes':");
        Product foundBinary = binarySearch(products, "Shoes");
        System.out.println(foundBinary != null ? foundBinary : "Product not found.");
    }
}
