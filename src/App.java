import java.util.*;
import java.io.*;
import java.time.*;
public class App {
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static ArrayList<Time> times = new ArrayList<Time>();
    static String c_date = "";
    static final String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
    public static void loadEmployeeFile(){
        try{
            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] tokens = line.split(",");
                Employee e = new Employee(tokens[0], tokens[1], tokens[2]);
                employees.add(e);
                line = br.readLine();
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //print all Employees
    }
    public static Employee findEmployee(String code){
        for(Employee e : employees){
            if(e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }
    public static void writeTodtrFile(Employee em){
        try{
            FileWriter fw = new FileWriter("dtr.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(em.getCode());
            for(Time time: times){
                bw.write(","+time.getTimeIn()+","+time.getTimeOut());
            }

            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Time inputDTR(String day){
        Time dtr = new Time();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Time In for " +day+": ");
        dtr.setTimeIn( LocalTime.parse(sc.nextLine()) );
        System.out.print("Enter the Time Out for " +day+": ");
        dtr.setTimeOut( LocalTime.parse(sc.nextLine()) );

        return dtr;
    }
    public static void printBuffer(){
        System.out.println("**************************************");
    }
    public static void printEmployee(Employee e){
        System.out.println("Employee Name: "+e.getName());
        System.out.println("Employee Code: "+e.getCode());
        System.out.println("Employee Level: Level "+e.getLevel());
        System.out.println("Salary Rate: "+e.getRate()+"/day");
    }
    public static double[] addHours(Employee e){
        
        double hours = 0;
        double rate = 0;
        
        for(Time t : times){
            //minus timeOut with timeIn
            LocalTime time = LocalTime.parse("00:00");
            //get difference of timeIn and timeOut
            time = t.getTimeOut().minusHours(t.getTimeIn().getHour()).minusMinutes(t.getTimeOut().getMinute());
           
            hours +=time.getHour();
        }
        rate = e.getRate()*hours;
        double[] hoursDays = {hours,rate};
        return hoursDays;
    }
    public static void displayDtrInfo(Employee e,String c_date){
        printBuffer();
        double [] hourDay = addHours(e);
        System.out.println("Date Covered: "+c_date);
        System.out.println("Total Number of Work Hours: " + hourDay[0]);
        System.out.println("Regular Income: "+ hourDay[1]);
    }
    public static void main(String[] args) throws Exception {

        
        loadEmployeeFile();
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Employee code: ");
        String code = sc.nextLine();
    //finding the employee
        Employee e = findEmployee(code);

        if(e != null){
            printBuffer();
            printEmployee(e);
            printBuffer();
        //input DTR
            
            for(String day: days){
                Time dtr = inputDTR(day.toString());
                times.add(dtr);
                printBuffer();
            }
        //input coverage date
            System.out.print("Enter the coverage date: ");
            c_date = sc.nextLine();
            writeTodtrFile(e);
        //display DTR info
            displayDtrInfo(e,c_date);
        }else{
            System.out.println("Employee not found");
        }
      
    }
        
}

