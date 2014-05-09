package dao;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class Connection {

	private  ObjectContainer db;
	
	private static Connection INSTANCE = new Connection();
	
	@SuppressWarnings("deprecation")
	public ObjectContainer getDB(){
		
		
		try{
			db = Db4o.openFile("database");
		}catch(com.db4o.ext.DatabaseFileLockedException ex){
			System.out.println("Arquivo ja aberto");
		}
		return db;
	}
	
	private Connection() {
    }
	
	public static Connection getInstance(){
		
		if(INSTANCE == null){
			return new Connection();
		}
        return INSTANCE;
  }

}
