package com.web.restourant.service;

import com.web.restourant.entity.Privilege;
import com.web.restourant.repository.PrivilegeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService extends CrudService<Privilege, PrivilegeRepository> {

    public PrivilegeService(PrivilegeRepository repository) {
        super(repository);
    }
}
