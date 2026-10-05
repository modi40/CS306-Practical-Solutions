class MyNumber {
    private int number;

    MyNumber() {
        number = 0;
    }

    MyNumber(int value) {
        number = value;
    }

    boolean isNegative() {
        return number < 0;
    }

    boolean isPositive() {
        return number > 0;
    }

    boolean isOdd() {
        return number % 2 != 0;
    }

    boolean isEven() {
        return number % 2 == 0;
    }

    int getValue() {
        return number;
    }
}

class Main {
    public static void main(String[] args) {
        int inputVal = 25;
        if (args.length > 0) {
            inputVal = Integer.parseInt(args[0]);
        }
        MyNumber obj = new MyNumber(inputVal);
        System.out.println("Number: " + obj.getValue());
        System.out.println("isNegative: " + obj.isNegative());
        System.out.println("isPositive: " + obj.isPositive());
        System.out.println("isOdd: " + obj.isOdd());
        System.out.println("isEven: " + obj.isEven());
    }
}
