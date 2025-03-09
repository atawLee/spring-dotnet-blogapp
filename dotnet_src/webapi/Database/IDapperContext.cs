using System.Data.Common;

namespace webapi.Database;

public interface IDapperContext : IDisposable
{
    public DbConnection GetConnection();

    Task<DbConnection> GetConnectionAsync();
}