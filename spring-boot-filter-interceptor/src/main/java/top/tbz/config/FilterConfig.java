package top.tbz.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.tbz.filter.MyFilter;
import top.tbz.filter.YourFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean(){
        FilterRegistrationBean<MyFilter> registrationBean=new FilterRegistrationBean<>();;
        registrationBean.setFilter(new MyFilter());
        //设置拦截的URL
        registrationBean.addUrlPatterns("/test");
        //设置过滤器的顺序
//        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<YourFilter> yourFilterFilterRegistrationBean(){
        FilterRegistrationBean<YourFilter> registrationBean=new FilterRegistrationBean<>();;
        registrationBean.setFilter(new YourFilter());
        //设置拦截的URL
        registrationBean.addUrlPatterns("/test");
        //设置过滤器的顺序
//        registrationBean.setOrder(1);
        return registrationBean;
    }


}
