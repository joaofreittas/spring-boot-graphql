package com.home.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.home.graphql.input.PetInput;
import com.home.graphql.model.Person;
import com.home.graphql.model.Pet;
import com.home.graphql.repository.PersonRepository;
import com.home.graphql.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private PetRepository repository;
    private PersonRepository personRepository;

    public Collection<Pet> findAllPets(){
        return repository.findAll();
    }

    public Pet savePet(PetInput petInput) {
        Person person = personRepository.findById(petInput.getOwnerId()).get();
        return repository.save(
                new Pet(
                        petInput.getName(),
                        person
                )
        );
    }
}
