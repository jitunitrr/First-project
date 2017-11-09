
class Polygon {
	private double verticesX[];
	private double verticesY[];
	private int numberOfVertices;
	public Polygon() {}
	public Polygon(double[] verticesX, double[] verticesY) {
		this.verticesX = verticesX;
		this.verticesY = verticesY;
	}
	public double[] getVerticesX() {
		return verticesX;
	}
	
	public double[] getVerticesY() {
		return verticesY;
	}
	public void setVertices(double[] verticesX,double[] verticesY) {
		this.verticesX = verticesX;
		this.verticesY = verticesY;
	}
	int getNVertices(){
		return numberOfVertices;
	}
	public double area(){
		double calc=0;
		int N=verticesX.length;
		for(int i=0;i<verticesX.length;i++){
			calc=calc+((verticesX[i%N] * verticesY[(i+1)%N])-(verticesX[(i+1)%N] * verticesY[i%N]));
		}
		calc=calc/2;
		calc=Math.abs(calc);
		return calc;
	}
	public double perimeter(){
		double calc=0;
		int N=verticesX.length;
		for(int i=0;i<verticesX.length;i++){
            double xx1=(verticesX[i%N]-verticesX[(i+1)%N] )* (verticesX[i%N]-verticesX[(i+1)%N]);
            double yy1=(verticesY[(i)%N] * verticesY[(i+1)%N]) * (verticesY[(i)%N] * verticesY[(i+1)%N]);
			calc=calc+Math.sqrt(xx1+yy1);
		}
		return calc;
	}
	public String toString(){
	String XY="";
		for(int i=0;i<verticesX.length;i++){
			XY=XY+"("+verticesX[i]+","+verticesY[i]+") \n";
		}
	return XY;
	
	}
}
