package br.anhembi;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTest {
    
    //what_When_Than
    //Should_When

    @Test
    void shouldReturnIntValue_whenTwoValidNumbers() {
        // preparação
        Calculadora calc = new Calculadora();
        int value1 = 1, value2 = 2;
        int expectedValue = 3;

        // ação
        int resposta = calc.soma(value1,value2);

        // verificação
        Assertions.assertThat(resposta).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"1,2,2" , "2,1,2"})
    void shouldReturnSecondNumberValue_whenSecondNumberBigger(int value1, int value2, int expectedValue) {
        // preparação
        Calculadora calc = new Calculadora();

        int resp = calc.maior(value1, value2);

        Assertions.assertThat(resp).isEqualTo(expectedValue);
    }

    @Test
    void shouldThrowsException_whenTextoInvalid() {
        Calculadora calc = new Calculadora();
        String texto = "123A";

        Assertions.assertThatThrownBy( ()->{
            calc.converte(texto);
        });

    }

}
