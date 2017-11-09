
public class TestShapes {

public static void main(String[] args) {
	System.out.println("-----------------For Shape-----------------------------");
	// creating shapeect of class	Shape
	Shape shape = new Shape();
	shape = new Ellipse();
	System.out.println("-----------------For Ellipse-----------------------------");
	// creating shapeect of class Ellipse
	// Default output
	System.out.println("Ellipse default center coordinate: " + ((Ellipse) shape).getCenterCoordinates().toString());
	System.out.println("Ellipse default length of Major Axis: " + ((Ellipse) shape).getLengthMajorAxis());
	System.out.println("Ellipse default length of Minor Axis: " + ((Ellipse) shape).getLengthMinorAxis());
	System.out.println("Ellipse Area: " + ((Ellipse) shape).EllipseArea());
	System.out.println("Ellipse perimeter: " + ((Ellipse) shape).EllipsePerimeter());

	// creating another shapeect of class Ellipse and passing values (2,5.5) as
	// parameter
	shape = new Ellipse(2, 5.5);
	// output according to value passed i.e (2,5.5)
	System.out.println(shape);
	System.out.println("\nEclipse parameterized center coordinate: " + ((Ellipse) shape).getCenterCoordinates().toString());
	System.out.println("Ellipse length of Major Axis: " + ((Ellipse) shape).getLengthMajorAxis());
	System.out.println("Ellipse length of Minor Axis: " + ((Ellipse) shape).getLengthMinorAxis());
	System.out.println("Ellipse Area: " + ((Ellipse) shape).EllipseArea());
	System.out.println("Ellipse perimeter: " + ((Ellipse) shape).EllipsePerimeter());
	shape.finalize();

	System.out.println("-----------------For Rectangle-----------------------------");

	// Creating shapeect of Rectangle class...
	shape = new Rectangle();
	// Display output with default values;
	System.out.println("Rectangle default left upper cordinates: " + ((Rectangle) shape).getUpperLeftCoordinates());
	System.out.println("Rectangle default height: " + ((Rectangle) shape).getHeight());
	System.out.println("Rectangle default width: " + ((Rectangle) shape).getWidth());
	System.out.println("Rectangle Area: " + ((Rectangle) shape).RectangleArea());
	System.out.println("Rectangle Perimeter: " + ((Rectangle) shape).RectanglePerimeter());

	// Creating another shapeect of Rectangle class and passing (6.9,7.2) as values...
	shape = new Rectangle(6.9, 7.2);
	// Displaying Output according to values i.e (6.9,7.2)..
	System.out.println(shape);
	System.out.println("\nRectangle left upper cordinates: " + ((Rectangle) shape).getUpperLeftCoordinates());
	System.out.println("Rectangle height: " + ((Rectangle) shape).getHeight());
	System.out.println("Rectangle width: " + ((Rectangle) shape).getWidth());
	System.out.println("Rectangle Area: " + ((Rectangle) shape).RectangleArea());
	System.out.println("Rectangle Perimeter: " + ((Rectangle) shape).RectanglePerimeter());
	shape.finalize();

	System.out.println("----------------For Tiangle------------------------------");

	// Creating shapeect of Triangle class..
	Polygon tri1 = new Triangle();
	System.out.println("\nTriangle default cordinates: " + ((Triangle) tri1).getFirstVertices() + "," + ((Triangle) tri1).getSecondVertices()
			+ "," + ((Triangle) tri1).getThirdVertices());
	System.out.println("Triangle default Area: " + ((Triangle) tri1).TriangleArea());
	System.out.println("Triangle default Perimeter: " + ((Triangle) tri1).TrianglePerimeter());

	// Creating another shapeect of Triangle class and passing value
	// (15,15),(23,30),(50,25)..
	tri1= new Triangle(15, 15, 23, 30, 50, 25);
	// Display according to the values passed...
	//System.out.println("\nTriangle cordinates: " + tri1.getFirstVertices() + "," + tri1.getSecondVertices() + ","
		//	+ tri1.getThirdVertices());
	System.out.println(tri1);
	System.out.println("Triangle Area: " + ((Triangle) tri1).TriangleArea());
	System.out.println("Triangle Perimeter: " + ((Triangle) tri1).TrianglePerimeter());
	tri1.finalize();
	System.out.println("----------------For Polygon------------------------------");

	// Creating shapeect of Triangle class..
	 double verticesX[]={4,9,11,2};
	double verticesY[]={10,7,2,2};
		shape =new Polygon(verticesX,verticesY);
		System.out.println("Co-ordinates of Polygon(X,y)");
		System.out.println(((Polygon)shape));
		System.out.println("Area Of Polygon : "+((Polygon)shape).area());
		System.out.println("Perimeter of polygon: "+((Polygon)shape).perimeter());
		shape.finalize();

}
}