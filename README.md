# **Contract Calculator**

## **Overview**

**Contract Calculator** is an Android application designed to help contractors quickly and easily calculate project costs, including labor and material costs, subtotal, tax, and total amount. This project is perfect for learning how to handle user input, shared preferences, and dialogs in Android development.

## **Features**

- **Labor and Material Cost Input**: Users can input labor and material costs.
- **Calculation**: Calculates the subtotal, tax, and total project cost.
- **Custom Tax Rate**: Allows users to set and save a custom tax rate using a dialog.
- **Persistent Data**: Utilizes shared preferences to save and retrieve the custom tax rate.

## **Technical Details**

- **SharedPreferences**: Stores the custom tax rate set by the user.
- **AlertDialog**: Prompts the user to input and save a custom tax rate.
- **Input Validation**: Checks for valid input in labor and material cost fields.
- **TextView**: Displays the calculated values for subtotal, tax, and total.

## **How It Works**

1. **User Input**:
    - The user inputs labor and material costs into `EditText` fields.
    - On clicking the calculate button, the app validates the input and performs the necessary calculations.

2. **Calculation**:
    - Calculates the subtotal as the sum of labor and material costs.
    - Applies a tax rate to the subtotal to calculate the tax amount.
    - Displays the subtotal, tax, and total amount in `TextView` fields.

3. **Custom Tax Rate**:
    - Users can set a custom tax rate by clicking the "Change Rate" button.
    - An `AlertDialog` prompts the user to input the new tax rate.
    - The new tax rate is saved using `SharedPreferences` and is applied in subsequent calculations.

## **Project Structure**

- **MainActivity**: Handles the main application logic, including user input, calculations, and managing shared preferences.
- **XML Layout**: Defines the user interface components like `EditText`, `Button`, and `TextView`.
