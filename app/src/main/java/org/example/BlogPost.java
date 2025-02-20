package org.example;

//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
//@JsonDeserialize(builder = BlogPost.BlogPostBuilder.class)
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    // Validate input in builder
    public static class BlogPostBuilder {
        public BlogPost build() {
            if (id == null) throw new IllegalArgumentException("ID cannot be null");
            if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null");
            return new BlogPost(id, authorId, postContent);
        }
    }
}