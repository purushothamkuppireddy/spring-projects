package com.capg.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capg.dbcon.DbCon;
import com.capg.model.User;

@Controller
public class ControllerSample {

	@RequestMapping("/")
	public ModelAndView index() {
		System.out.println("hi");
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/insert")
	public ModelAndView insert(@Validated @ModelAttribute("user") User user, BindingResult br)
			throws ClassNotFoundException, SQLException {
if(br.hasErrors()) {
	return new ModelAndView("index");
}else {
		
		DbCon con = new DbCon();
		Connection connection = con.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into userDetails values(?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getMobile());
		ps.setString(3, user.getEmail());
		boolean b = ps.execute();
		if (!b) {
			return new ModelAndView("insert", "message", "succesfully Inserted");
		} else {
			return new ModelAndView("insert", "message", "Not Inserted");
		}
}
	}

	@RequestMapping("/display")
	public ModelAndView select(Model m) throws ClassNotFoundException, SQLException {
		DbCon con = new DbCon();

		Connection connection = con.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from userDetails");
		ResultSet rs = ps.executeQuery();
		List<User> li = new ArrayList<User>();
		while (rs.next()) {

			User u = new User();
			u.setName(rs.getString(1));
			u.setMobile(rs.getString(2));
			u.setEmail(rs.getString(3));
			li.add(u);
		}
		m.addAttribute("Li", li);
		return new ModelAndView("display");
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable String id) throws ClassNotFoundException, SQLException {
		System.out.println(id);
		DbCon con = new DbCon();
		Connection connection = con.getConnection();
		PreparedStatement ps = connection.prepareStatement("delete from userDetails where mobile=? ");
		ps.setString(1, id);
		int i = ps.executeUpdate();
		if (i == 1) {
			System.out.println("deleted Successfully");
			return new ModelAndView("redirect:/display");
		} else {
			System.out.println("Error in deleting");
			return new ModelAndView("redirect:/display");
		}

	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable String id, Model m) throws ClassNotFoundException, SQLException {
		System.out.println(id);
		DbCon con = new DbCon();
		Connection connection = con.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from userDetails where mobile=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		User u = new User();
		while (rs.next()) {
			u.setName(rs.getString(1));
			u.setMobile(rs.getString(2));
			u.setEmail(rs.getString(3));
		}
		m.addAttribute("u", u);

		return new ModelAndView("update");

	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute("user") User user) throws ClassNotFoundException, SQLException {

		DbCon con = new DbCon();
		System.out.println("purushotham");
		Connection connection = con.getConnection();
		PreparedStatement ps = connection.prepareStatement("update userDetails set name=?,email=? where mobile=?");
		ps.setString(1, user.getName());
		ps.setString(3, user.getMobile());
		ps.setString(2, user.getEmail());
		boolean b = ps.execute();
		if (!b) {
			System.out.println("succesfully updated");
			return new ModelAndView("redirect:/display");
		} else {
			System.out.println("error in updateing");
			return new ModelAndView("redirect:/display");
		}

	}

}
