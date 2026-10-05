interface ProductView {
    void display();
}

class Product implements ProductView {
    static int objectCount = 0;
    int product_id;
    String product_name;
    double product_cost;
    int product_quantity;

    Product() {
        product_id = 0;
        product_name = "General Product";
        product_cost = 0.0;
        product_quantity = 0;
        objectCount++;
    }

    Product(int product_id, String product_name, double product_cost, int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_quantity = product_quantity;
        objectCount++;
    }

    public void display() {
        System.out.println("Product ID: " + product_id + " | Name: " + product_name + " | Cost: " + product_cost + " | Quantity: " + product_quantity);
    }

    static void showCount() {
        System.out.println("Total Product Objects Created: " + objectCount);
    }
}

class Main {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Monitor", 12500.0, 4);
        Product p2 = new Product(102, "Keyboard", 1500.0, 10);
        Product p3 = new Product(103, "Mouse", 600.0, 20);
        Product p4 = new Product();
        p1.display();
        p2.display();
        p3.display();
        p4.display();
        Product.showCount();
    }
}
