# 💼 PayrollCalculator Java Application

## 📘 Exercise 3 Overview

The **PayrollCalculator** is a Java console application designed to read employee payroll data from a `.csv` file and calculate gross pay for each employee. The application uses `BufferedReader` to read input, processes each line, and displays the payroll results in a formatted output.

---

## 📂 Project Structure

- **Main Class**: `Main`
- **Model Class**: `Employee`
- **Input File Format**: `id|name|hours-worked|pay-rate`
- **Example Data**:

---

## 🧱 Employee Class

The `Employee` class contains the following:

### 🔐 Attributes (Private)
- `employeeId` (int)
- `name` (String)
- `hoursWorked` (double)
- `payRate` (double)

### 🧮 Methods
- Parameterized constructor
- `getEmployeeId()`
- Getter/setter methods for all attributes
- `getGrossPay()` – returns the calculated gross pay (`hoursWorked * payRate`)

---

## 🚀 How It Works

1. The program reads the file using a `BufferedReader`.
2. Each line is split using the `|` delimiter.
3. The values are parsed and used to create an `Employee` object.
4. The program prints each employee's ID, name, and gross pay using `printf`.

---

## 📦 How to Run

1. Make sure you have Java installed.
2. Place your `.csv` file in the root directory (e.g., `employees.csv`).
3. Open a terminal or use an IDE like IntelliJ.
4. Compile and run the program:

 ```bash
 javac PayrollCalculator.java Employee.java
 java PayrollCalculator
