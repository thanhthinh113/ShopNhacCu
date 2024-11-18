package fit.se.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.se.iuh.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
