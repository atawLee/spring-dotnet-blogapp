# spring-dotnet-blogapp
A simple web application implemented in both Spring Boot and .NET to compare their development experience.

### Dependency Injection 
In Spring, dependency injection (DI) is managed through beans.
You can define an AppConfig class annotated with @Configuration, where dependencies are explicitly registered in the container.
However, Spring also provides annotations like @Service and @Repository, allowing dependencies to be automatically detected and injected by simply annotating the relevant classes.

In contrast, C# requires explicitly registering necessary classes in the DI container before the web application is built, using methods like AddSingleton, AddTransient, and AddScoped. Once registered, dependencies can be injected into constructors using their interfaces without additional configuration.

Initially, I was skeptical about the necessity of @Service and @Repository annotations in Spring, as I generally prefer to avoid framework-specific dependencies.
However, after implementing DI in Spring, I realized that manually configuring dependencies via @Configuration increases the risk of errors and adds unnecessary complexity.
Compared to .NET’s explicit DI registration approach, Spring’s annotation-based DI helps reduce development overhead, making it a more practical choice—even at the cost of tighter coupling with the framework.

```java
//configuration style 
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
```

```C#
var builder = WebApplication.CreateBuilder(args);

builder.Services.AddScoped<IBlogRepository, BlogRepository>();
builder.Services.AddScoped<BlogService>();

var app = builder.Build();
app.Run();
```

