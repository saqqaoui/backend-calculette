package calculator.exception;

/**
 * Api error object to send when exception is thrown
 */
public class ApiError {

	protected int httpStatusCode;
	protected String message;

	public ApiError(int httpStatusCode, String message) {
		this.httpStatusCode = httpStatusCode;
		this.message = message;
	}

}

