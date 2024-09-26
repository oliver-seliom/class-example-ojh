def add(x, y):
    res = x + y
    return res


def subtract(x, y):
    res = x - y
    return res


def multiply(x, y):
    res = x * y
    return res


def divide(x, y):
    res = x / y
    return res


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
