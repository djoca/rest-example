package net.j33r.example.restapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@RequestMapping(path = "/calculation/add/result", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CalculationResult addResult(@RequestBody final CalculationParams vars) {
		return new CalculationResult(vars.getA(), vars.getB());
	}
}
