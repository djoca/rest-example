package net.j33r.example.restapi;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonSerialize(using = CalculationResultSerializer.class)
public class CalculationResult {

	private final Integer a;
	private final Integer b;

	public Integer getResult() {
		return a + b;
	}
}
