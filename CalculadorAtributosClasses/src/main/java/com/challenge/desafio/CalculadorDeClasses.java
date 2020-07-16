package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object classe) {
        return this.calcular(classe, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object classe) {
        return this.calcular(classe, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object classe) {
        return somar(classe).subtract(subtrair(classe));
    }

    public BigDecimal calcular(Object classe, Class annotion) {
        BigDecimal resultado = BigDecimal.ZERO;

        try {
            Field[] campos = classe.getClass().getDeclaredFields();
            for (Field campo : campos) {
                if (campo.getType().equals(BigDecimal.class) && campo.isAnnotationPresent(annotion)) {
                    campo.setAccessible(true);
                    if (campo.get(classe) != null) resultado = resultado.add((BigDecimal) campo.get(classe));

                }
                else resultado = resultado.add(BigDecimal.ZERO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
