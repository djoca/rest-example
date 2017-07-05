package net.j33r.example.calculation;

import org.springframework.stereotype.Service;

/**
 * Classe responsavel pelo servico de calculo.
 *
 * @author Jose Antonio
 */
@Service
public class Calculator {

	/**
	 * Soma os valores de a e b
	 *
	 * @param a
	 *            um numero inteiro
	 * @param b
	 *            outro numero inteiro
	 * @return a soma dos valores a e b
	 */
	public Integer add(final Integer a, final Integer b) {
		return a + b;
	}
}
