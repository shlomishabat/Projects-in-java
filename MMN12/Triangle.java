/**
 * This class discribe a Teingle parameter.
 * @author Shlomi Shabat
 * @version v.0.0.1
 */
public class Triangle {
    private Point _point1;
    private Point _point2;
    private Point _point3;
    public static final double EPSILON = 0.001;
    /**
     * Construct a new Triangle (default constructor)
     * from 3 default Points:(1,0),(-1,0),(0,1)
     * And calculates the distances between the points.
     */
    public Triangle()
    {
        _point1 = new Point(1, 0);
        _point2 = new Point(-1, 0);
        _point3 = new Point(0, 1);
    }

    /**
     * Construct a new Triangle (from 3 points)
     * @param  p1 the first point of the Triangle.
     * @param  p2 the second point of the Triangle.
     * @param  p3 the third point of the Triangle.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        this();
        if (isValid(p1, p2, p3)) {
            _point1 = new Point(p1);
            _point2 = new Point(p2);
            _point3 = new Point(p3);
        }
    }

    /**
     * Construct a new Triangle (from 6 reals).
     * @param  y1 the y value of the first point of the Triangle.
     * @param  x1 the x value of the first point of the Triangle.
     * @param  y2 the y value of the second point of the Triangle.
     * @param  x2 the x value of the second point of the Triangle.
     * @param  y3 the y value of the third point of the Triangle.
     * @param  x3 the x value of the third point of the Triangle.
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        this();
        if (isValid(new Point(x1, y1), new Point(x2, y2),new Point(x3, y3)))
        {
            _point1 = new Point(x1, y1);
            _point2 = new Point(x2, y2);
            _point3 = new Point(x3, y3);
        }

    }

    /**
     * Copy constructor Creates a new triangle identical to the given triangle
     * @param  other A proper Triangle.
     */
    public Triangle(Triangle other)
    {
        _point1 = new Point(other._point1);
        _point2 = new Point(other._point2);
        _point3 = new Point(other._point3);

    }

    /**
     * This method returns the triangle's first point
     * @return the first point of the Triangle.
     */
    public Point getPoint1()
    {
        return new Point(_point1);
    }

    /**
     * This method returns the triangle's second point
     * @return the second point of the Triangle.
     */
    public Point getPoint2()
    {
        return new Point(_point2);
    }

    /**
     *  This method returns the triangle's third point
     * @return the third point of the Triangle.
     */
    public Point getPoint3()
    {
        return new Point(_point3);
    }

    /**
     * This method sets the first point of the triangle.
     * @param p1 the new point values for the first point.
     */
    public void setPoint1(Point p1)
    {
        if (isValid(p1, _point2, _point3))
            _point1 = new Point(p1);
    }

    /**
     * This method sets the second point of the triangle.
     * @param p2 the new point values for the second point.
     */
    public void setPoint2(Point p2)
    {
        if (isValid(_point1, p2, _point3))
            _point2 = new Point(p2);
    }

    /**
     * This method sets the first point of the triangle.
     * @param p3 the new point values for the third point.
     */
    public void setPoint3(Point p3)
    {
        if (isValid(_point1, _point2, p3))
            _point3 = new Point(p3);
    }

    /**
     * This method return true if the points can become a Triangle object.
     * @param p1 first point value.
     * @param p2 second point value.
     * @param p3 third point value.
     * @return true if the points can become a Triangle object.
     */
    public boolean isValid(Point p1, Point p2, Point p3)
    {
        if (validMathCheck(p1,p2,p3) ||//calculates whether the length of the ribs can hold a triangle
        internelPointCheck(p1,p2,p3))//checks that the points are not on the same line in the system of axes
            return false;
        else
            return true;

    }

