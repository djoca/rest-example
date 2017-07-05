package net.j33r.example.restapi;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe {@link CalculationResult} contem o resultado do calculo.
 *
 * @author Jose Antonio
 */
@Getter
@AllArgsConstructor
@JsonSerialize(using = CalculationResultSerializer.class)
public class CalculationResult {

	private final Integer result;
}
