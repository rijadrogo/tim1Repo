package com.web.restourant.service;

import com.web.restourant.entity.Privilege;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestPropertySource(locations = "/test.properties")
class PrivilegeServiceTest {

    @Autowired
    private PrivilegeService privilegeService;

    @Test
    public void testSavePrivilege() {
        Privilege privilege = new Privilege();
        privilege.setName("Admin");

        // Save privilege
        privilegeService.save(privilege);

        // retrieve privilege
        Optional<Privilege> orderEntityOptional = privilegeService.findById(privilege.getId());

        // check result
        assertThat(orderEntityOptional.isPresent()).isTrue();
        assertThat(orderEntityOptional.get().getId().equals(privilege.getId())).isTrue();

        // update privilege
        orderEntityOptional.get().setName("User");

        // save privilege
        privilegeService.save(orderEntityOptional.get());

        // retrieve privilege
        orderEntityOptional = privilegeService.findById(privilege.getId());

        //check result
        assertThat(orderEntityOptional.isPresent()).isTrue();
        assertThat(orderEntityOptional.get().getName()).isEqualTo("User");

        // delete privilege
        privilegeService.delete(orderEntityOptional.get());

        // check is deleted
        orderEntityOptional = privilegeService.findById(privilege.getId());
        assertThat(orderEntityOptional.isPresent()).isFalse();
    }
}