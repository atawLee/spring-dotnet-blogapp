namespace webapi.Repository;

public interface IBlogRepository
{
    public Task InsertPost(Post post);
}