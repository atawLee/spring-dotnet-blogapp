using webapi.Core;

namespace webapi.Repository;

public interface IAuthRepository
{
    public Task RegisterUser(User user);
    
    public Task<User> GetUserById(int id);
    
    public Task<User> GetUserByIdPassword(string id, string password);
}