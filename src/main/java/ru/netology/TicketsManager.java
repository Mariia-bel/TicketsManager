package ru.netology;

import lombok.Data;
import ru.netology.repository.Repository;

import java.util.Arrays;

@Data

public class TicketsManager {
    private Repository repository;
    public TicketsManager(Repository repository){
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeByID(int id){
        repository.removeById(id);
    }

    public Ticket[] findTickets(String departure, String arrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDeparture().equals(departure) &&
                    ticket.getArrival().equals(arrival)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
