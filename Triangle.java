public class Triangle extends Polygon {
	// declaring attributees...
	private static double x1;
	private static double y1;
	private String firstVertices;

	private static double x2;
	private static double y2;
	private String secondVertices;

	private static double x3;
	private static double y3;
	private String thirdVertices;

	// Getters of the above attributes...
	public static double getX1() {
		return x1;
	}
	//overriding the toString() method  
	public String toString(){
		  return "("+x1+","+y1+") "+"("+x2+","+y2+") "+"("+x3+","+y3+") ";  
		 } 
	public static double getY1() {
		return y1;
	}

	public String getFirstVertices() {
		return firstVertices;
	}

	public static double getX2() {
		return x2;
	}

	public static double getY2() {
		return y2;
	}

	public String getSecondVertices() {
		return secondVertices;
	}

	public static double getX3() {
		return x3;
	}

	public static double getY3() {
		return y3;
	}

	public String getThirdVertices() {
		return thirdVertices;
	}

	// Default constructor...
	Triangle() {
		x1 = x2 = x3 = 0;
		y1 = y2 = y3 = 0;
		firstVertices = "(" + x1 + "," + y1 + ")";
		secondVertices = "(" + x2 + "," + y2 + ")";
		thirdVertices = "(" + x3 + "," + y3 + ")";
	}

	// parameterized constructor...

	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.firstVertices = firstVertices = "(" + x1 + "," + y1 + ")";

		this.x2 = x2;
		this.y2 = y2;
		this.secondVertices = secondVertices = "(" + x2 + "," + y2 + ")";

		this.x3 = x3;
		this.y3 = y3;
		this.thirdVertices = thirdVertices = "(" + x3 + "," + y3 + ")";
	}

	// function that returns area of a triangle..
	public static double TriangleArea() {
		double triagnleArea;
		// calculating the area of a triangle using 3 point formula...
		triagnleArea = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
		return triagnleArea;
	}

	// function that returns the perimeter of a triangle
	public static double TrianglePerimeter() {
		double traianglePerimeter, side1, side2, side3;
		
		// calculating the 3 sides of a triangle using the 3 vertices...
		side1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		side2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
		side3 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

		// adding all the 3 side to find the perimeter...
		traianglePerimeter = side1 + side2 + side3;
		return traianglePerimeter;

	}

}