package org.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AppTest 
{
    App calculator = null;
    DummyService service = Mockito.mock(DummyService.class);

    @Before
    public void setUp() {
        calculator = new App(service);
    }

    @Test
    public void calTest() {
        when(service.solve(2,3)).thenReturn(5);
        //when(service.solve(2,3)).thenReturn(50);
        assertEquals("mockService working",(Integer) 5,calculator.mockService(2,3));
        verify(service).solve(2,3);     // to check whether mockService is getting called or not
    }

    @Test
    public void testAdd() {
        assertEquals("Addition working",(Integer) 150,calculator.add(100,50));
    }

    @Test
    public void testSubtract() {
        assertEquals("Subtraction working",(Integer) 100,calculator.sub(200,100));
    }

    @Test
    public void testMultiply() {
        assertEquals("Multiplication working",(Integer) 40,calculator.mul(20,2));
    }

    @Test
    public void testDivision() {
        assertEquals("Division working",(Integer) 0,calculator.div(0,20));
    }

    @Test(expected = ArithmeticException.class)
    public void outOfMemory() {
        calculator.mul(1234567899,1234567899);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.div(10,0);
    }

    @Test(expected = NullPointerException.class)
    public void addNullPointerException1() {
        calculator.add(null,50);
    }

    @Test(expected = NullPointerException.class)
    public void subNullPointerException1() {
        calculator.sub(null,50);
    }

    @Test(expected = NullPointerException.class)
    public void mulNullPointerException1() {
        calculator.mul(null,50);
    }

    @Test(expected = NullPointerException.class)
    public void divNullPointerException1() {
        calculator.div(null,50);
    }

    @Test(expected = NullPointerException.class)
    public void addNullPointerException2() {
        calculator.add(50,null);
    }

    @Test(expected = NullPointerException.class)
    public void subNullPointerException2() {
        calculator.sub(50,null);
    }

    @Test(expected = NullPointerException.class)
    public void mulNullPointerException2() {
        calculator.mul(50,null);
    }

    @Test(expected = NullPointerException.class)
    public void divNullPointerException2() {
        calculator.div(50,null);
    }
}
