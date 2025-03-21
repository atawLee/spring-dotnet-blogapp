package com.blog.webapi.config;

import com.blog.webapi.mapper.PostMapper;
import com.blog.webapi.repository.BlogRepository;
import com.blog.webapi.repository.MyBatisBlogRepositoryImpl;
import com.blog.webapi.service.BlogService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.ObjectFactory;




@Configuration
@MapperScan("com.blog.webapi.mapper")
public class AppConfig {

    public AppConfig() {
        // Constructor
    }

    @Bean
    @Scope("prototype")
    public BlogService blogService(ObjectFactory<BlogRepository> blogRepositoryFactory) {
        return new BlogService(blogRepositoryFactory.getObject());
    }

    @Bean
    @Scope("prototype")
    public BlogRepository BlogRepository(PostMapper postMapper) {
        return new MyBatisBlogRepositoryImpl(postMapper);
    }
}
