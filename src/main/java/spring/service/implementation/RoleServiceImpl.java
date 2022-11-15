package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.RoleDao;
import spring.model.Role;
import spring.service.RoleService;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void insertRole(Role role) {
        roleDao.insertRole(role);

    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);

    }

    @Override
    public void deleteRole(int roleId) throws SQLException {
        roleDao.deleteRole(roleId);

    }

    @Override
    public Role getRoleById(int roleId) throws SQLException {
        return roleDao.getRoleById(roleId);
    }
}
