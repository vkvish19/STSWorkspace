package personal.vishu.in28minutes.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{
}
