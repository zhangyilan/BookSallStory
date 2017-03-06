package cn.edu.svtcc.mybookshop.userdao;

import javax.sql.DataSource;

public class DataSourceProvider {
	private DataSource ds;
	private static DataSourceProvider instance;
	private DataSourceProvider(){
		
	}
	/**
	 * �õ���ģʽ���DataSourceProvider��ʵ��
	 */
	public static DataSourceProvider getInstance(){
		if(instance==null){
			instance=new DataSourceProvider();
		}
		return instance;
	}
	/**
	 * ��ʼ��DataSourceʵ��
	 */
	public void initDataSource(DataSource ds){
		this.ds=ds;
	}
	/**
	 * �õ�һ��DataSource
	 */
	public DataSource getDataSource(){
		return ds;
	}
}
