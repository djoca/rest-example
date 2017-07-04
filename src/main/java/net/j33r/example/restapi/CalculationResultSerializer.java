package net.j33r.example.restapi;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CalculationResultSerializer extends JsonSerializer<CalculationResult> {

	@Override
	public void serialize(CalculationResult addResult, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("RESULTADO", addResult.getResult());
		generator.writeEndObject();
	}

}
