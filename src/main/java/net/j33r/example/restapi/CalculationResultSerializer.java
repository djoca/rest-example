package net.j33r.example.restapi;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Classe responsavel por serializar uma string JSON para um objeto do tipo
 * {@link CalculationResult}.
 *
 * @author Jose Antonio
 */
public class CalculationResultSerializer extends JsonSerializer<CalculationResult> {

	@Override
	public void serialize(CalculationResult calculationResult, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("RESULTADO", calculationResult.getResult());
		generator.writeEndObject();
	}

}
