package com.kn.factory;

public class OracleDaoFactory implements IFactory {

	public IUserDao createUserDao() {
		return new UserOracleDao();
	}

	public IDeptDao createDeptDao() {
		return new DeptOracleDao();
	}
}
