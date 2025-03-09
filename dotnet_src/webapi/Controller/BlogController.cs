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

    [HttpGet("/post")]
    public async Task AddPost(Post post)
    {
        await _service.AddPost(post);
    }
}