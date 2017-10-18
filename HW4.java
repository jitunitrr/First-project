import java.util.ArrayList;
import java.util.Scanner;

import com.Doctor;
import com.Entry;
import com.HeapAdaptablePriorityQueue;
import com.Patient;
public class HW4 {
		public static void main(String[] args) {
			HeapAdaptablePriorityQueue<Integer , Patient> patientPQ=new HeapAdaptablePriorityQueue<Integer,Patient>();
			HeapAdaptablePriorityQueue<Integer , Patient> patientDepart=new HeapAdaptablePriorityQueue<Integer,Patient>();
			HeapAdaptablePriorityQueue<Integer , Doctor> doctorPQ=new HeapAdaptablePriorityQueue<Integer,Doctor>();
			Doctor d1=new Doctor("Alice", 0);
			Doctor d2=new Doctor("Bob", 0);
			doctorPQ.insert(0, d1);
			doctorPQ.insert(1, d2);
			
			Scanner sc=new Scanner(System.in);
			Patient currentPatient=null;
			int lastPatientArrival=0;
			String line;
			while(sc.hasNextLine()|| !patientPQ.isEmpty()){
				line=sc.nextLine();
				String event=line.split(" ")[0];
					if(line.split(" ")[0].equals("patientArrives")){
						int  arrivalTime=Integer.parseInt(line.split(" ")[1]);
						String name=line.split(" ")[2];
						int esi=Integer.parseInt(line.split(" ")[3]);
						Patient p=new Patient(name, arrivalTime, esi,event);
						patientPQ.insert(p.getEsi(), p);
						if(lastPatientArrival<arrivalTime)
						      lastPatientArrival= arrivalTime;
						Entry<Integer, Patient> departMin=patientDepart.min();
						 if(!patientDepart.isEmpty() && lastPatientArrival>= departMin.getValue().getDepartureTime()) {
							    Entry<Integer, Patient> departpatient=patientDepart.removeMin();
							    System.out.println("doctorFinishesTreatmentAndPatientDeparts "+departpatient.getValue().getDepartureTime()+" "+
								departpatient.getValue().getDoctorName()+" "+departpatient.getValue().getName());		
						 }
						 
						currentPatient=p;
						System.out.println("patientArrives "+currentPatient.getArrivalTime()+" "+currentPatient.getName()+" "+currentPatient.getEsi());
						
					}else if(line.split(" ")[0].equals("updatePatientESI")){
						//Patient patient1=patientPQ.remove(entry);
						
						int  arrivalTime=Integer.parseInt(line.split(" ")[1]);
						String name=line.split(" ")[2];
						int esi=Integer.parseInt(line.split(" ")[3]);
						Patient p=new Patient(name, arrivalTime, esi,event);
						patientPQ.insert(p.getEsi(), p);		
					}else if(line.split(" ")[0].equals("patientDepartsAfterNurseTreatment")){
						int  arrivalTime=Integer.parseInt(line.split(" ")[1]);
						String name=line.split(" ")[2];
						int esi=Integer.parseInt(line.split(" ")[3]);
						Patient p=new Patient(name, arrivalTime, esi,event);
						patientPQ.insert(p.getEsi(), p);		
					}else if(line.split(" ")[0].equals("doctorArrives")){
						int  arrivalTime=Integer.parseInt(line.split(" ")[1]);
						String name=line.split(" ")[2];
						Doctor d=new Doctor(name, arrivalTime);
						doctorPQ.insert(d.getArrivalTime(), d);	
					}
					if(doctorPQ.size()>0){
						Entry<Integer, Patient> serve1=patientPQ.min();
							
						Entry<Integer, Doctor> doctorMin=doctorPQ.min();
							if(serve1.getValue().getArrivalTime()>=doctorMin.getValue().getArrivalTime()) {
								serve1=patientPQ.removeMin();
								//System.out.println("patientArrives "+serve1.getValue().getArrivalTime()+" "+serve1.getValue().getName()+" "+serve1.getValue().getEsi());				
								 Entry<Integer, Doctor> doctor=doctorPQ.removeMin();
					        	 System.out.println("doctorStartsTreatingPatient "+serve1.getValue().getArrivalTime()+" "+doctor.getValue().getName()+" "+serve1.getValue().getName());
					
					        	 // set patient treatment time and doctor name
					        	 serve1.getValue().setTreatmentTime(serve1.getValue().getArrivalTime());	
					        	 serve1.getValue().setDoctorName(doctor.getValue().getName());
					        	 
					        	 // set doctor depart time
					        	 int departureTime=(int) (serve1.getValue().getArrivalTime()+Math.pow(2, (6-serve1.getValue().getEsi())));
					        	 serve1.getValue().setDepartureTime(departureTime);
						     
					        	 // insert into patientDepart queue
					        	 patientDepart.insert(serve1.getKey(), serve1.getValue());
						     
					        	 // insert value into doctorPQ if doctor is free
							     doctor.getValue().setArrivalTime(serve1.getValue().getDepartureTime());
							     doctorPQ.insert(departureTime, doctor.getValue());
							  // System.out.println("Depart :"+serve1.getValue().getDepartureTime());
					       }else{
					    	   // displaying the depart information of patient
								Entry<Integer, Patient> departMin=patientDepart.min();
								 if(!patientDepart.isEmpty() && currentPatient.getArrivalTime()>= departMin.getValue().getDepartureTime()) {
									    Entry<Integer, Patient> departpatient=patientDepart.removeMin();
									    System.out.println("doctorFinishesTreatmentAndPatientDeparts "+departpatient.getValue().getDepartureTime()+" "+
										departpatient.getValue().getDoctorName()+" "+departpatient.getValue().getName());		
								 }
					    	   // patientPQ.insert(serve1.getKey(), serve1.getValue());
						       //Entry<Integer, Patient> depart=patientDepart.min();	     
						       //Doctor d=new Doctor(depart.getValue().getDoctorName(),depart.getValue().getDepartureTime());
						      // doctorPQ.insert(d.getArrivalTime(), d);	
					      }
                     }
					
					
			}
			
			
		sc.close();	
		} 

}
