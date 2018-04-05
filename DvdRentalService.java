package com.dvdrental.classes;

import java.util.ArrayList;

public class DvdRentalService {
	private DvdRentalDao dvdRentalDaoObj=new DvdRentalDao();
	private ArrayList<ActorBean> actorList;
	private ActorBean actorBean;
	
	public ArrayList<ActorBean> getActorList() throws ClassNotFoundException{
		actorList=dvdRentalDaoObj.getActorList();
		return actorList;
		
	}
 
	public ActorBean getActor(int actorId) {
		try {
			actorBean=dvdRentalDaoObj.getActor(actorId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actorBean;
		
	}
}
