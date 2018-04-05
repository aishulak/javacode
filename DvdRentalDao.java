package com.dvdrental.classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

public class DvdRentalDao {
	public ArrayList<ActorBean> getActorList() throws ClassNotFoundException{
		ArrayList<ActorBean> actorList=new ArrayList<ActorBean>() ;
		ActorBean actor;
		try {
			Connection conn = DBConnectivity.connection();
			CallableStatement actorListstatement = conn.prepareCall("select * from getactorlist()");
			//{ ? = call public.getactorlist() }");
			conn.setAutoCommit(false);        
	        //actorListstatement.registerOutParameter(1, Types.OTHER);
			ResultSet result = actorListstatement.executeQuery();
			while (result.next()) {
	            int id = result.getInt(1);
	            String firstname = result.getString(2);
	            String lastname= result.getString(3);
	            Timestamp lastupdate=result.getTimestamp(4);
	            actor=new ActorBean();
	            actor.setActor_id(id);
	            actor.setFirst_name(firstname);
	            actor.setLast_name(lastname);
	            actor.setLast_update(lastupdate);
	            actorList.add(actor);
	          }
	          conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actorList;
	}

	public ActorBean getActor(int actorId) throws ClassNotFoundException {
		ActorBean actor=null;
		try {
			Connection conn = DBConnectivity.connection();
			CallableStatement actorListstatement = conn.prepareCall(" select * from getactor(?)");
			actorListstatement.setInt(1, actorId);
			actorListstatement.execute();
            ResultSet result = actorListstatement.executeQuery();
            while (result.next()) {
	            int id = result.getInt(1);
	            String firstname = result.getString(2);
	            String lastname= result.getString(3);
	            Timestamp lastupdate=result.getTimestamp(4);
	             
	            actor=new ActorBean();
	            actor.setActor_id(id);
	            actor.setFirst_name(firstname);
	            actor.setLast_name(lastname);
	            actor.setLast_update(lastupdate);
	            
	          }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actor;
	}
}
