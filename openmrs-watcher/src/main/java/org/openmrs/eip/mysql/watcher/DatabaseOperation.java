package org.openmrs.eip.mysql.watcher;

/**
 * Enumeration for database operations used by debezium
 */
public enum DatabaseOperation {
	
	CREATE("c"),
	
	READ("r"),
	
	UPDATE("u"),
	
	DELETE("d");
	
	//Raw value as represented by debezium
	private String rawValue;
	
	DatabaseOperation(String rawValue) {
		this.rawValue = rawValue;
	}
	
	/**
	 * Gets the rawValue
	 *
	 * @return the rawValue
	 */
	public String getRawValue() {
		return rawValue;
	}
	
}
