package personal.vishu.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.Post;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.User;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.exception.UserNotCreatedException;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.repository.PostRepository;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.repository.UserRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJpaController
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        List<User> users = userRepository.findAll();
        if(users==null || users.size()==0)
            throw new UserNotFoundException("No Users Found in the database...");
        return users;
    }

    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new UserNotFoundException("No User Found for ID=" +id);
        }

        //HATEOAS
        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
    {
        User savedUser = userRepository.save(user);
        if(savedUser == null)
        {
            throw new UserNotCreatedException("Unable to create user :: " +user);
        }

        //below code fetches and return the URI for the newly created user.
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
//        if(user == null)
//        {
//            throw new UserNotFoundException("No User Found for ID=" +id);
//        }
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable Integer id)
    {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("No User Found for ID=" +id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer id, @RequestBody Post post)
    {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("No User Found for ID=" +id);
        }

        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);

        //below code fetches and return the URI for the newly created user.
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
