package Auser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.db.DBClass;
import fx06_DB.MemberDTO;

public class LoginDB {
	public MemberDTO loginChk(String inputId) {
		String sql = "select * from fx_member where id=?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setString(1, inputId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId( rs.getString("id") );
				dto.setPwd( rs.getString("pwd") );
				dto.setName(rs.getString("name") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
