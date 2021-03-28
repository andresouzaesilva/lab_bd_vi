package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.Calculadora;

public class CalculadoraTest{
	
	@Test
	public void porcentagemTest(){
        Calculadora calc = new Calculadora();
		double resultado = calc.porcentagem(100,10);
		assertEquals(110, resultado);
	}

}
