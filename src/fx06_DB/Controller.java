package fx06_DB;

import java.net.URL;
import java.util.ResourceBundle;

import Auser.LoginService;
import Auser.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable{	
	Parent root;
	public static DBClass db;
	private common.db.DBClass comDB;
	private LoginService ls;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		db = new DBClass();
		comDB = new common.db.DBClass();
		ls = new LoginServiceImpl();
	}
	public void membership() {
		TextField id = (TextField)root.lookup("#memberId");
		TextField name = (TextField)root.lookup("#memberName");
		TextField pwd= (TextField)root.lookup("#memberPwd");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPwd(pwd.getText());
		dto.setName(name.getText());
		
//		System.out.println(dto);
//		System.out.println(db); 
//		System.out.println(db.insert(dto));//insert가 하나 더 있어서 '동일한아이디존재' 뜬 것. //수업시간에 내가 발견하고 선생님께 말씀드려서 뿌듯함+ 히히
		
		int result = db.insert(dto);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입에 성공하셨습니다.");
			alert.show();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("동일한 아이디가 존재합니다.");
			alert.show();
		}
		
		
	}
	
	public void login() {
		ls.loginChk(root);
		/*
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		
		MemberDTO dto = db.loginChk(id.getText());S
		
		if(dto == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("존재하지 않는 아이디입니다.");
			alert.show();
		}else {
			if(dto.getPwd().equals(pwd.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("인증성공입니다.");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("비밀번호 틀림");
				alert.show();
				
			}
			
		}*/
		
		
	}

}
