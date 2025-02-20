package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {
    @Test
    public void testGetPostsByAuthorAge() {
        Person author1 = new Person("1", "Rahul", "Tripathi", 28, "Male");
        Person author2 = new Person("2", "Xyz", "Abc", 32, "Female");
        BlogPost post1 = new BlogPost("1001", "1", "First content");
        BlogPost post2 = new BlogPost("1002", "2", "Second Content");
        Blog blog = new Blog(Arrays.asList(post1, post2), Arrays.asList(author1, author2));

        List<String> result = blog.getPostsByAuthorAge(28);
        assertEquals(1, result.size());
        assertEquals("1001", result.get(0));
    }
}
