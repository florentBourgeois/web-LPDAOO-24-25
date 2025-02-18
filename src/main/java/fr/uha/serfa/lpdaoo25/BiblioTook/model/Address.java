package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import jakarta.persistence.Embeddable;
import org.antlr.v4.runtime.misc.NotNull;

@Embeddable
public class Address {
    @NotNull
    private String addressLine1;

    @NotNull
    private String addressLine2;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;

    public Address() {

    }

    public Address(String addressLine1, String addressLine2, String city,
                   String state, String country, String zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    // Getters and Setters (Omitted for brevity)
}