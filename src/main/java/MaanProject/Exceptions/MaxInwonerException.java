package MaanProject.Exceptions;

public class MaxInwonerException extends Exception {
	public MaxInwonerException()
	{
		super();
	}

	public MaxInwonerException(String message)
	{
		super(message);
	}

	public MaxInwonerException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public MaxInwonerException(Throwable cause)
	{
		super(cause);
	}

	protected MaxInwonerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
