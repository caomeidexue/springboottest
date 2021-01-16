package com.jiang.localspringbootdemo.config.thymeleafproperties;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-15 14:34
 */
//@Configuration
public class TemplateResolverConfig {
   /* @Bean
    public TemplateResolver fileTemplateResolver(ThymeleafProperties properties) {
       // FileTemplateResolver resolver = new FileTemplateResolver();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
        resolver.setCacheable(properties.isCache());
        resolver.setSuffix(properties.getSuffix());
        if (properties.getEncoding() != null) {
            resolver.setCharacterEncoding(properties.getEncoding().name());
        }
        resolver.setTemplateMode(properties.getMode());
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        return resolver;
    }


    @Bean
    public TemplateEngine templateEngine(TemplateResolver templateResolver) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ThymeleafProperties getThymeleafProperties(){
        ThymeleafProperties properties = new ThymeleafProperties();
        properties.setPrefix("templates/");
        properties.setSuffix(".html");
        properties.setMode("HTML5");
        return properties;
    }
*/



}
