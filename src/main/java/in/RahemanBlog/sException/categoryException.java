package in.RahemanBlog.sException;

public class categoryException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public categoryException(String msg) {
		super(msg);
	}
	
	
	public categoryException() {
		super();
	}
}
