package PP_3_1_2.Project2Boot.web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    // СМ уроки алишева 16.СпрингМВС,8:00 - для использования шаблонизатора Thymeleaf,
    private final ApplicationContext applicationContext;
    //Внедрение апликайшинКонтекст

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // Используем applicationContext для настройки Thymeleaf/
    // SetPrefix - фиксируем папку, где будут наши представления (html файлы)
    // SetSuffix - фиксируем расширение наших представлений (html файлы)
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        // добавим для корректного отображения кириллицы
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    // Бин TemplateEngine необх. для конфигурации представлений
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    // Метод configureViewResolvers передает в спринг, что хотим использовать шаблонизатор Thymeleaf
    // (именно для того, чтобы использовать Thymeleaf, вместо стандартного шаблонизатора)

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
        // добавим кодировку в Thymeleaf шаблонизатор, для корректного отображения кириллицы
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}