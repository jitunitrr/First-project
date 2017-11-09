class Shape {
	private double x;
	private double y;

	public Shape() {

		this.x = 0;
		this.y = 0;
	}

	public Shape(double x, double y) {

		this.x = x;
		this.y = y;
	}

	double getX() {
		return this.x;
	}

	double getY() {
		return this.y;
	}

	double setX(double x) {

		this.x = x;
		return this.x;
	}

	double setY(double y) {
		this.y = y;

		return this.y;
	}

	private double area() {
		return 0;
	}

	private double perimeter() {
		return 0;
	}

	public void finalize() {

		System.out.println("finalize Shape");
	}
}
