public class MyDate {
  int day;
  int year;
  int month;

  public MyDate() {

  }

  public MyDate(int m, int d, int y) {
    setDate(m, d, y);
  }

  public String toString() {
    return (month + "/" + day + "/" + year);
  }

  public void setDate(int m, int d, int y) {
    day = d;
    year = y;
    month = m;
  }

}
