package services;

import com.sk.petclinic.model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {
    Owner findByLastName(String lastName);

}
