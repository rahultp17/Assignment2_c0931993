package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {

    @Test
    void shouldCreateValidBlogPost() {
        BlogPost blogPost = BlogPost.builder()
                .id("blog1")
                .authorId("117")
                .postContent("Hello....blog post")
                .build();

        assertNotNull(blogPost);
        assertEquals("blog1", blogPost.getId());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .authorId("117")
                    .postContent("Hello....blog post")
                    .build();
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }
}

