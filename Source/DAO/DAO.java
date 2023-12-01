package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBcontext;
import entity.Account;
import entity.Category;
import entity.Item;
import entity.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

//////////////////////////////////////////////////////////
//////////////// SAN PHAM////////////////////////////////
//	 Them san Pham
	public void addProduct(String name, String image, String price, String title, String description, String cateID,
			int uid) {
		String query = "insert into dbo.product values (?,?,?,?,?,?,?) ";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, cateID);
			ps.setInt(7, uid);
			ps.executeUpdate();// thuc thi lenh query
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from dbo.product ";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getNString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// Lay san pham theo Category
	public List<Product> getAllProductByCid(String cateId) {
		List<Product> listCid = new ArrayList<>();
		String query = "select * from dbo.product where cateId=?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, cateId);// gan cateId vao cau lenh query
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				listCid.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getNString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCid;
	}

	public Product getProductById(String id) {
		List<Product> listId = new ArrayList<>();
		String query = "select * from dbo.product where id=?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, id);// gan cateId vao cau lenh query
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				return new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getNString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Tim Kiem
	public List<Product> SearchProductByName(String name) {
		List<Product> listSearch = new ArrayList<>();
		String query = "select * from dbo.product where [name] like ?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, "%" + name + "%");// gan cateId vao cau lenh query
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				listSearch.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getNString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSearch;
	}

	// Hien thi san pham theo seller
	public List<Product> ProductBySellId(int sid) {
		List<Product> list = new ArrayList<>();
		String query = "select * from dbo.product where sellID = ?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setInt(1, sid);
			;// gan sellId vao cau lenh query
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getNString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// Xoa San Pham
	public void deleteProduct(String id) {
		String query = "DELETE FROM dbo.product WHERE id = ?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, id);
			;// gan sellId vao cau lenh query
			ps.executeUpdate();// lay ket qua
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// edit san pham
	public void editProduct(String name, String image, String price, String title, String description, String cateID,
			int uid, int id) {
		String query = "UPDATE dbo.product\r\n"
				+ "SET name = ?, image=?,price=?,title=?,description=?,cateID=?,sellID=?\r\n" + "WHERE [id] = ?;";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, cateID);
			ps.setInt(7, uid);
			ps.setInt(8, id);
			ps.executeUpdate();// thuc thi lenh query
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// San Pham Moi Nhat
	public Product getLast() {
		String query = "select top 1 * from dbo.product order by id desc";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				return new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getNString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Phan Trang product
	public List<Product> Paging(int index) {
		List<Product> list = new ArrayList<>();
		String query = "with x as (select ROW_NUMBER() over (order by id desc) as r, * from dbo.product) select * from x where r between 9*? -8 and 9*?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setInt(1, index);
			ps.setInt(2, index);
			rs = ps.executeQuery();// lay ket qua

			while (rs.next()) {
				list.add(new Product(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getNString(6), rs.getString(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public int Page_Count() {
		String query = "SELECT COUNT(id)\r\n" + "FROM dbo.product";
		int s;
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return s = (rs.getInt(1))/9+1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

//////////////////////////////////////////////////////////
////////////////TAI KHOAN////////////////////////////////
	public List<Category> getAllCategory() {
		List<Category> listC = new ArrayList<>();
		String query = "select * from dbo.Category ";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				listC.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listC;
	}

//Dang nhap
	public Account getaccount(String user, String pass) {
		String query = "select * from dbo.Account where [user]=? and pass=?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Dang ky tai khoan
	public Account Signup(String user, String pass) {
		String query = "INSERT INTO dbo.Account\r\n" + "VALUES (?, ?, 0,0);";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Kiem tra tai khoan bi trung khong?
	public Account Checkaccount(String user) {
		String query = "select * from dbo.Account where [user]=? ";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setString(1, user);
			rs = ps.executeQuery();// lay ket qua
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

// Lay thong tin nhan vien
	public List<Account> GetAllAccount() {
		List<Account> listA = new ArrayList<Account>();
		String query = "select * from dbo.Account";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				listA.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listA;
	}

//Delete Account
	public void DeleAccount() {
		String query = "";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
//Dem so trang quan ly account
	public int Page_Count_account() {
		String query = "SELECT COUNT(id)\r\n" + "FROM dbo.Account";
		int s;
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return s = (rs.getInt(1))/9+1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	//Phan trang Account Manager
	public List<Account> PagingAccount(int index) {
		List<Account> list = new ArrayList<>();
		String query = "with x as (select ROW_NUMBER() over (order by uid desc) as r, * from dbo.Account) select * from x where r between 9*? -8 and 9*?";
		try {
			conn = new DBcontext().getConnection();// mo ket noi
			ps = conn.prepareStatement(query);// truyen lenh sang sqlserver
			ps.setInt(1, index);
			ps.setInt(2, index);
			rs = ps.executeQuery();// lay ket qua

			while (rs.next()) {
				list.add(new Account(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Account> s = dao.PagingAccount(1);
		System.out.println(s);

	}

}