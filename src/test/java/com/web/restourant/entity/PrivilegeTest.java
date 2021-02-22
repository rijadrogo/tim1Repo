package com.web.restourant.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class PrivilegeTest {

    @Test
    void testPrivilege() {
        Privilege privilege = new Privilege();
        privilege.setName("Admin");
        assertThat(privilege.getName()).isEqualTo("Admin");
    }

    @Test
    void testHashCode() {
        Privilege privilegeAdmin = new Privilege();
        privilegeAdmin.setName("Admin");

        Privilege privilegeUser = new Privilege();
        privilegeUser.setName("User");

        // Hash code hashes just id
        assertThat(privilegeAdmin.hashCode()).isNotEqualTo(privilegeUser.hashCode());
        assertThat(privilegeAdmin.hashCode()).isNotEqualTo(null);
        Privilege adminCopy = privilegeAdmin;
        assertThat(privilegeAdmin.hashCode()).isEqualTo(adminCopy.hashCode());

    }

    @Test
    void testEquality() {
        Privilege privilegeAdmin = new Privilege();
        privilegeAdmin.setName("Admin");

        Privilege privilegeUser = new Privilege();
        privilegeUser.setName("User");

        assertThat(privilegeAdmin.equals(privilegeUser)).isFalse();
        assertThat(privilegeAdmin.equals(null)).isFalse();
        Privilege adminCopy = privilegeAdmin;
        assertThat(privilegeAdmin.equals(adminCopy)).isTrue();

        Privilege newAdminCopy = new Privilege();
        newAdminCopy.setName("Admin");
        assertThat(privilegeAdmin.equals(newAdminCopy)).isTrue();
    }
}