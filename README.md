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
builder.Services.AddOpenApi();
builder.Services.AddControllers();
builder.Services.AddSingleton<IDapperContext>(() =>
{
    var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
    return new PostgresDapperContext(connectionString);
});
builder.Services.AddTransient<IBlogRepository, DapperBlogRepository>();
builder.Services.AddTransient<BlogService>();

var app = builder.Build();
```

### OpenAPI & Swagger UI 
Both Spring Boot and .NET provide built-in support for OpenAPI documentation via libraries that generate and expose API specifications. Swagger UI is commonly used to visualize and interact with APIs in both ecosystems.

#### Spring boot 
Add the following dependency to build.gradle:
```
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0'
```
Then, create the SwaggerConfig class:
```
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .version("1.0.0");
    }
}
```
Now, Swagger UI can be accessed at:
📌 /swagger-ui/index.html#

The API documentation can be found at:
📌 /v3/api-docs


#### C# asp.net core (.net 9)
In versions prior to .NET 9, OpenAPI and Swagger UI could be enabled during project creation. However, in .NET 9, when using OpenAPI, Swagger must be installed separately.

Run the following command in the project directory (where the .csproj file is located) or install the package via NuGet:
```
dotnet add package Swashbuckle.AspNetCore.SwaggerUI --version 7.3.1
```

그뒤에 program.cs에서 스웨거 사용 설정을 해줍니다. 
```
//program.cs 
var builder = WebApplication.CreateBuilder(args);
builder.Services.AddOpenApi();
// (omitted code)
app.build();
app.MapControllers();
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
    app.UseSwaggerUI(x =>
    {
        x.SwaggerEndpoint("/openapi/v1.json","V1 API");
    });
}
```
The OpenAPI documentation is automatically generated at:
📌 /openapi/v1.json

The endpoint can be customized as needed.

Now, the Swagger UI page can be accessed at:
📌 /swagger/index.html


