package Dao;

import globle.Constant;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.NewsBean;
import Model.UserInfoDataBean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DbNews {
	public static final String STABLE_NAME_BANNER = "banner";
	public static final String STABLE_NAME_NEWS = "news";
	//创建一个JDBC连接
	private static Connection getConn() {
	    Connection conn = null;
	    try {
	        Class.forName(Constant.DRIVER); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(Constant.JDBC_URL, Constant.DB_USERNAME, Constant.DB_PASSWORD);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	private static int executeSQL(String sql){
		 Connection conn = getConn();
		    int i = 0;
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		        System.out.println("resutl: " + i);
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return i;
	}
	
	//返回news
	public static List<NewsBean> getNews(String table) {
		int k=0;
		List<NewsBean> lNewsBeans = new ArrayList<NewsBean>();
	    Connection conn = getConn();
	    String sql = "select * from "+ table +" ORDER BY id DESC";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//行元素
	        int col = rs.getMetaData().getColumnCount();	//列元素
	        System.out.println("col="+col);
	        while (rs.next()) {
	        	System.out.println("k="+(k++));
	        	NewsBean bean = new NewsBean();
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
		                case 1:
		                	bean.setId(Integer.parseInt(data));
		                	break;
		                case 2:			
		                	bean.setTitle(data);
							break;
						case 3:
							bean.setContent(data);
							break;
						case 4:			
							bean.setImage(data);
							break;
						case 5:			
							bean.setSee(Integer.parseInt(data));
							break;
						case 6:
							bean.setLink(data);
							break;
						case 7:
							bean.setTime(data);
							break;
						default:
							break;
					}
	        	}
	        	lNewsBeans.add(bean);
            }
	        return lNewsBeans;
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lNewsBeans;
	}
	
	//增加点赞
	public static int updateSee(String table,int id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set see = see+1 where id =" + id ;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
}
