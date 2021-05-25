package com.dev.cicd.data.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Currency;
import com.github.javafaker.Faker;
import com.github.javafaker.Nation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class DataController
{

	@GetMapping("/")
	public String healthCheck()
	{
		return "HEALTH CHECK OK!";
	}

	@GetMapping("/version")
	public String version()
	{
		return "The actual version is 1.0.0";
	}

	@GetMapping("/nations")
	public JsonNode getRandomNations()
	{
		var objectMapper = new ObjectMapper();
		Faker faker = new Faker(new Locale("en-US"));
		ArrayNode nations = objectMapper.createArrayNode();
		for (int i = 0; i < 10; i++)
		{
			Nation nation = faker.nation();

			nations.add(objectMapper.createObjectNode()
					.put("nationality", nation.nationality())
					.put("capitalCity", nation.capitalCity())
					.put("flag", nation.flag())
					.put("language", nation.language()));
		}
		return nations;
	}

	@GetMapping("/currencies")
	public JsonNode getRandomCurrencies()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		Faker faker = new Faker(new Locale("en-US"));
		ArrayNode currencies = objectMapper.createArrayNode();
		for (int i = 0; i < 20; i++)
		{

			Currency currency = faker.currency();

			currencies.add(objectMapper.createObjectNode()
					.put("name", currency.name())
					.put("code", currency.code()));
		}
		return currencies;
	}

}
