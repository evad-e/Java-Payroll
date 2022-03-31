
import java.time.LocalTime;
public class Time {
  private LocalTime timeIn;
  private LocalTime timeOut;


  public Time(){
    this.timeIn = null;
    this.timeOut = null;
   
  }
  public Time(LocalTime timeIn, LocalTime timeOut) {
    this.timeIn = timeIn;
    this.timeOut = timeOut;
   
  }
  public LocalTime getTimeIn() {
    return timeIn;
  }
  public void setTimeIn(LocalTime timeIn) {
    this.timeIn = timeIn;
  }
  public LocalTime getTimeOut() {
    return timeOut;
  }
  public void setTimeOut(LocalTime timeOut) {
    this.timeOut = timeOut;
  }
  

}
