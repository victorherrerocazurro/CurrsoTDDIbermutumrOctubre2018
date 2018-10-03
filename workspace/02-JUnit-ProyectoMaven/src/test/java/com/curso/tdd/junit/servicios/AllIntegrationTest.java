package com.curso.tdd.junit.servicios;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ServicioBasicoErroresControladosIT.class, ServicioBasicoIT.class })
public class AllIntegrationTest {

}
