using System.Data;
using Dapper;
using Npgsql;
using webapi.Database;
using webapi.Query;

namespace webapi.Repository;

public class DapperBlogRepository : IBlogRepository
{
    private readonly IDapperContext _dbContext;

    public DapperBlogRepository(IDapperContext dbContext)
    {
        _dbContext = dbContext;
    }

    public async Task InsertPost(Post post)
    {
        await using var db = await _dbContext.GetConnectionAsync();
        await db.ExecuteScalarAsync(PostQuery.CreatePost, post);
    }
}