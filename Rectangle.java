public class Rectangle{
	private double height;
	private double width;
	private String upperLeftCoordinates;
	
	
	//default constructor 
	Rectangle(){
		height=0;
		width=0;
		upperLeftCoordinates="(0,0)";
	}
	//overriding the toString() method  
		public String toString(){
			  return  upperLeftCoordinates+ "("+width+","+height+") ";  
			 } 
//parameterized constructor 
	public Rectangle(double height, double width) {
		super();
		this.upperLeftCoordinates = upperLeftCoordinates="("+width+","+height+")";;
		this.height = height;
		this.width = width;
	}
	
	//Getter for the class fields...
	
	public String getUpperLeftCoordinates() {
		return upperLeftCoordinates;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	
	//function that returns the area of rectangle...
	public double RectangleArea() {
		double rectangleArea;
		rectangleArea=height*width;
		return rectangleArea;
	}
	
	//function that returns the perimeter of a rectangle...
	public double RectanglePerimeter(){
		double rectanglePerimeter;
		rectanglePerimeter=2*(width+height);
		return rectanglePerimeter;
	}
	
}  








































