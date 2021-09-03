package com.url_short.persistence;

import java.util.ArrayList;
import java.util.List;

import com.url_short.model.LinkBean;

////// CLASSE DE CONEXAO COM BANCO DE DADOS (TABELA LINK), INSERIR, BUSCAR, ATUALIZAR ////////

public class LinkDAO  extends DAO{

	private static final String INSERT    = "insert into tb_link(url, code, insert_date) values(?,(select substr(to_base64((select count(1) as total from tb_link l)),1,7)), sysdate());\n"
			+ "";
	private static final String UPDATE    = "update tb_link set custom =? where id =?";
	private static final String FIND_ALL  = "select id, url, code, custom from tb_link;";
	
//////////   INSERT    /////////////
	public boolean create(String url)throws Exception{
		try {
			open();
		    statement = connection.prepareStatement(INSERT);
		    statement.setString(1 , url);
		    return statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			
			return false;
		}finally {
			
			close();
		}
		 
	}
/////////////////////////////////////////
	
//////////    FINDALL   /////////////	
	public List<LinkBean> findAll()throws Exception{
		List<LinkBean> links = null;
		try {
			open();
		    statement = connection.prepareStatement(FIND_ALL );
		    resultSet = statement.executeQuery();
		    links = new ArrayList<LinkBean>();
		    while(resultSet.next()) {
		    	///// ADICIONANDO OBJETOS /////
		    	links.add(new LinkBean(resultSet.getInt("id"), resultSet.getString("url"),
		    						 resultSet.getString("code"),resultSet.getString("custom")));
		    	 
		    }
		    //return statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}finally {
			close();
		}
		return links;
		 
	}
////////////////////////////////////////
	
///////////////  UPDATE   ///////////////////	
	public boolean update(String custom, int id)throws Exception{
		try {
			open();
		    statement = connection.prepareStatement(UPDATE);
		    statement.setString(1 , custom );
		    statement.setInt(2, id);
		    return statement.executeUpdate()>0 ? true : false ;
		} catch (Exception e) {
			// TODO: handle exception
			
			return false;
		}finally {
			
			close();
		}
		 
	}
	
	public static void main(String[] args) {
		try {
			LinkDAO lDAO = new LinkDAO();
			System.out.println(lDAO.update("WG", 1));
			lDAO.create("https://www.google.com/flamengo");
			lDAO.findAll(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()); 
		}
	}
	
} 

