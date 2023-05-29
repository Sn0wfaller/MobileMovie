package com.infinity.movies.serviceimpl;


import com.infinity.movies.entity.Actor;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.entity.Role;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.RoleModel;
import com.infinity.movies.repository.ActorRepository;
import com.infinity.movies.repository.MovieRepository;
import com.infinity.movies.repository.RoleRepository;
import com.infinity.movies.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {


    private final ActorRepository actorRepository;
    private final RoleRepository roleRepository;
    private final MovieRepository movieRepository;

    @Override
    public Role getRoleById(Long id) {

        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Роли с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Role> getRoles() {

        return roleRepository.findAll();
    }

    @Override
    public Role addRole(RoleModel roleModel) {

        Actor actor = actorRepository.findById(roleModel.getActorId())
                .orElseThrow(() -> new ResourceNotFoundException("Актера с id =" + roleModel.getActorId() + " не существует."));

        Movie movie = movieRepository.findById(roleModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + roleModel.getMovieId() + " не существует."));

        Role role = Role.builder()
                .name(roleModel.getName())
                .actor(actor)
                .movie(movie)
                .build();

        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, RoleModel roleModel) {

        if (!roleRepository.existsById(id)){
            throw new ResourceNotFoundException("Роли с id = " + id + " не существует.");
        }

        Actor actor = actorRepository.findById(roleModel.getActorId())
                .orElseThrow(() -> new ResourceNotFoundException("Актера с id =" + roleModel.getActorId() + " не существует."));

        Movie movie = movieRepository.findById(roleModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + roleModel.getMovieId() + " не существует."));

        Role role = new Role(id, actor, movie, roleModel.getName());

        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {

        roleRepository.deleteById(id);
    }
}
