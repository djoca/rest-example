package net.j33r.example.restapi;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CalculationParamsDeserializer extends JsonDeserializer<CalculationParams> {

	@Override
	public CalculationParams deserialize(final JsonParser jsonParser, final DeserializationContext context)
			throws IOException, JsonProcessingException {

		final JsonNode node = getInitialNode(jsonParser);

		validateJson(jsonParser, node, "A");
		validateJson(jsonParser, node, "B");

		final Integer a = node.get("A").asInt();
		final Integer b = node.get("B").asInt();

		return new CalculationParams(a, b);
	}

	private JsonNode getInitialNode(final JsonParser jsonParser) throws IOException {
		final ObjectCodec objectCodec = jsonParser.getCodec();
		return objectCodec.readTree(jsonParser);
	}

	private void validateJson(JsonParser jsonParser, JsonNode node, String expectedParam) throws IOException {
		final JsonNode value = node.get(expectedParam);

		if (StringUtils.isEmpty(value)) {
			throw new JsonParseException(jsonParser,
					String.format("Invalid JSON: missing '%s' parameter.", expectedParam));
		}

		try {
			Integer.parseInt(value.asText());
		} catch (final NumberFormatException e) {
			throw new JsonParseException(jsonParser, String.format("Invalid value for parameter '%s'", expectedParam));
		}
	}

}
