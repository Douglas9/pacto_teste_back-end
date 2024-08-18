package com.pactoteste.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final Pattern PADRAO_EMAIL = Pattern.compile(EMAIL_REGEX);

	private static final String TELEFONE_REGEX = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";
	private static final Pattern PADRAO_TELEFONE = Pattern.compile(TELEFONE_REGEX);
    private static final String FORMATO_DATA = "dd/MM/yyyy";

	public static boolean validaCpf(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");

		if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}

		int firstCheckDigit = 11 - (sum % 11);
		if (firstCheckDigit >= 10) {
			firstCheckDigit = 0;
		}

		if (firstCheckDigit != Character.getNumericValue(cpf.charAt(9))) {
			return false;
		}

		sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}

		int secondCheckDigit = 11 - (sum % 11);
		if (secondCheckDigit >= 10) {
			secondCheckDigit = 0;
		}

		return secondCheckDigit == Character.getNumericValue(cpf.charAt(10));

	}

	public static boolean validaEmail(String email) {
		Matcher matcher = PADRAO_EMAIL.matcher(email);
		return matcher.matches();
	}

	public static boolean validaTelefone(String telefone) {
		Matcher matcher = PADRAO_TELEFONE.matcher(telefone);
		return matcher.matches();

	}
	
    public static boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_DATA);
        sdf.setLenient(false); 

        try {
            sdf.parse(data);
            return true; 
        } catch (ParseException e) {
            return false; 
        }
    }

}
