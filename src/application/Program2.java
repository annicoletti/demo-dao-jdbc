package application;

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
        
        sc.close();
        
    }
}
