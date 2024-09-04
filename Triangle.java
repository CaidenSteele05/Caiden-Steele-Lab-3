
public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	public final static String POLYGONSHAPE = "Triangle";
	public final static double DEFAULT_SIDE = 1;
	
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		boolean valid = isTriangle(sideA, sideB, sideC);
		this.sideA = valid ? sideA : DEFAULT_SIDE;
		this.sideB = valid ? sideB : DEFAULT_SIDE;
		this.sideC = valid ? sideC : DEFAULT_SIDE;
	}
	
	public Triangle(double[] sides) {
		boolean valid = isTriangle(sides);
		sideA = valid ? sides[0] : DEFAULT_SIDE;
		sideB = valid ? sides[1] : DEFAULT_SIDE;
		sideC = valid ? sides[2] : DEFAULT_SIDE;
	}
	
	public Triangle(Triangle tri) {
		boolean valid = tri != null;
		this.sideA = valid ? tri.getSideA() : DEFAULT_SIDE;
		this.sideB = valid ? tri.getSideB() : DEFAULT_SIDE;
		this.sideC = valid ? tri.getSideC() : DEFAULT_SIDE;
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		return a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b;
	}
	
	public static boolean isTriangle(double[] sides) {
		return sides != null && sides.length == 3 ? isTriangle(sides[0],sides[1],sides[2]): false;
	}

	public boolean setSideA(double sideA) {
		boolean valid = isTriangle(sideA,sideB,sideC);
		this.sideA = valid ? sideA : this.sideA;
		return valid;
	}
	
	public double getSideA() {
		return sideA;
	}


	public double getSideB() {
		return sideB;
	}

	public boolean setSideB(double sideB) {
		boolean valid = isTriangle(sideA,sideB,sideC);
		this.sideB = valid ? sideB : this.sideB;
		return valid;
	}

	public double getSideC() {
		return sideC;
	}

	public boolean setSideC(double sideC) {
		boolean valid = isTriangle(sideA,sideB,sideC);
		this.sideC = valid ? sideC : this.sideC;
		return valid;
	}
	
	public double[] getSides() {
		return new double[] {sideA, sideB, sideC};
	}
	
	public boolean setSides(double[] sides) {
		boolean valid = isTriangle(sides);
		sideA = valid ? sides[0]: sideA;
		sideB = valid ? sides[1]: sideB;
		sideC = valid ? sides[2]: sideC;
		return valid;
	}
	
	public double getAngleA() {
		return lawOfCosines(sideB,sideC,sideA);
	}
	
	public double getAngleB() {
		return lawOfCosines(sideA,sideC,sideB);
	}
	
	public double getAngleC() {
		return lawOfCosines(sideB,sideA,sideC);
	}
	
	public double[] getAngles() {
		return new double[] {getAngleA(),getAngleB(),getAngleC()};
	}
	
	public static double lawOfCosines(double a, double b, double c) {
		return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
	}
	
	public String toString() {
		return String.format("%s(%.4f, %.4f, %.4f)", POLYGONSHAPE,sideA,sideB,sideC);
	}
}
