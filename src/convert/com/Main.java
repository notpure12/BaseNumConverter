package convert.com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Choose conversion type (1: Binary to Decimal, 2: Decimal to Binary, 3: Binary to Hexadecimal, 4: Decimal to Hexadecimal, 5: Hexadecimal to Binary, 6: Hexadecimal to Decimal): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // 2 -> 10 
                System.out.print("Enter a binary number: ");
                String binaryNumber = scanner.next();
                int decimalFromBinary = binaryToDecimal(binaryNumber);
                System.out.println("Decimal: " + decimalFromBinary);
                break;

            case 2:
                // 10 -> 2
                System.out.print("Enter a decimal number: ");
                int decimalNumber = scanner.nextInt();
                String binaryFromDecimal = decimalToBinary(decimalNumber);
                System.out.println("Binary: " + binaryFromDecimal);
                break;

            case 3:
                // 2 -> 16
                System.out.print("Enter a binary number: ");
                String binaryNumberForHex = scanner.next();
                String hexadecimalFromBinary = binaryToHexadecimal(binaryNumberForHex);
                System.out.println("Hexadecimal: " + hexadecimalFromBinary);
                break;

            case 4:
                // 10 -> 16
                System.out.print("Enter a decimal number: ");
                int decimalNumberForHex = scanner.nextInt();
                String hexadecimalFromDecimal = decimalToHexadecimal(decimalNumberForHex);
                System.out.println("Hexadecimal: " + hexadecimalFromDecimal);
                break;

            case 5:
                // 16 -> 2
                System.out.print("Enter a hexadecimal number: ");
                String hexadecimalNumberForBinary = scanner.next();
                String binaryFromHexadecimal = hexadecimalToBinary(hexadecimalNumberForBinary);
                System.out.println("Binary: " + binaryFromHexadecimal);
                break;

            case 6:
                // 16 -> 10
                System.out.print("Enter a hexadecimal number: ");
                String hexadecimalNumberForDecimal = scanner.next();
                int decimalFromHexadecimal = hexadecimalToDecimal(hexadecimalNumberForDecimal);
                System.out.println("Decimal: " + decimalFromHexadecimal);
                break;

            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
	 private static int binaryToDecimal(String binaryNumber) {
	        int decimalNumber = 0;
	        int power = 0;

	        // Iterate over each character of the binary number from right to left
	        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
	            
	            if (binaryNumber.charAt(i) == '1') {
	                
	                decimalNumber += Math.pow(2, power);
	            }

	            
	            power++;
	        }

	        return decimalNumber;
	    }

	    private static String decimalToBinary(int decimalNumber) {
	        StringBuilder binaryStringBuilder = new StringBuilder();

	        
	        while (decimalNumber > 0) {
	            
	            binaryStringBuilder.insert(0, decimalNumber % 2);
	            
	            decimalNumber = decimalNumber / 2;
	        }

	        if (binaryStringBuilder.length() == 0) {
	            return "0";
	        }

	        return binaryStringBuilder.toString();
	    }

	    private static String binaryToHexadecimal(String binaryNumber) {
	        
	        int decimalNumber = binaryToDecimal(binaryNumber);

	        
	        return Integer.toHexString(decimalNumber).toUpperCase();
	    }

	    private static String decimalToHexadecimal(int decimalNumber) {
	        return Integer.toHexString(decimalNumber).toUpperCase();
	    }

	    private static String hexadecimalToBinary(String hexadecimalNumber) {
	        
	        int decimalNumber = hexadecimalToDecimal(hexadecimalNumber);

	        return decimalToBinary(decimalNumber);
	    }

	    private static int hexadecimalToDecimal(String hexadecimalNumber) {
	        return Integer.parseInt(hexadecimalNumber, 16);
	    }
}
