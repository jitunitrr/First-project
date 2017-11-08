
public class Polygon {
	double verticesX[];
	double verticesY[];
	int numberOfVertices;
	public Polygon() {}
	public Polygon(double[] verticesX, double[] verticesY) {
		super();
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
public String toString(){
	String XY="";
	for(int i=0;i<verticesX.length;i++){
		XY=XY+"("+verticesX[i]+","+verticesY[i]+") \n";
	}
		return XY;
	
}
}
