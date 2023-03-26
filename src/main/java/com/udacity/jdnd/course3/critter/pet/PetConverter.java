package com.udacity.jdnd.course3.critter.pet;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class PetConverter {
    public Pet petDTOToPet(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setPetType(petDTO.getType());
        pet.setName(petDTO.getName());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setNotes(petDTO.getNotes());
        return pet;
    }

    public PetDTO petToPetDTO(Pet pet) {
        return PetDTO.builder()
                .id(pet.getId())
                .type(pet.getPetType())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .notes(pet.getNotes())
                .ownerId(ofNullable(pet.getCustomer()).map(Customer::getId).orElse(-1L))
                .build();
    }

    public List<PetDTO> petListToPetDTOList(List<Pet> pets) {
        return pets.stream().map(this::petToPetDTO).toList();
    }
}