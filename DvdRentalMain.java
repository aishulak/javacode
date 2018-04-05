package com.dvdrental.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DvdRentalMain {
private static int actorId;

public static void main(String args[]) {
System.out.println("Welcome to DVDRental!\n List of Actors in the database are listed below:");
try {
	DvdRentalService dvdRentalObj=new DvdRentalService();
	ArrayList<ActorBean> actorArrayList=null;
	actorArrayList=dvdRentalObj.getActorList();
	if(actorArrayList!=null) {
		Iterator itr=actorArrayList.iterator();
		while(itr.hasNext()) {
			ActorBean actor=(ActorBean) itr.next();
			System.out.println(actor.getActor_id()+ " "+actor.getFirst_name()+" "+actor.getLast_name()+" "+actor.getLast_update()+"\n");
		}
	}
	System.out.println("Enter Actor id to retreive details");
	Scanner scanner = new Scanner(System. in); 
	actorId = Integer.parseInt(scanner. nextLine());
	ActorBean actor=null;
	actor=(ActorBean)dvdRentalObj.getActor(actorId);
	if(actor!=null)
		System.out.println(actor.getActor_id()+ " "+actor.getFirst_name()+" "+actor.getLast_name()+" "+actor.getLast_update()+"\n");
	else
		System.out.println("Invalid Id");
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
