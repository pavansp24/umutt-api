package org.umutt.dto;


/**
 * Created by Gokul Kulkarni on 10/10/17.
 */

public class DonorCreationRequest {

    private RegistrationDto donor;

    public RegistrationDto getDonor() {
        return donor;
    }

    public void setDonor(RegistrationDto donor) {
        this.donor = donor;
    }
}
