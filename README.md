# spring-dotnet-blogapp
A simple web application implemented in both Spring Boot and .NET to compare their development experience.

### Dependency Injection 
In Spring, dependency injection (DI) is managed through beans.
You can define an AppConfig class annotated with @Configuration, where dependencies are explicitly registered in the container.
Alternatively, Spring provides annotations like @Service and @Repository, allowing dependencies to be automatically detected and injected by simply annotating the relevant classes.

On the other hand, .NET does not require such annotations because its DI system allows dependencies to be conveniently registered in a centralized way using AddSingleton, AddTransient, and AddScoped before the web application is built. Once registered, dependencies can be injected into constructors using their interfaces without additional configuration.

Since .NET's DI container handles dependency resolution explicitly, there is no need for additional annotations like @Service or @Repository. In contrast, Spring's annotation-based DI simplifies wiring dependencies at the class level but also introduces a level of coupling with the framework.

Both approaches have their own benefits:

Spring's annotation-based DI allows for implicit dependency registration but can lead to hidden dependencies.
.NET's centralized DI registration ensures all dependencies are declared upfront, making it easier to manage and reducing the risk of misconfigurations.
The choice between these approaches depends on how much control and visibility a team wants over dependency management.
#### Java Spring DI(@Configuration)

```java
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

#### C# ASP.NET CORE DI
```C#
var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<IDapperContext, PostgresDapperContext>();
builder.Services.AddTransient<IBlogRepository, DapperBlogRepository>();
builder.Services.AddTransient<BlogService>();

```

