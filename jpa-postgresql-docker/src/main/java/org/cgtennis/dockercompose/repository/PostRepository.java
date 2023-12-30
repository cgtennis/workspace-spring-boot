package org.cgtennis.dockercompose.repository;

import org.cgtennis.dockercompose.model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post,Integer> {
}
