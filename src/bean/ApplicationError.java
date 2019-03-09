package bean;


/*
 * 系统错误信息
 */
public class ApplicationError {

	private String errorType;
	private String errroMsg;
	
	
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrroMsg() {
		return errroMsg;
	}
	public void setErrroMsg(String errroMsg) {
		this.errroMsg = errroMsg;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "错误信息" + this.errroMsg;
	}
	
	
	
}
