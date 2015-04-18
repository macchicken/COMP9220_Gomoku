package service;

import java.util.HashMap;

public abstract class CheckRule {

	protected String checkResult;

	public CheckRule(String checkResult) {
		super();
		this.checkResult = checkResult;
	}
	public abstract boolean check(HashMap<String,Object> checkObjs);

	public String getCheckResult() {
		return this.checkResult;
	}
}
