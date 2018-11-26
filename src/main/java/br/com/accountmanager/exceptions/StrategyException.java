package br.com.accountmanager.exceptions;

public class StrategyException extends Exception {

	private static final long serialVersionUID = 1L;

	public StrategyException() {
	}

	public StrategyException(String message) {
		super(message);
	}

	public StrategyException(Throwable cause) {
		super(cause);
	}

	public StrategyException(String message, Throwable cause) {
		super(message, cause);
	}

	public StrategyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