    /**
     * The method calculates whether the length of the ribs can hold a triangle
     * @param p1 first point value.
     * @param p2 second point value.
     * @param p3 third point value.
     * @return true if the length of the ribs can hold a triangle
     */
    private boolean validMathCheck(Point p1,Point p2,Point p3){
        double sumValid =lengthP(p1,p2) + lengthP(p2,p3) + lengthP(p3,p1);
        if (Math.abs(sumValid-(lengthP(p1,p2)*2.0))<EPSILON || //If has to the triangle a rib that is equal to the sum of the other two ribs
        Math.abs(sumValid-(lengthP(p2,p3)*2.0))<EPSILON ||
        Math.abs(sumValid-(lengthP(p3,p1)*2.0))<EPSILON)
            return true;
        else return false;
    }

    /**
     * The method returns the length between two points
     * @param p1 first point value.
     * @param p2 second point value.
     * @return the length between two points
     */
    private double lengthP(Point p1,Point p2){
        return p1.distance(p2);
    }

    /**
     * The method checks that the points are not on the same line in the system of axes.
     * @param p1 first point value.
     * @param p2 second point value.
     * @param p3 third point value.
     * @return true if the points are on the same line in the system of axes.
     */
    private boolean internelPointCheck(Point p1, Point p2, Point p3){
        if (p1.getX()==p1.getY()&&p2.getX()==p2.getY() && p3.getX()==p3.getY())//Checking if the three points are on the same diagonal
            return true;
        if (p1.getX()==p2.getX()&& p2.getX()==p3.getX())//Checks to see if the X-points are on the same straight
            return true;
        if (p1.getY()==p2.getY()&& p2.getY()==p3.getY())//Checks to see if the Y-points are on the same straight
            return true;

        else return false;
    }

    /**
     *  This method returns a String representation of thet Triangle.
     * @return the Triangle details.
     */
    public String toString()
    {
        return "{" + _point1 + "," + _point2 + "," + _point3 + "}";
    }

    /**
     * This method return the Triangle perimeter.
     * @return the Triangle perimeter.
     */
    public double getPerimeter()
    {
        return (lengthSide1() + lengthSide2() + lengthSide3());
    }

    /**
     * This method return the Triangle area.
     * @return the Triangle area.
     */
    public double getArea()
    {
        double s = (lengthSide1() + lengthSide2() + lengthSide3()) / 2;
        return Math.sqrt(s *(s- lengthSide1()) * (s - lengthSide2()) * (s - lengthSide3()));//Heron equation
    }

    /**
     * This method return true if the Triangle is isosceles.
     * @return true if the Triangle is isosceles.
     */
    public boolean isIsosceles()
    {
        if (Math.abs(lengthSide1()-lengthSide2())<EPSILON ||
        Math.abs(lengthSide2()-lengthSide3())<EPSILON ||
        Math.abs(lengthSide3()-lengthSide1())<EPSILON )//Shortness between ribs
            return true;
        else
            return false;
    }

    /**
     * This method return the distance between point 1 and point 2 of local triangle object.
     * @return point 1 and point 2 distance.
     */
    private double lengthSide1(){
        return _point1.distance(_point2);
    }

    /**
     * This method return the distance between point 2 and point 3 of local triangle object.
     * @return point 2 and point 3 distance.
     */
    private double lengthSide2(){
        return _point2.distance(_point3);
    }

    /**
     * This method return the distance between point 3 and point 1 of local triangle object.
     * @return point 3 and point 1 distance.
     */
    private double lengthSide3(){
        return _point3.distance(_point1);
    }

    /**
     * This method return true if the Triangle is Pythagorean.
     * @return true if the Triangle is Pythagorean.
     */
    public boolean isPythagorean()
    {
        if (Math.pow(lengthSide1(),2)+Math.pow(lengthSide2(),2)-Math.pow(lengthSide3(),2)<EPSILON)//Pythagorean theorem
            return true;
        else if (Math.pow(lengthSide1(),2)+Math.pow(lengthSide3(),2)-Math.pow(lengthSide2(),2)<EPSILON)//Pythagorean theorem
            return true;
        else if (Math.pow(lengthSide2(),2)+Math.pow(lengthSide3(),2)-Math.pow(lengthSide1(),2)<EPSILON)//Pythagorean theorem
            return true;
        else return false;
    }

