package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===teste seller findById===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		Department department = new Department(2, null);
		System.out.println("===teste seller findByDepartment===");
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}

		
	}

}
