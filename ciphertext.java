package cipher;
import java.util.Scanner;
public class ciphertext {


    public static char encryptChar(char ch, int shift) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return (char) (((ch - base + shift) % 26) + base);
        } else if (Character.isDigit(ch)) {
            return (char) (((ch - '0' + shift) % 10) + '0');
        } else {
            return ch;
        }
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            ciphertext.append(encryptChar(ch, shift));
        }
        return ciphertext.toString();
    }

    public static char decryptChar(char ch, int shift) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return (char) (((ch - base - shift + 26) % 26) + base);
        } else if (Character.isDigit(ch)) {
            return (char) (((ch - '0' - shift + 10) % 10) + '0');
        } else {
            return ch;
        }
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            plaintext.append(decryptChar(ch, shift));
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shiftValue;
        String message;
        char choice;

        do {
            System.out.println("\nCaesar Cipher Menu");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter the shift value (integer): ");
                    if (!scanner.hasNextInt()) {
                        System.err.println("Invalid shift value. Please enter a non-negative integer.");
                        scanner.next(); 
                        break;
                    }
                    shiftValue = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter the message: ");
                    message = scanner.nextLine();
                    System.out.println("Encrypted message: " + encrypt(message, shiftValue));
                    break;

                case '2':
                    System.out.print("Enter the shift value (integer): ");
                    if (!scanner.hasNextInt()) {
                        System.err.println("Invalid shift value. Please enter a non-negative integer.");
                        scanner.next(); 
                        break;
                    }
                    shiftValue = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter the message: ");
                    message = scanner.nextLine();
                    System.out.println("Decrypted message: " + decrypt(message, shiftValue));
                    break;

                case '3':
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}