    /**
     * This method return true if the Triangle is Contained In Circle.
     * @param x value of the center point of the Circle.
     * @param y value of the center point of the Circle.
     * @param r value of the radius of the Circle.
     * @return true if the Triangle is Contained In Circle.
     */
    public boolean isContainedInCircle(double x,double y,double r)
    {
        Point center =new Point(x,y);
        if (r-_point1.distance(center)>=EPSILON &&
        r-_point2.distance(center)>=EPSILON &&
        r-_point3.distance(center)>=EPSILON)//Compares rib size to radius
            return true;
        else return false;
    }

    /**
     * This method returns the lowest vertex of the triangle.
     * @return the lowest Point,in case of two equal lowest point return the leftest one.
     */
    public Point lowestPoint()
    {
        String low="low";
        Point lowest2Point=twoPointComper(_point1,_point2,low);
        return twoPointComper(lowest2Point,_point3,low);
    }

    /**
     * This method returns the highest vertex of the triangle.
     * @return the highest Point,in case of two equal lowest point return the leftest one.
     */
    public Point highestPoint(){
        String high="high";
        Point highest2Point=twoPointComper(_point1,_point2,high);
        return twoPointComper(highest2Point,_point3,high);
    }

    /**
     * This method compere two points and return The highest or lowest on demand.
     * in case of two equal points return the leftest one.
     * @param p1 the first point to compere.
     * @param p2 the second point to compere.
     * @param lowOrHigh Represents which point I should return.
     * @return Or the lowest or the highest between two points,in case of two equal points return the leftest one.
     */
    private Point twoPointComper(Point p1 ,Point p2,String lowOrHigh){
        if(lowOrHigh=="low")
            if (p1.isUnder(p2))//compering tow points
                return new Point(p1);
            else if (p1.isAbove(p2))
                return new Point(p2);
            else
                return leftPoint(p1,p2);//if the y param is equals
        if (lowOrHigh=="high")
            if (p1.isAbove(p2))
                return new Point(p1);
            else if (p1.isUnder(p2))
                return new Point(p2);
            else
                return leftPoint(p1,p2);
        return new Point(p1);
    }

    /**
     * This method return The leftest point between two points.
     * @param p1 the first point to compere.
     * @param p2 the second point to compere.
     * @return The leftest point between two points.
     */
    private Point leftPoint(Point p1,Point p2){
        if (p1.isLeft(p2))
            return new Point(p1);
        else
            return new Point(p2);
    }

    /**
     * This method Returns whether the triangle on which the method was applied,
     * is above the triangle obtained as a parameter.
     * @param other is a triangle that obtained as a parameter for comparison.
     * @return true If the triangle obtained as a parameter is above the triangle on which the method was applied.
     */
    public boolean isAbove(Triangle other){
        if (_point1.isAbove(other._point1) &&
        _point2.isAbove(other._point2) &&
        _point3.isAbove(other._point3))
            return true;
        else
            return false;
    }

    /**
     * This method Returns whether the triangle on which the method was applied,
     * is under the triangle obtained as a parameter.
     * @param other is a triangle that obtained as a parameter for comparison.
     * @return true If the triangle obtained as a parameter is under the triangle on which the method was applied.
     */
    public boolean isUnder(Triangle other){
        return other.isAbove(this);
    }

    /**
     * This method Returns whether the triangle on which the method was applied,
     * is equals the triangle obtained as a parameter.
     * @param other is a triangle that obtained as a parameter for comparison.
     * @return true If the triangle obtained as a parameter is equals the triangle on which the method was applied.
     */
    public boolean equals(Triangle other){
        if (this._point1.equals(other._point1)&&
        this._point2.equals(other._point2)&&
        this._point3.equals(other._point3))
            return true;
        else return false;
    }

