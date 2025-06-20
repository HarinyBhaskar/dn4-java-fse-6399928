import java.util.Scanner;

public class FactoryMethodTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter document type to open (word/pdf/excel): ");
        String input = scanner.nextLine().trim().toLowerCase();

        DocumentFactory factory;

        switch (input) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid document type.");
                scanner.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();
        scanner.close();
    }
}
