package cn.edu.svtcc.mybookshop.userdao;

import javax.sql.DataSource;

public class DataSourceProvider {
	private DataSource ds;
	private static DataSourceProvider instance;
	private DataSourceProvider(){
		
	}
	/**
	 * 用单例模式获得DataSourceProvider的实例
	 */
	public static DataSourceProvider getInstance(){
		if(instance==null){
			instance=new DataSourceProvider();
		}
		return instance;
	}
	/**
	 * 初始化DataSource实例
	 */
	public void initDataSource(DataSource ds){
		this.ds=ds;
	}
	/**
	 * 得到一个DataSource
	 */
	public DataSource getDataSource(){
		return ds;
	}
}
