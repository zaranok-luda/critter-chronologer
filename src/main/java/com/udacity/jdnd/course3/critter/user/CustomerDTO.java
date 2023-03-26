package com.udacity.jdnd.course3.critter.user;

import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
public class CustomerDTO {
    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(long id, String name, String phoneNumber, String notes, List<Long> petIds) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.petIds = petIds;
    }

    public static CustomerDTO.CustomerDTOBuilder builder() {
        return new CustomerDTO.CustomerDTOBuilder();
    }

    public static class CustomerDTOBuilder {
        private long id;
        private String name;
        private String phoneNumber;
        private String notes;
        private List<Long> petIds;

        public CustomerDTO.CustomerDTOBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder petIds(List<Long> petIds) {
            this.petIds = petIds;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(id, name, phoneNumber, notes, petIds);
        }
    }
}
