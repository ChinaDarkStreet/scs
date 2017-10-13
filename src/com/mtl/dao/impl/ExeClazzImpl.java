package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtl.dao.ExeClazz;
import com.mtl.pojo.Clazz;
import com.mtl.util.DBUtil;

public class ExeClazzImpl implements ExeClazz {

	@Override
	public List<Clazz> getAllClazz() {
		// TODO 返回所有的clazz列表
		List<Clazz> list = new ArrayList<Clazz>();
		String sql = "select * from t_clazz";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
		try {
			System.out.println(rs.toString());
			while (rs.next()){
				Clazz clazz = new Clazz(rs.getInt(1), rs.getString("cname"), rs.getString("chteacher"), 
						rs.getString("clazzroom"));
				System.out.println("clazz = " + clazz);
				list.add(clazz);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
