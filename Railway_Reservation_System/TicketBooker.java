import java.util.*;

public class TicketBooker{
    static int availableLowerBerths = 1;
    static int availableMiddleBerths = 1;
    static int availableUpperBerths = 1;
    static int availableRac = 1;
    static int availableWaitinglist = 1;

    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));

    static Map<Integer, Passenger> passengers = new HashMap<>();

    public void bookTicket(Passenger p, int berthInfo, String allotedBerth){
        p.number = berthInfo;
        p.alloted = allotedBerth;

        passengers.put(p.passengerId, p);
        bookedTicketList.add(p.passengerId);
        System.out.println("---------------Booked Successfully!\n For PassengerId: " + p.passengerId);
    }

    public void addToRac(Passenger p, int racInfo, String allotedRac){
        p.number = racInfo;
        p.alloted = allotedRac;

        passengers.put(p.passengerId,p);
        racList.add(p.passengerId);
        availableRac--;
        racPositions.remove(0);

        System.out.println("---------------------added to RAc Successfully!\n For PassengerId: " + p.passengerId);
    }

    public void addToWaitinglist(Passenger p, int waitingInfo, String allotedWaiting){
        p.number = waitingInfo;
        p.alloted = allotedWaiting;

        passengers.put(p.passengerId, p);
        waitingList.add(p.passengerId);
        availableWaitinglist--;
        waitingListPositions.remove(0);

        System.out.println("------------------added to Waiting List ASuccessfully!\n For PassengerId: " + p.passengerId);
    }

    public void cancelTicket(int passengerId){
        Passenger p = passengers.get(passengerId);
        passengers.remove(Integer.valueOf(passengerId));
        int positionBooked = p.number;
        System.out.println("--------------------Ticket Cancelled Successfully");

        if(p.alloted.equals("L")){
            availableLowerBerths++;
            lowerBerthPositions.add(positionBooked);
        }
        else if(p.alloted.equals("M")){
            availableMiddleBerths++;
            middleBerthPositions.add(positionBooked);
        }
        else if(p.alloted.equals("U")){
            availableUpperBerths++;
            upperBerthPositions.add(positionBooked);
        }

        if(racList.size() > 0){
            Passenger passengerFromRac = passengers.get(racList.poll());
            int positionRac = passengerFromRac.number;
            racPositions.add(positionRac);
            racList.remove(Integer.valueOf(passengerFromRac.passengerId));
            availableRac++;
       

            if(waitingList.size() > 0){
                Passenger passengerFromWaitinglist = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitinglist.number;
                waitingListPositions.add(positionWL);
                waitingList.remove(Integer.valueOf(passengerFromWaitinglist.passengerId));

                passengerFromWaitinglist.number = racPositions.get(0);
                passengerFromWaitinglist.alloted = "RAC";
                racPositions.remove(0);
                racList.add(passengerFromWaitinglist.passengerId);

                availableWaitinglist++;
                availableRac--;
            }
            Main.bookTicket(passengerFromRac);
        }
    }

    public void printAvailable(){
        System.out.println("Available Lower Berths "+availableLowerBerths);
        System.out.println("Available Middle Berths "+availableMiddleBerths);
        System.out.println("Available Upper Berths "+availableUpperBerths);
        System.out.println("Available RAC "+availableRac);
        System.out.println("Available Waiting List "+availableWaitinglist);
        System.out.println("---------------------------------------- ");
    }

    public void printPassengers(){
        if(passengers.size() == 0){
            System.err.println("No details of Passengers available");
            return;
        }

        for(Passenger p: passengers.values()){
            System.out.println("Passenger Id: "+p.passengerId);
            System.out.println("Passenger Name: "+p.name);
            System.out.println("Passenger Age: "+p.age);
            System.out.println("Passenger Status: "+p.number + p.alloted);
            System.out.println("-------------------------------------");
        }
        
    }

}  