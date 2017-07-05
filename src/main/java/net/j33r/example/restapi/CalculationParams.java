package net.j33r.example.restapi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe {@link CalculationParams} contem os valores utilizados para o
 * calculo
 *
 * @author Jose Antonio
 */
@Getter
@AllArgsConstructor
@JsonDeserialize(using = CalculationParamsDeserializer.class)
public class CalculationParams {

	private final Integer a;
	private final Integer b;

}
