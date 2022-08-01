package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
// Quand il y a plusieurs aspects on peut vouloir spécifier l'ordre dans lequel
// ils soient appliqués aux programme. Pour cela on leur donne une annotation
// @Order(n), plus n est bas, plus l'aspect passe en priorité - les nombres négatifs sont
// permis, et ils ne sont pas obligés de se suivre. S'il y a deux aspects avec le même
// numéro @Order(6) ils vont être executés au hasard, mais toujours après 5 et avant 7.

	// 1. on rajoute un aspect en plus pour tester l'annotation @Order:
	// LogToCloudAsync()
	// 2. on va refacto les advices en les placant chacun dans leur propre fichier
	// aspect où on peut mettre l'annotation @Order.
	// 3. on va aussi créer un fichier où mettre les advice qu'on aimerait utiliser
	// un peu partout

	//// DECLARATIONS POINTCUT COMMUNS AUX ASPECTS
//	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//	private void forDaoPackage() {
//	}
//
//	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
//	private void getter() {
//	}
//
//	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
//	private void setter() {
//	}
//
//	@Pointcut("forDaoPackage() && !(getter() || setter())")
//	private void forDaoPackageNoGetterSetter() {
//	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----------> Executing @Before advice on addAccount()");
	}

	//// DESORMAIS DANS MyApiAnalytics.java
//	@Before("forDaoPackageNoGetterSetter()")
//	public void performApiAnalytics() {
//		System.out.println("\n----------> performing Api Analytics method");
//	}

	//// DESORMAIS DANS MyCloudLogAsyncAnalytics.java
//	@Before("forDaoPackageNoGetterSetter()")
//	public void logToCloudAsync() {
//		System.out.println("\n----------> logging to cloud in async fashion");
//	}

}
