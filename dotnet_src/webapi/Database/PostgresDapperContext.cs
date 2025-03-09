using System.Data.Common;
using Npgsql;

namespace webapi.Database;

public class PostgresDapperContext : IDapperContext
{
    private readonly NpgsqlDataSource _dataSource;

    public PostgresDapperContext(string connectionString)
    {
        _dataSource = NpgsqlDataSource.Create(connectionString);
    }

    public DbConnection GetConnection() => _dataSource.OpenConnection();

    public async Task<DbConnection> GetConnectionAsync() => await _dataSource.OpenConnectionAsync();

    public void Dispose() => _dataSource.Dispose();
}