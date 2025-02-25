# National Code Checker

## Overview

This Java program verifies the validity of a national code and uses an API to process the entered number. It checks the format of the input, calculates a checksum for validation, and integrates with the [CodeBazan API](https://api.codebazan.ir/adad/?text=255) to fetch additional data related to the input.

## Features

- Validates if the input is a numeric string.
- Ensures the input length is exactly 10 characters.
- Calculates a checksum to verify the national code's validity.
- Makes an HTTP GET request to an external API for additional processing.

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher).
- Internet connection to access the API.

## How to Run

1. Clone or download this repository.
2. Open the project in your preferred Java IDE or use the terminal.
3. Compile the code using the following command:
   ```
   javac NationalCodeChecker.java
   ```
4. Run the program using:
   ```
   java NationalCodeChecker
   ```
5. Enter a 10-digit national code when prompted.

## Example

### Input:

```
Enter Your National Code: 1234567890
```

### Output:

```
Your code is valid!
```

## Code Breakdown

### Input Validation:

- Ensures the input is numeric.
- Checks if the length of the national code is exactly 10 characters.

### Checksum Calculation:

- Multiplies each digit by a weight based on its position.
- Calculates the modulo of the sum by 11 to determine validity.

### API Integration:

- Sends the national code to the API endpoint: `https://api.codebazan.ir/adad/?text=<number>`.
- Displays the API response to the user.

## API Details

The program uses the CodeBazan API to process the input number. Refer to the [API documentation](https://api.codebazan.ir) for more information.

## Error Handling

- Handles invalid inputs (non-numeric or incorrect length).
- Catches exceptions during API requests and displays an appropriate error message.

## License

This project is licensed under the MIT License. Feel free to use and modify it as needed.

