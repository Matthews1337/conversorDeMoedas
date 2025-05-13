package br.com.alura.conversor;

import java.util.Map;

public record Currency(Map<String, Double> conversion_rates) {}
