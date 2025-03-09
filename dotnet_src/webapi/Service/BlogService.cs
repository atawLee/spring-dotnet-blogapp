using webapi.Repository;

namespace webapi.Service;

public class BlogService
{
    private readonly IBlogRepository _repository;

    public BlogService(IBlogRepository repository)
    {
        _repository = repository;
    }
    
    public async Task AddPost(Post post)
    {
        await _repository.InsertPost(post);
    }
}