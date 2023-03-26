package com.udacity.jdnd.course3.critter.pet;

import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
public class PetDTO {
    private long id;
    private PetType type;
    private String name;
    private long ownerId;
    private LocalDate birthDate;
    private String notes;

    public PetDTO() {
    }

    public PetDTO(long id, PetType type, String name, long ownerId, LocalDate birthDate, String notes) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.ownerId = ownerId;
        this.birthDate = birthDate;
        this.notes = notes;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static PetDTOBuilder builder() {
        return new PetDTOBuilder();
    }

    public static class PetDTOBuilder {
        private long id;
        private PetType type;
        private String name;
        private long ownerId;
        private LocalDate birthDate;
        private String notes;

        public PetDTOBuilder id(long userId) {
            this.id = userId;
            return this;
        }

        public PetDTOBuilder type(PetType type) {
            this.type = type;
            return this;
        }

        public PetDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetDTOBuilder ownerId(long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public PetDTOBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PetDTOBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public PetDTO build() {
            return new PetDTO(id, type, name, ownerId, birthDate, notes);
        }
    }
}
