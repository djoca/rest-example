package net.j33r.example.restapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.j33r.example.calculation.Calculator;

/**
 * Classe responsavel pelo mapeamento da API REST e atendimento as requisicoes
 * HTTP.
 *
 * @author Jose Antonio
 */
@RestController
@AllArgsConstructor
public class CalculatorController {

	private final Calculator calculator;

	/**
	 * Calcula a soma de dois numeros inteiros.
	 *
	 * @param vars
	 *            um objeto do tipo {@link CalculationParams} contendo os
	 *            numeros a serem somados.
	 * @return um objeto do tipo {@link CalculationResult} contendo o resultado
	 *         da soma
	 */
	@RequestMapping(path = "/calculation/add/result", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CalculationResult addResult(@RequestBody final CalculationParams vars) {
		final Integer result = calculator.add(vars.getA(), vars.getB());
		return new CalculationResult(result);
	}
}
