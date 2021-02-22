package com.web.restourant.contoller;

import com.web.restourant.entity.Privilege;
import com.web.restourant.service.PrivilegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    private final String PRIVILEGE_DELETED = "Privilege deleted";
    private final String PRIVILEGE_NOT_FOUND = "Privilege not found";

    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @GetMapping
    List<Privilege> getPrivileges() {
        return privilegeService.findAll();
    }

    @PostMapping
    ResponseEntity<Privilege> addMerchantProvider(@RequestBody Privilege privilege) {
        Privilege privilegeSaved = privilegeService.save(privilege);
        return ResponseEntity.status(HttpStatus.CREATED).body(privilegeSaved);
    }

    @DeleteMapping("/{privilegeId}")
    ResponseEntity<String> deletePrivilege(@PathVariable String privilegeId) throws RuntimeException {
        Optional<Privilege> privilege = privilegeService.findById(privilegeId);
        if(privilege.isPresent()){
            privilegeService.delete(privilege.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(PRIVILEGE_DELETED);
        }
        throw new RuntimeException(PRIVILEGE_NOT_FOUND);
    }

}
