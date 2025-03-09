using webapi.Database;
using webapi.Repository;
using webapi.Service;

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
app.MapControllers();

if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.Run();