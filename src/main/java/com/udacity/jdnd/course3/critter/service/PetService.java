package com.udacity.jdnd.course3.critter.service;

import com.google.common.collect.Sets;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerService customerService;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getAllPetsById(Set<Long> ids) {
        return petRepository.findAllById(ids);
    }

    public Set<Long> getAllPetIdByIdSet(Set<Long> ids) {
        return getAllPetsById(ids).stream().map(Pet::getId).collect(Collectors.toSet());
    }

    public void validatePetsId(Set<Long> petIds) {
        Set<Long> savedPets = getAllPetIdByIdSet(petIds);
        HashSet<Long> result = Sets.newHashSet(petIds);
        result.removeAll(savedPets);
        if (!result.isEmpty()) {
            throw new PetNotFoundException(result);
        }
    }

    public void validatePets(Set<Long> petIds, List<String> validationErrors) {
        try {
            validatePetsId(petIds);
        } catch (PetNotFoundException e) {
            validationErrors.add(e.getMessage());
        }
    }

    public Pet getPetById(long petId) {
        return petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));
    }

    public List<Pet> getAllPetsByCustomerId(long customerId) {
        return petRepository.getAllPetsByCustomerId(customerId);
    }

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer = customerService.getCustomerByID(ownerId);
        pet.setCustomer(customer);
        Pet savedPet = petRepository.save(pet);
        ofNullable(customer.getPets()).ifPresentOrElse(pets -> pets.add(savedPet), () -> customer.setPets(Sets.newHashSet(savedPet)));
        customerService.saveCustomer(customer);

        return savedPet;
    }

    public void deletePetByID(long petId) {
        petRepository.deleteById(petId);
    }
}
