import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NationalCodeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your National Code: ");
        String nationalCode = scanner.nextLine();

        if (!isNumeric(nationalCode)) {
            System.out.println("Please enter a number!");
        } else if (nationalCode.isEmpty()) {
            System.out.println("Please write a code!");
        } else if (nationalCode.length() < 10) {
            System.out.println("Your entered code is less than 10!");
        } else {
            int yy = 0;

            for (int i = 0; i < nationalCode.length(); i++) {
                int digit = Character.getNumericValue(nationalCode.charAt(i));
                yy += digit * (nationalCode.length() - i);
            }

            int x = yy % 11;
            if (x == 0) {
                System.out.println("Your code is valid!");
            } else {
                System.out.println("Your code is invalid!");
            }

            // Use the API to process a number
            String apiResponse = callApi(nationalCode);
            System.out.println("API Response: " + apiResponse);
        }

        scanner.close();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String callApi(String number) {
        String apiUrl = "https://api.codebazan.ir/adad/?text=" + number;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return result.toString();
    }
}

