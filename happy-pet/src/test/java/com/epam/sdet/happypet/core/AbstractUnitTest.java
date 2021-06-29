package com.epam.sdet.happypet.core;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractUnitTest extends AbstractTest {

    protected static final Long ENTITY_STUB_ID = 1L;
    protected static final int DEFAULT_LIMIT = 5;
}
