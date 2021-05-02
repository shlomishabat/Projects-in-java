/**
 * This class describe a point parameter.
 * @author Shlomi Shabat
 * @version v.0.0.1
 */
public class Point
{
    private double _x;
    private double _y;
    /**
     * This is a constructor that create new object from type point.
     * @param x value of x coordinate.
     * @param y  value of y coordinate.
     */
    public Point(double x, double y)
    {
        _x=x;
        _y=y;
    }

    /**
     * This is a constructor that duplicate object parameters from type point.
     * @param other point for duplicate.
     */
    public Point(Point other)
    {
        _y=other._y;
        _x=other._x;
    }

    /**
     * This method return x value of the point.
     * @return the x value of the point.
     */
    public double getX()
    {
        return _x;
    }

    /**
     * This method return y value of the point.
     * @return the y value of the point.
     */
    public double getY()
    {
        return _y;
    }

    /**
     * This method change the x value of the point if legit.
     * @param num is the value for change.
     */
    public void setX(double num)
    {
        if(num>0)
            _x=num;
    }

    /**
     * This method change the y value of the point if legit.
     * @param num is the value for change.
     */
    public void setY(double num)
    {
        if (num>0)
            _y=num;
    }

    /**
     * This method return the point values.
     * @return the point values.
     */
    public String toString()
    {
        return "("+_x+","+_y+")";
    }

    /**
     * This method Returns whether the point on which the method was applied,
     * is equals the point that obtained as a parameter.
     * @param other point for comparison.
     * @return true if values are equals.
     */
    public boolean equals(Point other)
    {
        return (other._x == _x && other._y == _y);
    }

    /**
     * This method Returns whether the point on which the method was applied,
     * is above the point obtained as a parameter.
     * @param other is a point that obtained as a parameter for comparison.
     * @return true If the point obtained as a parameter is above the point on which the method was applied.
     */
    public boolean isAbove(Point other)
    {
        return _y>other._y;
    }

    /**
     * This method Returns whether the point on which the method was applied,
     * is under the point obtained as a parameter.
     * @param other is a point that obtained as a parameter for comparison.
     * @return true If the point obtained as a parameter is above the point on which the method was applied.
     */public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /**
     * This method returns trow if the point on which the method was applied,
     * is more close to center from the point obtained as a parameter.
     * @param other Is the point for comparison.
     * @return trow if the point on which the method was applied is more close to center.
     */
    public boolean isLeft(Point other)
    {
        return _x<other._x;
    }

    /**
     * This method returns trow if the point on which the method was applied,
     * is more far from the center from the point obtained as a parameter.
     * @param other Is the point for comparison.
     * @return trow if the point on which the method was applied is more far from the center.
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * This method return the distance between two points.
     * @param p point that obtained as a parameter.
     * @return the distance between two points.
     */
    public double distance (Point p)
    {
        return Math.sqrt(Math.pow((_x-p._x),2)+Math.pow((_y-p._y),2));//Distance formula
    }

    /**
     * This method returns the quarter value where the point is.
     * If the point is on at least one of the axes the method returns 0.
     * @return the quarter value where the point is.
     */
    public int quadrant()
    {
        int num=0;
        if (_x==0 || _y==0)
            return num;
        if (_x>0)
            if (_y>0)
                num=1;
            else num=4;
        if (_x<0)
            if (_y>0)
                num=2;
            else num=3;
        return num;
    }
}
