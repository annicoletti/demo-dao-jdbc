package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
  
    private Connection conn;
    
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn; 
    }

    @Override
    public void insert(Department obj) {
        
    }

    @Override
    public void update(Department obj) {
        
    }

    @Override
    public void deleteById(Integer id) {
        
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?;");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department department = new Department();
                department.setId( rs.getInt("Id") );
                department.setName( rs.getString("Name"));
                return department;
            }
            throw new DbException("No department founded");
        } 
        catch (SQLException e) {
            throw new DbException( e.getMessage() );
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM department ORDER BY Id ASC;");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Department( rs.getInt("Id"), rs.getString("Name")));
            }
            return list;
        } 
        catch (SQLException e) {
            throw new DbException( e.getMessage() );
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }  
}
