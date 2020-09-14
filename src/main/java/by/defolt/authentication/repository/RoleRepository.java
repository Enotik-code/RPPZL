package by.defolt.authentication.repository;


import by.defolt.authentication.bean.Role;
import by.defolt.authentication.bean.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(UserRoles role);
}

