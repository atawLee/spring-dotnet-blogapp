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
build.gradle dependencies에에 다음과 같이 추가합니다.
```
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0'
```
그리고 SwaggerConfig를 작성합니다. 
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
이제 /swagger-ui/index.html# 경로에서 스웨거를 사용할 수 있습니다.
문서파일은 /v3/api-docs  경로에서 확인 가능합니다.

#### C# asp.net core (.net 9)
.net9 이전버전에서는 프로젝트 생성시 open api와 스웨거ui 사용이 프로젝트 생성시 바로 지정할수 있으나 닷넷9버전에서는 open api를 사용시 스웨거는 별도로 받아야 합니다. 
csproj 파일이 있는 위치에서 다음 커맨드를 입력하거나 같은 이름의 swagger를 nuget을 통해서 설치합니다.
```
dotnet add package Swashbuckle.AspNetCore.SwaggerUI --version 7.3.1
```

그뒤에 program.cs에서 스웨거 사용 설정을 해줍니다. 
```
//program.cs 
var builder = WebApplication.CreateBuilder(args);
builder.Services.AddOpenApi();
//(생략)
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
위와 같이 지정합니다. open api의 api문서 자동생성 경로가 /openapi/v1.json 입니다. 경로는 직접 지정할 수 있습니다. 
이렇게하면 /swagger/index.html 에서 스웨거 페이지를 확인 할 수 있습니다.




