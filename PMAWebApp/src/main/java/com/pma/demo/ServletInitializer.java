package com.pma.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pma.dataimporter.factories.PersonDataImportFactory;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        initFactories();
        return application.sources(DemoApplication.class);

    }

    private void initFactories() {
        PersonDataImportFactory.getInstance();
    }
}
