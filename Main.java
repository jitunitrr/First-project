
class MyFinalize
	{
	  public  void finalize() { System.out.println("finalize"); }
	}
public class Main {
	
	public static void main(String[] args) {
		System.out.println("-----------------For Ellipse-----------------------------");
		// creating object of class Ellipse
		Ellipse obj = new Ellipse();
		// Default output
		System.out.println("Ellipse default center coordinate: " + obj.getCenterCoordinates().toString());
		System.out.println("Ellipse default length of Major Axis: " + obj.getLengthMajorAxis());
		System.out.println("Ellipse default length of Minor Axis: " + obj.getLengthMinorAxis());
		System.out.println("Ellipse Area: " + obj.EllipseArea());
		System.out.println("Ellipse perimeter: " + obj.EllipsePerimeter());

		// creating another object of class Ellipse and passing values (2,5.5) as
		// parameter
		Ellipse obj2 = new Ellipse(2, 5.5);
		// output according to value passed i.e (2,5.5)
		System.out.println(obj2);
		System.out.println("\nEclipse parameterized center coordinate: " + obj2.getCenterCoordinates().toString());
		System.out.println("Ellipse length of Major Axis: " + obj2.getLengthMajorAxis());
		System.out.println("Ellipse length of Minor Axis: " + obj2.getLengthMinorAxis());
		System.out.println("Ellipse Area: " + obj2.EllipseArea());
		System.out.println("Ellipse perimeter: " + obj2.EllipsePerimeter());
		new MyFinalize().finalize();

		System.out.println("-----------------For Rectangle-----------------------------");

		// Creating object of Rectangle class...
		Rectangle rect1 = new Rectangle();
		// Display output with default values;
		System.out.println("Rectangle default left upper cordinates: " + rect1.getUpperLeftCoordinates());
		System.out.println("Rectangle default height: " + rect1.getHeight());
		System.out.println("Rectangle default width: " + rect1.getWidth());
		System.out.println("Rectangle Area: " + rect1.RectangleArea());
		System.out.println("Rectangle Perimeter: " + rect1.RectanglePerimeter());

		// Creating another object of Rectangle class and passing (6.9,7.2) as values...
		Rectangle rect2 = new Rectangle(6.9, 7.2);
		// Displaying Output according to values i.e (6.9,7.2)..
		System.out.println(rect2);
		System.out.println("\nRectangle left upper cordinates: " + rect2.getUpperLeftCoordinates());
		System.out.println("Rectangle height: " + rect2.getHeight());
		System.out.println("Rectangle width: " + rect2.getWidth());
		System.out.println("Rectangle Area: " + rect2.RectangleArea());
		System.out.println("Rectangle Perimeter: " + rect2.RectanglePerimeter());
		new MyFinalize().finalize();

		System.out.println("----------------For Tiangle------------------------------");

		// Creating object of Triangle class..
		Triangle tri1 = new Triangle();
		System.out.println("\nTriangle default cordinates: " + tri1.getFirstVertices() + "," + tri1.getSecondVertices()
				+ "," + tri1.getThirdVertices());
		System.out.println("Triangle default Area: " + tri1.TriangleArea());
		System.out.println("Triangle default Perimeter: " + tri1.TrianglePerimeter());

		// Creating another object of Triangle class and passing value
		// (15,15),(23,30),(50,25)..
		Triangle tri2 = new Triangle(15, 15, 23, 30, 50, 25);
		// Display according to the values passed...
		//System.out.println("\nTriangle cordinates: " + tri2.getFirstVertices() + "," + tri2.getSecondVertices() + ","
			//	+ tri2.getThirdVertices());
		System.out.println(tri2);
		System.out.println("Triangle Area: " + tri2.TriangleArea());
		System.out.println("Triangle Perimeter: " + tri2.TrianglePerimeter());
		new MyFinalize().finalize();
		System.out.println("----------------For Polygon------------------------------");

		// Creating object of Triangle class..
		 double verticesX[]={4,9,11,2};
		double verticesY[]={10,7,2,2};
   		Polygon p1=new Polygon(verticesX,verticesY);
    		System.out.println("Co-ordinates of Polygon(X,y)");
    		System.out.println(p1);
    		System.out.println("Area Of Polygon : "+p1.area());
    		System.out.println("Perimeter of polygon: "+p1.perimeter());
		new MyFinalize().finalize();

	}
}
