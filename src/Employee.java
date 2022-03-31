import java.util.StringJoiner;

public class Employee{
  private String name;
  private String code;
  private String level;
  private double rate;
  private double workHours;

  public Employee(String name, String code, String level, float workHours){
    this.name = name;
    this.code = code;
    this.level = level;
    this.workHours = workHours;
  }
  public Employee(String name, String code, String level){
    this.name = name;
    this.code = code;
    this.level = level;
    setRate(level);
  }
  public String getName(){
    return name;
  }
  public String getCode(){
    return code;
  }
  public String getLevel(){
    return level;
  }
  public double getRate(){
    return rate;
  }
  public double getWorkHours(){
    return workHours;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setCode(String code){
    this.code = code;
  }
  public void setLevel(String level){
    this.level = level;
  }
  public void setRate(String level){
    switch (level) {
      case "1":
        this.rate = 380.00;
        break;
      case "2":
        this.rate = 450.00;
        break;
      case "3":
        this.rate = 550.00;
      default:
        break;
    }
  }
  public void setWorkHours(float workHours){
    this.workHours = workHours;
  }

}
