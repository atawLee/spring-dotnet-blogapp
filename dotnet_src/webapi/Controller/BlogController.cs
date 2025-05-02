using Microsoft.AspNetCore.Mvc;
using webapi.Repository;
using webapi.Service;

namespace webapi.Controller;

[ApiController]
[Route("[controller]")]
public class BlogController :ControllerBase 
{
    private readonly BlogService _service;

    public BlogController(BlogService service)
    {
        _service = service;
    }

    [HttpPost("/post")]
    public async Task AddPost(Post post)
    {
        await _service.AddPost(post);
    }

    [HttpPost("/post")]
    public async Task<PostPostDetailResponseDto> GetPosts()
    {
        return await _service.GetPosts();
    }
}

public class PostPostDetailResponseDto
{
}