package Auser;

import common.alert.AlertClass;
import fx06_DB.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService{
	LoginDB db;
	public LoginServiceImpl() {
		db = new LoginDB();
	}
	
	public void loginChk(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		
		MemberDTO dto = db.loginChk( id.getText() );
		
		String msg = null;
		if(dto == null) {
			msg = "해당아이디는 존재하지 않습니다";
		}else {
			if( dto.getPwd().equals(pwd.getText()) ) {
				msg = "인증성공 되었습니다";
			}else {
				msg = "비밀번호가 틀렸습니다";
			}
		}
		AlertClass.alert(msg);
	}
}
