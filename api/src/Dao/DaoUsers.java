package Dao;

import globle.Constant;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import utils.JsonUtils;

import Model.MicroBlog;
import Model.UserInfoBean;
import Model.UserInfoDataBean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoUsers {

	public static final String STABLE_NAME = "user";
	//����һ��JDBC����
	private static Connection getConn() {
	    Connection conn = null;
	    try {
	        Class.forName(Constant.DRIVER); //classLoader,���ض�Ӧ����
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
	
	//��ѯId���ֵ  
	public static int getMaxId(){
		Connection conn = getConn();
		String sql = "select max(id) from "+STABLE_NAME;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	 return rs.getInt(1);    
	        	
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return 0;
	}
	
	//����
	public static int insert(String table,UserInfoDataBean users) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into "+table+" (username,password,headurl,phone,sex,address,money,signa,messagenum,longitude,latitude,signNum) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, users.getUsername());
	        pstmt.setString(2, users.getPassword());
	        pstmt.setString(3, users.getHeadurl());
	        pstmt.setString(4, users.getPhone());
	        pstmt.setString(5, users.getSex());
	        pstmt.setString(6, users.getAddress());
	        pstmt.setInt(7, users.getMoney());
	        pstmt.setString(8, users.getSigna());
	        pstmt.setInt(9, users.getMessagenum());
	        pstmt.setString(10, users.getLongitude());
	        pstmt.setString(11, users.getLatitude());
	        pstmt.setInt(12, users.getSignNum());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	//�����ǳ�
	public static int updateUsername(String table,int id,String username) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set username='" + username + "' where id='"+ id+"'";
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
	
	//����sex
	public static int updateSex(String table,int id,String sex) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set sex='" + sex + "' where id="+id ;
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
	
	//����address
	public static int updateAddress(String table,int id,String address) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set address='" + address + "' where id=" + id;
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
	
	//����ѧԺ
	public static int updateCollege(String table,int id,String college) {
		String sql = "update "+table+" set college='" + college + "' where id='"+ id+"'";
		return executeSQL(sql);
	}
	
	//����רҵ
	public static int updateMajor(String table,int id,String major) {
		String sql = "update "+table+" set major='" + major + "' where id='"+ id+"'";
		return executeSQL(sql);
	}
	
	//����΢��
	public static int updateWechat(String table,int id,String wechat) {
		String sql = "update "+table+" set wechat='" + wechat + "' where id='"+ id+"'";
		return executeSQL(sql);
	}
		
	
	//���¸���ǩ��
	public static int updateSigna(String table,int id,String signa) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set signa='" + signa + "' where id='"+ id+"'";
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
	
	//����phone
	public static int updatePhone(String table,int id,String phone) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set phone='" + phone + "' where id=" + id;
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
	
	//��������
	public static int updatePassword(String table,int id,String password) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set password='" + password + "' where id=" + id;
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
	
	//����ͷ��
	public static int updateHeadurl(String table,int id,String headurl) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set headurl='" + headurl + "' where id=" + id;
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
	
	//����
	public static Integer getAll(String table) {
	    Connection conn = getConn();
	    String sql = "select * from "+table+"";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//���ظ�����Ϣ
	public static UserInfoDataBean usernameGetUserList(String table,String phone) {
//		UserInfoBean userInfoBean = new UserInfoBean();
		UserInfoDataBean userInfoDataBean = new UserInfoDataBean();
	    Connection conn = getConn();
	    String sql = "select id,username,password,headurl,phone,sex,address,money,signa,messagenum,longitude,latitude,signNum,college,major,wechat from "+table+" where phone='"+phone+"'";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
		                case 1:
		                	userInfoDataBean.setId(Integer.parseInt(data));
		                	break;
		                case 2:			
		                	userInfoDataBean.setUsername(data);
							break;
						case 3:
							userInfoDataBean.setPassword(data);
							break;
						case 4:			
							userInfoDataBean.setHeadurl(data);
							break;
						case 5:			
							userInfoDataBean.setPhone(data);
							break;
						case 6:			
							userInfoDataBean.setSex(data);
							break;
						case 7:			
							userInfoDataBean.setAddress(data);
							break;
						case 8:			
							userInfoDataBean.setMoney(Integer.parseInt(data));
							break;
						case 9:			
							userInfoDataBean.setSigna(data);
							break;
						case 10:			
							userInfoDataBean.setMessagenum(Integer.parseInt(data));
							break;
						case 11:
							userInfoDataBean.setLongitude(data);
							break;
						case 12:
							userInfoDataBean.setLatitude(data);
							break;
						case 13:
							userInfoDataBean.setSignNum(Integer.parseInt(data));
							break;
						case 14:
							userInfoDataBean.setCollege(data);
							break;
						case 15:
							userInfoDataBean.setMajor(data);
							break;
						case 16:
							userInfoDataBean.setWechat(data);
							break;
					default:
						break;
					}
	        	}
            }
	        return userInfoDataBean;
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	//���ظ�����Ϣ
	public static String getUserInfo(String table,String id) {
		UserInfoBean userInfoBean = new UserInfoBean();
		UserInfoDataBean userInfoDataBean = new UserInfoDataBean();
	    Connection conn = getConn();
	    String sql = "select * from "+table+" where id= '"+id+"'";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
		                case 1:
		                	userInfoDataBean.setId(Integer.parseInt(data));
		                	break;
		                case 2:			
		                	userInfoDataBean.setUsername(data);
							break;
						case 3:
							userInfoDataBean.setPassword(data);
							break;
						case 4:			
							userInfoDataBean.setHeadurl(data);
							break;
						case 5:			
							userInfoDataBean.setPhone(data);
							break;
						case 6:			
							userInfoDataBean.setSex(data);
							break;
						case 7:			
							userInfoDataBean.setAddress(data);
							break;
						case 8:			
							userInfoDataBean.setMoney(Integer.parseInt(data));
							break;
						case 9:			
							userInfoDataBean.setSigna(data);
							break;
						case 10:			
							userInfoDataBean.setMessagenum(Integer.parseInt(data));
							break;
						case 11:
							userInfoDataBean.setLongitude(data);
							break;
						case 12:
							userInfoDataBean.setLatitude(data);
							break;
						case 13:
							userInfoDataBean.setSignNum(Integer.parseInt(data));
							break;
						case 14:
							userInfoDataBean.setCollege(data);
							break;
						case 15:
							userInfoDataBean.setMajor(data);
							break;
						case 16:
							userInfoDataBean.setWechat(data);
							break;
					default:
						break;
					}
	        	}
            }
	        userInfoBean.setData(userInfoDataBean);
	        userInfoBean.setStatus(1);
	        userInfoBean.setInfo("success");
	        String userInfoBeanString = JsonUtils.toJson(userInfoBean);
	        return userInfoBeanString;
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    userInfoBean.setData(userInfoDataBean);
        userInfoBean.setStatus(0);
        userInfoBean.setInfo("error");
        String userInfoBeanString = JsonUtils.toJson(userInfoBean);
        return userInfoBeanString;
	}
	
	//���ظ�����Ϣ(���Ͽ�)
	public static List<UserInfoDataBean> usernameGetUserList(String table,int id) {
		List<UserInfoDataBean> lUsers = new ArrayList<UserInfoDataBean>();
		UserInfoDataBean users = new UserInfoDataBean();
	    Connection conn = getConn();
	    String sql = "select id,username,password,headurl,phone,sex,address,money,signa,college,major,wechat from "+table+" where id="+id;
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
	                case 1:
	                	users.setId(Integer.parseInt(data));
	                	break;
	                case 2:			
						users.setUsername(data);
						break;
					case 3:
						users.setPassword(data);
						break;
					case 4:			
						users.setHeadurl(data);
						break;
					case 5:			
						users.setPhone(data);
						break;
					case 6:			
						users.setSex(data);
						break;
					case 7:			
						users.setAddress(data);
						break;
					case 8:			
						users.setMoney(Integer.parseInt(data));
						break;
					case 9:			
						users.setSigna(data);
						break;
					case 10:
						users.setCollege(data);
						break;
					case 11:
						users.setMajor(data);
						break;
					case 12:
						users.setWechat(data);
						break;
					default:
						break;
					}
	        	}
            }
	        lUsers.add(users);
	        return lUsers;
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//�����û���Ϣ
	public static List<UserInfoBean> getUserList(String table) {
		List<UserInfoBean> uInfoBeans = new ArrayList<UserInfoBean>();
	    Connection conn = getConn();
	    String sql = "select * from "+table+"";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	        	UserInfoBean userInfoBean = new UserInfoBean();
	        	UserInfoDataBean users = new UserInfoDataBean();
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
                	case 1:
                		users.setId(Integer.parseInt(data));
                		break;
	                case 2:
						users.setUsername(data);
						break;
					case 3:
						users.setPassword(data);
						break;
					case 4:			
						users.setHeadurl(data);
						break;
					case 5:			
						users.setPhone(data);
						break;
					case 6:			
						users.setSex(data);
						break;
					case 7:			
						users.setAddress(data);
						break;
					case 8:			
						users.setMoney(Integer.parseInt(data));
						break;
					case 9:			
						users.setSigna(data);
						break;
					case 10:			
						users.setMessagenum(Integer.parseInt(data));
						break;
					case 11:
						users.setLongitude(data);
						break;
					case 12:
						users.setLatitude(data);
						break;
					case 13:
						users.setSignNum(Integer.parseInt(data));
						break;
					case 14:
						users.setCollege(data);
						break;
					case 15:
						users.setMajor(data);
						break;
					case 16:
						users.setWechat(data);
						break;
					default:
						break;
					}
	        	}
	        	userInfoBean.setData(users);
	        	userInfoBean.setInfo("");
	        	userInfoBean.setStatus(1);
	        	uInfoBeans.add(userInfoBean);
	        	
            }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return uInfoBeans;
	}
	
	//��¼�ж�
	public static int Rechecking(String table,String phone,String password) {
		Connection conn = getConn();
	    String sql = "select * from "+table+" where phone = '" + phone + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	if (rs.getString(5).equals(phone)){
	        		if(rs.getString(3).equals(password)){
	        			//������ȷ
	        			return 1;
	        		}
	        		else{
	        			//�������
	        			return 2;
	        		}
	        	}  
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    //û�д��û�
		return 3;
	}
		
	
	//ɾ�������û���ɾ����
	public static int delete(String table,String phone) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from "+table+" where phone='" + phone + "'";
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

	//ע���ֻ��Ƿ����
	public static boolean Assign(String table,String phone) {
		Connection conn = getConn();
	    String sql = "select * from "+table+" where phone = '" + phone + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	if (rs.getString(5).equals(phone)){
	        		return false;       
	        	}
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return true;
	}
	
	//�����ֻ����޸�����
	public static int updatePasswordOfPhone(String table,String phone,String password) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set password='" + password + "' where phone='" + phone + "'";
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
	
	//�ж��ֻ��Ƿ����
	public static boolean judgePhone(String table,String phone) {
		Connection conn = getConn();
	    String sql = "select phone from "+table+" WHERE phone = '"+ phone + "'" ;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	if (rs.getString(1).equals(phone)){
	        		return true;       
	        	}
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	//���ӻ���
	public static int updateMoney(String table,int id,int money) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set money = money+"+money+" where id = " + id;
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
	
	//����δ����Ϣ
	public static int updateUnreadMessage(String table,int id,int messagenum) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set messagenum = messagenum+"+messagenum+" where id = " + id;
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
	
	//���δ����Ϣ
	public static int clearUnreadMessage(String table,int id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set messagenum = 0"+" where id = " + id;
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
	
	//��ȡδ����Ϣ����
	public static int getUnreadMessage(String table,int id) {
		Connection conn = getConn();
	    int messagenum = 0;
	    String sql = "select messagenum from "+table+" where id="+id;
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	messagenum = rs.getInt(1); //0����ӦID��1����Ӧ��ѯ��������
	        }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return messagenum;
	}
	
	//����ѯ
	public static int queryMoney(String table,int id) {
	    Connection conn = getConn();
	    int money = 0;
	    String sql = "select money from "+table+" where id="+id;
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();			//��Ԫ��
	        int col = rs.getMetaData().getColumnCount();	//��Ԫ��
	        while (rs.next()) {
	        	money = rs.getInt(1); //0����ӦID��1����Ӧ��ѯ��������
	        }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return money;
	}
	
	
	//�۳�����
	public static boolean reduceMoney(String table,int id,int money) {
		if(queryMoney(table,id)-money >= 0){
			Connection conn = getConn();
		    String sql = "update "+table+" set money = money-"+money+" where id = " + id ;
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return true;    
		}else{
			return false;
		}
	}
	
	//�޸ľ��Ⱥ�γ��
	public static int updateLocation(String table,int id,String longitude,String latitude) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set longitude='" + longitude + "',latitude='"+ latitude +"' where id=" + id;
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
	
	//����ǩ������
	public static int updateSignNum(String table,int id,int signNum) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update "+table+" set signNum = signNum+"+signNum+" where id = " + id;
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
	
	public static List<UserInfoBean> getUserSignNum(String table){
		List<UserInfoBean> uInfoBeans = new ArrayList<UserInfoBean>();
	    Connection conn = getConn();
//	    String sql = "select * from "+table+" ";
	    String sql = "select * from "+ table + " ORDER BY signNum DESC limit 0,50";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	        	UserInfoBean userInfoBean = new UserInfoBean();
	        	UserInfoDataBean users = new UserInfoDataBean();
	        	for (int i = 1; i <= col; i++) {
	                String data = rs.getString(i);
	                switch (i) {
                	case 1:
                		users.setId(Integer.parseInt(data));
                		break;
	                case 2:
						users.setUsername(data);
						break;
					case 3:
						users.setPassword(data);
						break;
					case 4:			
						users.setHeadurl(data);
						break;
					case 5:			
						users.setPhone(data);
						break;
					case 6:			
						users.setSex(data);
						break;
					case 7:			
						users.setAddress(data);
						break;
					case 8:			
						users.setMoney(Integer.parseInt(data));
						break;
					case 9:			
						users.setSigna(data);
						break;
					case 10:			
						users.setMessagenum(Integer.parseInt(data));
						break;
					case 11:
						users.setLongitude(data);
						break;
					case 12:
						users.setLatitude(data);
						break;
					case 13:
						users.setSignNum(Integer.parseInt(data));
						break;
					default:
						break;
					}
	        	}
	        	userInfoBean.setData(users);
	        	userInfoBean.setInfo("");
	        	userInfoBean.setStatus(1);
	        	uInfoBeans.add(userInfoBean);
	        	
            }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return uInfoBeans;
	}
	
}