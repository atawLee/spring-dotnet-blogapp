using Microsoft.AspNetCore.Mvc;
using webapi.Database;
using webapi.Repository;
using webapi.Service;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddOpenApi();
builder.Services.AddControllers();
builder.Services.AddSingleton<IDapperContext>((x) =>
{
    var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
    return new PostgresDapperContext(connectionString);
});
builder.Services.AddTransient<IBlogRepository, DapperBlogRepository>();
builder.Services.AddTransient<BlogService>();
builder.Services.AddTransient<AuthService>();
var app = builder.Build();

app.MapPost("/post", async (Post post,[FromServices] BlogService service) =>
{
    await service.AddPost(post);
    return Results.Ok();
});

app.MapGet("/post", async (BlogService service) =>
{
    var result = await service.GetPosts();
    return Results.Ok(result);
});

app.Run();