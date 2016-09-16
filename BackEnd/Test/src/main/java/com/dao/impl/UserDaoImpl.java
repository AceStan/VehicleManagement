package com.dao.impl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.config.HibernateUtil;
import com.config.Response;
import com.dao.UserDao;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Response<User> addUser(User u) {
		Response<User> response = new Response<User>();
		User tmp;
		response.setData(u);
		Session session = sf.openSession();
		Transaction beginTransaction = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("ssid", u.getSsid()));
			tmp = (User) c.uniqueResult();
			if (tmp != null)
				response.setOkSSID(false);
			else
				response.setOkSSID(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setOkSSID(true);
		}
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("username", u.getUsername()));
			tmp = (User) c.uniqueResult();
			if (tmp != null)
				response.setOkUser(false);
			else
				response.setOkUser(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setOkUser(true);
		}
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("password", u.getPassword()));
			tmp = (User) c.uniqueResult();
			if (tmp != null)
				response.setOkPass(false);
			else
				response.setOkPass(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setOkPass(true);
		}
		if (response.isOkSSID() && response.isOkPass() && response.isOkUser()) {
			u.setRole("userEdit");
			session.save(u);
			beginTransaction.commit();
			session.close();
		} else {
			System.out.println("Can't store data into database, some of the required fields are not uniqe !");
			session.close();
		}
		return response;

	}

	@Override
	public Response<User> signIn(String username, String password) {
		Response<User> response = new Response<User>();
		User tmp = null;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("username", username));
			tmp = (User) c.uniqueResult();
			if (tmp != null)
				response.setOkUser(true);
			else
				response.setOkUser(false);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setOkUser(true);
		}
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("password", password));
			tmp = (User) c.uniqueResult();
			if (tmp != null)
				response.setOkPass(true);
			else
				response.setOkPass(false);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setOkPass(true);
		}
		if (response.isOkPass() && response.isOkUser()) {
			tx.commit();
			response.setData(tmp);
			session.close();
		}

		return response;
	}

	@Override
	public User getOwner(String id) {

		System.out.println("THIS IS THE RECIVED ID FROM THE FRONT-END : " + id);
		User owner = null;
		Session session = sf.openSession();
		try {
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("ssid", id));
			owner = (User) c.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return owner;
	}

	
	@Override
	public ArrayList<User> getAllusers() {
		ArrayList<User> res = new ArrayList<>();
		Session session = sf.openSession();
		try {
			Criteria c = session.createCriteria(User.class);
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			res = (ArrayList<User>) c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ALL USERS : ");
		for(int i =0;i<res.size();i++)
			System.out.println(res.get(i).getSsid());
		return res;
	}

	@Override
	public void deleteUser(User user) {
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		}
	}

	@Override
	public User makeAdmin(User user) {
		User res = new User();
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			res = (User) session.get(User.class, user.getSsid());
			res.setRole("admin");
			session.update(res);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void AllUsersPdf() throws Exception {

		ArrayList<User> users = new ArrayList<>();
		Session session = sf.openSession();
		PdfPTable table = new PdfPTable(8);
		PdfPCell cell;
		Document pdf = new Document();
		PdfWriter.getInstance(pdf, new FileOutputStream(
				"/Users/aleksandar.stanoevsk/Desktop/VehicleManagement v.1.1/files/AllUsersPdf.pdf"));
		pdf.open();
		Font f = FontFactory.getFont("Arial", 8);
		final String[] s = { "NAME", "LAST_NAME", "MOBILE", "E-MAIL", "USERNAME", "PASSWORD", "SSID", "ROLE" };
		try {
			Criteria c = session.createCriteria(User.class);
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			users = (ArrayList<User>) c.list();
			for (int i = 0; i < users.size() + 1; i++) {
				if (i == 0) {
					for (int k = 0; k < s.length; k++) {
						cell = new PdfPCell(new Phrase(s[k], f));
						table.addCell(cell);
					}
				} else {
					for (int k = 0; k < s.length; k++) {
						switch (k) {
						case 0:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getName(), f));
							table.addCell(cell);
							break;
						case 1:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getLastName(), f));
							table.addCell(cell);
							break;
						case 2:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getMobile(), f));
							table.addCell(cell);
							break;
						case 3:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getEmail(), f));
							table.addCell(cell);
							break;
						case 4:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getUsername(), f));
							table.addCell(cell);
							break;
						case 5:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getPassword(), f));
							table.addCell(cell);
							break;
						case 6:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getSsid(), f));
							table.addCell(cell);
							break;
						case 7:
							cell = new PdfPCell(new Phrase(users.get(i - 1).getRole(), f));
							table.addCell(cell);
							break;
						default:
							break;
						}
					}

				}
			}
			table.setWidthPercentage(100);
			pdf.add(table);
			pdf.close();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void AllUsersXls() throws Exception {

		ArrayList<User> users = new ArrayList<>();
		Session session = sf.openSession();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet No.1");
		XSSFRow row;
		FileOutputStream xlsx = new FileOutputStream(
				"/Users/aleksandar.stanoevsk/Desktop/VehicleManagement v.1.1/files/AllUsersXlsx.xlsx");
		Map<String, Object[]> userInfo = new TreeMap<String, Object[]>();
		try {
			Criteria c = session.createCriteria(User.class);
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			users = (ArrayList<User>) c.list();
			userInfo.put("1",
					new Object[] { "NAME", "LAST_NAME", "MOBILE", "E-MAIL", "USERNAME", "PASSWORD", "SSID", "ROLE" });
			Integer i = 2;
			for (int k = 0; k < users.size(); k++, i++) {
				userInfo.put(String.valueOf(i),
						new Object[] { users.get(k).getName(), users.get(k).getLastName(), users.get(k).getMobile(),
								users.get(k).getEmail(), users.get(k).getUsername(), users.get(k).getPassword(),
								users.get(k).getSsid(),users.get(k).getRole() });

			}
			Set<String> keySet = userInfo.keySet();
			int rowid = 0;
			for (String key : keySet) {
				row = sheet.createRow(rowid++);
				Object[] objectArr = userInfo.get(key);
				int cellid = 0;
				for (Object o : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) o);

				}

			}
			for (int k = 0; k < 8; k++) {
				sheet.autoSizeColumn(k);
			}
			workbook.write(xlsx);
			xlsx.close();
			System.out.println("Successfully created All Users Report XLSX!");
			workbook.close();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void OwnersPdf() throws Exception {
		
		ArrayList<User> users = new ArrayList<>();
		Session session = sf.openSession();
		PdfPCell cell;
		PdfPTable table = new PdfPTable(5);
		Document pdf = new Document();
		PdfWriter.getInstance(pdf, new FileOutputStream(
				"/Users/aleksandar.stanoevsk/Desktop/VehicleManagement v.1.1/files/OwnersPdf.pdf"));
		pdf.open();
		Font f = FontFactory.getFont("Arial", 8);
		final String[] s = {"CAR_BRAND","CAR_MODEL","OWNER","CONTACT-MOBILE","CONTACT-EMAIL"};
		try {
			Criteria c = session.createCriteria(User.class);
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			users = (ArrayList<User>) c.list();
			
			for (int i = 0; i < users.size() + 1; i++) {
				if (i == 0) {
					for (int k = 0; k < s.length; k++) {
						cell = new PdfPCell(new Phrase(s[k], f));
						table.addCell(cell);
					} // headers of cells 
				} else {
					if(!users.get(i-1).getCars().isEmpty()){ // If a user doesn't own any car don't put it in the table
					for(int j = 0; j<users.get(i-1).getCars().size();j++){
						for(int q = 0;q<5;q++){
							switch(q){
							case 0:
								cell = new PdfPCell(new Phrase(users.get(i - 1).getCars().get(j).getBrand(), f));
								table.addCell(cell);
								break;
							case 1:
								cell = new PdfPCell(new Phrase(users.get(i - 1).getCars().get(j).getModel(), f));
								table.addCell(cell);
								break;
							case 2:
								cell = new PdfPCell(new Phrase(users.get(i - 1).getName()+" "+users.get(i-1).getLastName(), f));
								table.addCell(cell);
								break;
							case 3:
								cell = new PdfPCell(new Phrase(users.get(i - 1).getMobile(), f));
								table.addCell(cell);
								break;
							case 4:
								cell = new PdfPCell(new Phrase(users.get(i - 1).getEmail(), f));
								table.addCell(cell);
								break;
							default:
								break;
							}
						}
					}
					}
				
				
				}
				
				}
			table.setWidthPercentage(100);
			pdf.add(table);
			pdf.close();
			session.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
