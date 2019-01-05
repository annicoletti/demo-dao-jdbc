package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        Department dep = new Department();
        
        System.out.println("=== TEST 1: department findById ===");
        System.out.print("Find department by id: ");
        int n = sc.nextInt(); 
        dep = departmentDao.findById(n);
        System.out.println(dep);
        
        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for(Department d : list){
            System.out.println(d);
        }   
        
        System.out.println("=== TEST 3: department deleteById ===");
        System.out.print("Find department by id to will delete: ");
        n = sc.nextInt(); 
        departmentDao.deleteById(n);
        System.out.println("Data deleted sussecfully!");
        
        System.out.println("=== TEST 4: department insert ===");
        System.out.print("Insert department's name: ");
        String s = sc.next(); 
        dep.setName(s);
        departmentDao.insert(dep);
        System.out.println("Data inserted sussecfully = " + dep.toString());
        
       
        sc.close();
        
    }
}
