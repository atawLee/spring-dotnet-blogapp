namespace webapi.Repository;

public class Comment
{
    public int Id { get; set; }
    public int? UserId { get; set; } // ON DELETE SET NULL 대응
    public int PostId { get; set; }
    public string Content { get; set; } = string.Empty;
    public DateTime CreatedAt { get; set; }
}