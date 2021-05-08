package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

  private  CalcResult calcResult;

  @Before
    public void setup (){
      calcResult =  new CalcResult();
  }

  @Test
    public void testNetValue() {
       double result = calcResult.netValue(5000, 1000, 1);
       assertEquals(333.33,result);
  }

    private void assertEquals(double v, double result) {
    }

    @Test
    public void testInterest(){
      double result = calcResult.interest(333.33,0.07);
      assertEquals(23.34,result);
    }

    @Test
    public  void testMonthlyPaymrnt(){
      double result = calcResult.monthlyPayment(333.33,23.34);
      assertEquals(356.67,result);
    }


}


