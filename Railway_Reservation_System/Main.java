import java.util.*;

public class Main{

    public static void bookTicket(Passenger p){
        TicketBooker booker = new TicketBooker();

        if(TicketBooker.availableWaitinglist == 0){
            System.out.println("No Tickets Available---------------");
        }

        if((p.berthPreference.equals("L") && TicketBooker.availableLowerBerths > 0)||
        (p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths > 0) ||
        (p.berthPreference.equals("U") && TicketBooker.availableUpperBerths >0)){
            System.out.println("Preferred Berth Available !");

            if(p.berthPreference.equals("L")){
                System.out.println("Lower Berth is Given");

                booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");

                TicketBooker.lowerBerthPositions.remove(0);
                TicketBooker.availableLowerBerths--;
            }
            else if(p.berthPreference.equals("M")){
                System.out.println("Middle Berth is given");

                booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");

                TicketBooker.middleBerthPositions.remove(0);
                TicketBooker.availableMiddleBerths--;
            }
            else if (p.berthPreference.equals("U")) {
                System.out.println("Upper Berth is Given");

                booker.bookTicket(p, (TicketBooker.upperBerthPositions.get(0)),"U");
                TicketBooker.upperBerthPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            }
            
        }

        else if(TicketBooker.availableLowerBerths > 0){
            System.out.println("Lower Berth Given");

            booker.bookTicket(p, (TicketBooker.lowerBerthPositions.get(0)), "L");
            TicketBooker.lowerBerthPositions.remove(0);
            TicketBooker.availableLowerBerths--;
        }
        else if(TicketBooker.availableMiddleBerths > 0){
            System.out.println("Middle Berth Given");

            booker.bookTicket(p, (TicketBooker.middleBerthPositions.get(0)), "M");

            TicketBooker.middleBerthPositions.remove(0);
            TicketBooker.availableMiddleBerths--;
        }
        else if(TicketBooker.availableUpperBerths > 0){
            System.out.println("Upper Berth Given");

            booker.bookTicket(p, (TicketBooker.upperBerthPositions.get(0)), "U");

            TicketBooker.upperBerthPositions.remove(0);
            TicketBooker.availableUpperBerths--;
        }
        else if(TicketBooker.availableRac > 0){
                System.out.println("RAC Available");
                booker.addToRac(p, (TicketBooker.racPositions.get(0)),"RAC");
        }
        else if(TicketBooker.availableWaitinglist > 0){
            System.out.println("Waiting List Available");
            booker.addToWaitinglist(p, (TicketBooker.waitingListPositions.get(0)),"WL");
        }

    }

    public static void cancelTicket(int id){
        TicketBooker booker = new TicketBooker();

        if(!booker.passengers.containsKey(id)){
            System.out.println("Passenger Details unknown");
        }
        else{
            booker.cancelTicket(id);
        }
    }


    
    
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Available Tickets\n4.Booked Tickets\n5.Exit");
            int choice = scan.nextInt();

            switch(choice){

                case 1:{
                    System.out.println("Enter Passenger Details ---Name, Age, Berth Prefernces--- :");
                    String name = scan.next();
                    int age = scan.nextInt();
                    String berthPreference = scan.next();
                    Passenger p = new Passenger(name,age,berthPreference);
                    bookTicket(p);

                }
                break;
                case 2:{
                    System.out.println("Enter Passenger Id to cancel:");
                    int id = scan.nextInt();
                    cancelTicket(id);
                }
                break;
                case 3:{
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                case 4:{
                    TicketBooker booker = new TicketBooker();
                    booker.printPassengers();
                }
                break;
                case 5:
                    loop=false;
                default:
                break;
            }
        }
        
    }
}