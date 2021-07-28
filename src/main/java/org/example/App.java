package org.example;

public class App
{
    DummyService service;

    public App(DummyService service) {
        this.service = service;
    }

    public Integer mockService(Integer num1, Integer num2) {
        return service.solve(num1,num2);
    }

    public static Integer add(Integer num1, Integer num2) {
        return (num1 + num2);
    }

    public static Integer sub(Integer num1, Integer num2) {
        return (num1 - num2);
    }

    public static Integer mul(Integer num1, Integer num2) {
        // when overflow occurs due to multiplication i.e., when we multiply 2 large numbers
        if(num1 != 0 && (num2 > Integer.MAX_VALUE / num1)) {
            throw new ArithmeticException("Exceeded the maximum limit");
        }
        return (num1 * num2);
    }

    public static Integer div(Integer num1, Integer num2) {
        if(num2 == 0){
            throw new ArithmeticException("Division by Zero!!");
        }
        return (num1 / num2);
    }
}
