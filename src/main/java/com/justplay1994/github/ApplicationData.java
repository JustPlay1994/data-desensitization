package com.justplay1994.github;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = {
//        "com.cetccity.operationcenter.webframework.*.dao",
//        "com.cetccity.operationcenter.webframework.core.chart.engine.mapper"
//})
public class ApplicationData extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(ApplicationData.class);
    }

    public static void main(String[] args)
    {
        new SpringApplicationBuilder(ApplicationData.class).web(true).run(args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {}
}


