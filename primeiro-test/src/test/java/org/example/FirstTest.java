package org.example;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstTest {

  Calculadora calculadora;
  Integer iterator = 0;

  @Before
  public void setup(){
    calculadora = new Calculadora();
    System.out.println("Setup configuration " + iterator);
  }

  @After
  public void after(){
    System.out.println("After configuration");
  }

  @Test
  public void deveSomarDoisNumeros() {
    // cenário
    int numberOne = 10;
    int numberTwo = 5;
    iterator =+ 1;

    // execução
    int result = calculadora.somar(numberOne, numberTwo);

    // verificações
    Assertions.assertThat(result)
        .isNotZero()
        .isPositive()
        .isBetween(14, 16);
  }

  @Test(expected = RuntimeException.class)
  public void naoDeveSomarNumerosNegativos(){
    // cenário
    int numberOne = -10;
    int numberTwo = 10;
    iterator++;

    // execução
    calculadora.somar(numberOne, numberTwo);
  }

  @Test
  public void deveSubtrairDoisNumeros(){
    // cenário
    int numberOne = 1;
    int numberTwo = 2;
    iterator++;

    // execução
    int resultSubtract = calculadora.subtrair(numberOne, numberTwo);

    // verificação
    Assertions.assertThat(resultSubtract)
        .isNegative()
        .isEqualTo(-1);
  }

  @Test
  public void deveMultiplicarDois(){
    // cenário
    final int numberOne = 1;
    final int numberTwo = 2;
    iterator++;

    // execução
    int resultOfMultiplication = calculadora.multiplicar(numberOne, numberTwo);

    // verificação
    Assertions.assertThat(resultOfMultiplication)
        .isPositive()
        .isNotZero()
        .isEqualTo(2);
  }

  @Test(expected = ArithmeticException.class)
  public void naoDeveMultiplicarUmNumeroPorZero(){
    // cenário
    int numberOne = 6;
    int numberTwo = 0;
    iterator++;

    // execução
    calculadora.multiplicar(numberOne, numberTwo);
  }

  @Test
  public void deveDividirUmNumeroPorZero(){
    // cenário
    int numberOne = 1;
    int numberTwo = 2;
    iterator++;

    // execução
    double resultOfDivision = calculadora.dividir(numberOne, numberTwo);

    // verificação
    Assertions.assertThat(resultOfDivision)
        .isEqualTo(0.5)
        .isNotZero();
  }

  @Test(expected = ArithmeticException.class)
  public void naoDeveDividirPorZero(){
    // cenário
    int numberOne = 10;
    int numberTwo = 0;
    iterator++;

    // execução
    calculadora.dividir(numberOne, numberTwo);
  }

}

class Calculadora {

  int somar(int numberOne, int numberTwo){
    if(numberOne < 0 || numberTwo < 0)
      throw new RuntimeException("Não é permitido soma de números negativos.");
    return numberOne + numberTwo;
  }

  int subtrair(int numberOne, int numberTwo){
    return numberOne - numberTwo;
  }

  int multiplicar(int numberOne, int numberTwo){
    if(numberTwo == 0)
      throw new ArithmeticException("Não é permitido a multiplicação por zero.");
    return numberOne * numberTwo;
  }

  double dividir(int numberOne, int numberTwo){
    if(numberTwo <= 0)
      throw new ArithmeticException("Não é permitido a divisão por zero.");
    return (double) numberOne / (double) numberTwo;
  }

}
