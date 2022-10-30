package com.ers.pojo;

public class DateConversion {
	
	static String pattern = "yyyy-MM-dd";
	
	//SQL TO UTIL --while getting data from database
	public static java.util.Date convertDateFromSqlToUtil(java.sql.Date dateInSql){
		java.util.Date dateInUtil = new java.util.Date(dateInSql.getTime());
		return dateInUtil;
	}
	
	//util to sql ---  WHILE INSERTING OR UPDATING INTO DATABASE
	public static java.sql.Date convertDateFromUtilToSql(java.util.Date dateInUtil){
		java.sql.Date dateInSql = new java.sql.Date(dateInUtil.getTime());
		return dateInSql;
	}

}