    /**
     * This method Returns whether the triangle on which the method was applied,
     * is congruent the triangle obtained as a parameter.
     * @param other is a triangle that obtained as a parameter for comparison.
     * @return true If the triangle obtained as a parameter is congruent the triangle on which the method was applied.
     */
    public boolean isCongruent(Triangle other){
        if (this.equilateralCheck() && other.equilateralCheck())
            if (Math.abs(this.lengthSide1()-other.lengthSide1())<EPSILON)//Checking the equilibrium of equilateral triangles
                return true;
            else return false;
        else if (this.isIsosceles() && other.isIsosceles())
            if (this.isoscelesCheck(other))//Checking the equality of equilateral triangles
                return true;
            else return false;
        else
            return (this.regularTriangleCack(other));//Checking the equality of ordinary triangles

    }

    /**
     * This method Returns whether the triangle on which the method was applied,
     * is congruent the triangle obtained as a parameter.
     * @param other is a triangle that obtained as a parameter for comparison.
     * @return true If the triangle obtained as a parameter is congruent the triangle on which the method was applied.
     */
    public boolean regularTriangleCack(Triangle other){
        //Tests a rib at a time against all the ribs of the other triangle.
        if (this.lengthComper(other.lengthSide1())&&
        this.lengthComper(other.lengthSide2())&&
        this.lengthComper(other.lengthSide3()))
            return true;
        else
            return false;
    }

    /**
     * This method returns trow if there is at least one side matches the other.
     * @param paramSide Is the length of a rib for comparison.
     * @return trow if there is at least one side matches the other.
     */
    private boolean lengthComper(double paramSide){
        if (Math.abs(lengthSide1()-paramSide)<EPSILON ||
        Math.abs(lengthSide2()-paramSide)<EPSILON ||
        Math.abs(lengthSide3()-paramSide)<EPSILON)
            return true;
        else
            return false;
    }

    private boolean equilateralCheck(){
        if (Math.abs(lengthSide1()-lengthSide2())<EPSILON &&
        Math.abs(lengthSide2()-lengthSide3())<EPSILON &&
        Math.abs(lengthSide3()-lengthSide1())<EPSILON )//Shortness between ribs
            return true;
        else
            return false;
    }

    private boolean isoscelesCheck(Triangle other){
        //Finds the base rib
        double base=Math.min(this.lengthSide1(),Math.min(this.lengthSide2(),this.lengthSide3()));
        //Finding one of the equal sides in an isosceles triangle
        double rib= (lengthSide1()+lengthSide2()+lengthSide3()-base)/2;
        //Compares the base rib to the ribs of the other triangle
        if (Math.abs(base - other.lengthSide1())<EPSILON ||
        Math.abs(base - other.lengthSide2())<EPSILON ||
        Math.abs(base - other.lengthSide3())<EPSILON) {
            //Compares one of the other sides of the other triangle
            if (Math.abs(rib - other.lengthSide1()) < EPSILON ||
            Math.abs(rib - other.lengthSide2()) < EPSILON ||
            Math.abs(rib - other.lengthSide3()) < EPSILON)
                return true;
            else
                return false;
        }
        else
            return false;

    }

    /**
     * This method return trow if the Triangle iS found entirely in only one quarter.
     * @return trow if the Triangle is found entirely in only one quarter.
     */

    public boolean isLocated(){
        //Checks if there is a dot on the hinges
        if(_point1.quadrant()==0 ||_point2.quadrant()==0 || _point3.quadrant()==0)
            return false;
        //Checks whether all points are in the same coordinate
        else if (_point1.quadrant()==_point2.quadrant()&&_point1.quadrant()==_point3.quadrant())
            return true;
        else
            return false;
    }
}
