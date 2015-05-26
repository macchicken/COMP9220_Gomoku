package service;


public abstract class CheckRule<E,R> {

	protected R checkResult;

	public CheckRule(R checkResult) {
		super();
		this.checkResult = checkResult;
	}
	public abstract boolean check(E checkObjs);

	public R getCheckResult() {
		return this.checkResult;
	}
}
