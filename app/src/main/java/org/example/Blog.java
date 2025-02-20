package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;
    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> {
                    Person author = contributors.stream()
                            .filter(person -> person.getId().equals(post.getAuthorId()))
                            .findFirst()
                            .orElse(null);
                    return author != null && author.getAge().equals(age);
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}