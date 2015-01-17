package com.app.catalogs;

import com.project.enums.UserType;
import com.project.model.AdminAccount;
import com.project.model.UserAccount;

public class AdminCatalog {

	public static UserAccount createAdmin() {
		UserAccount userAccount = new UserAccount();
		userAccount.setPassword("1341684");
		userAccount.setUsername("Sameer");
		userAccount.setUserType(UserType.ADMIN);
		userAccount.setAdminAccount(new AdminAccount());
		return userAccount;
	}

}
