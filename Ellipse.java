public class Ellipse extends Shape {
	
	
	private double lengthMajorAxis;
	private double lengthMinorAxis;
	private String centerCoordinates=lengthMajorAxis + "," + lengthMinorAxis;
	
	Ellipse(){
		lengthMajorAxis=0;
		lengthMinorAxis=0;
		centerCoordinates="("+0+","+0+")";
	}
   Ellipse(double lengthMajorAxis, double lengthMinorAxis) {
		super();
		this.lengthMajorAxis = lengthMajorAxis;
		this.lengthMinorAxis = lengthMinorAxis;
		this.centerCoordinates = centerCoordinates="("+lengthMajorAxis+","+lengthMinorAxis+")";
	}
 //overriding the toString() method  
 		public String toString(){
 			  return  centerCoordinates+ "("+lengthMajorAxis+","+lengthMinorAxis+") ";  
 			 } 
	public double getLengthMajorAxis() {
		return lengthMajorAxis;
	}
	public double getLengthMinorAxis() {
		return lengthMinorAxis;
	}
	public String getCenterCoordinates() {
		return centerCoordinates;
	}
	
	public double EllipseArea() { 
		double EllipseArea;
		EllipseArea=Math.PI*lengthMajorAxis*lengthMinorAxis;
		return EllipseArea;
	}
	
	public double EllipsePerimeter() {
		double EliipsePrimeter;
		EliipsePrimeter=(2*Math.PI)*Math.sqrt((Math.pow(lengthMajorAxis,2)+Math.pow(lengthMinorAxis,2))/2);
		return EliipsePrimeter;
		
	}
	
}