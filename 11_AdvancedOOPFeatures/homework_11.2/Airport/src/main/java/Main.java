import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
          printListFlight(findPlanesLeavingInTheNextTwoHours(airport));
    }
    static void printListFlight(List<Flight> list){
        for (Flight element : list) {
            System.out.println(element);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> list = airport
                .getTerminals()
                .stream().flatMap(terminal -> terminal.getFlights().stream()
                        .filter(e -> e.getType() == Flight.Type.DEPARTURE))
                .filter(e -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.HOUR,2);
                    return   e.getDate().after(new Date()) && e.getDate().before(calendar.getTime());
                })
                .collect(Collectors.toList());
        for (Flight element : list) {
            System.out.println(element);
        }return list;
    }
}

/**       List<Terminal> allTerminal =  Airport.getInstance().getTerminals();
 for (int i = 0; i < allTerminal.size(); i++) {
 List<Flight> flightTerminal = allTerminal.get(i).getFlights();
 System.out.println("Terminal: " + allTerminal.get(i).getName() + "\n--------------------------------\n");
 flightTerminal.stream().filter((e) -> e.getType() == Flight.Type.DEPARTURE)
 .filter(e -> {
 Calendar calendar = Calendar.getInstance();
 calendar.add(Calendar.HOUR,2);
 return   e.getDate().after(new Date()) && e.getDate().before(calendar.getTime());
 }).forEach(System.out::println);
 }
 */