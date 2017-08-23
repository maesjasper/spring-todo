package edu.ap.todoapp.repos;

import edu.ap.todoapp.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jasper on 23/08/2017.
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
