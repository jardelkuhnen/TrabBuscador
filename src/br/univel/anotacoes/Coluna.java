package br.univel.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Coluna {

	String nome() default "";

	boolean pk() default false;

	int posicao() default 0;

	String value() default "";

}
