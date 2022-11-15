package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.RoleDao;
import spring.dao.repository.RoleRepository;
import spring.model.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Autowired
    RoleRepository roleRepository;

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void insertRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void deleteRole(int roleId) throws SQLException {
        roleRepository.deleteById(roleId);

    }

    @Override
    public Role getRoleById(int roleId) throws SQLException {
        return roleRepository.findById(roleId).get();
    }
}
