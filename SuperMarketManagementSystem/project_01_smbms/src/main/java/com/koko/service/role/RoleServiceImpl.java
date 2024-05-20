package com.koko.service.role;

import com.koko.dao.BaseDao;
import com.koko.dao.role.RoleDao;
import com.koko.dao.role.RoleDaoImpl;
import com.koko.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    //引入Dao
    private RoleDao roleDao;
    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }

    @Override
    //角色列表查询
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }

    @Test
    public void test(){
        RoleServiceImpl rs=new RoleServiceImpl();
        List<Role> rl=rs.getRoleList();
        for(Role role:rl){
            System.out.println(role.getRoleName());
        }
    }

}

