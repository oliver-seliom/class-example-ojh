def add(x, y):
    pass  # Group 1 will implement this

def subtract(x, y):
    pass  # Group 2 will implement this

def multiply(x, y):
    pass  # Group 3 will implement this

def divide(x, y):
    pass  # Group 4 will implement this

def main():
    print("Welcome to the Calculator")

    operation = input("Enter operation (+, -, *, /): ")
    num1 = float(input("Enter first number: "))
    num2 = float(input("Enter second number: "))

    if operation == '+':
        print(f"Result: {add(num1, num2)}")
    elif operation == '-':
        print(f"Result: {subtract(num1, num2)}")
    elif operation == '*':
        print(f"Result: {multiply(num1, num2)}")
    elif operation == '/':
        print(f"Result: {divide(num1, num2)}")
    else:
        print("Invalid operation")

if __name__ == "__main__":
    main()
