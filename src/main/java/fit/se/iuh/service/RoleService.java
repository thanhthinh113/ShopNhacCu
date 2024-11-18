package fit.se.iuh.service;

import org.springframework.stereotype.Service;

import fit.se.iuh.model.Role;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService  {
    List<Role> getAllRole();
    Optional<Role> findRoleById(int id);

}
