package com.epam.sdet.happypet.core;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
public abstract class AbstractDbTest extends AbstractTest {

}
