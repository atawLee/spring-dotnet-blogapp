namespace webapi.Query;

public static class PostQuery
{
    public static string GetPosts = @"
        SELECT * FROM Posts
    ";

    public static string GetPostById = @"
        SELECT * FROM Posts
        WHERE Id = @Id
    ";

    public static string CreatePost = @"
        INSERT INTO Posts (Title, Content)
        VALUES (@Title, @Content)
    ";

    public static string UpdatePost = @"
        UPDATE Posts
        SET Title = @Title, Content = @Content
        WHERE Id = @Id
    ";

    public static string DeletePost = @"
        DELETE FROM Posts
        WHERE Id = @Id
    ";
    
}