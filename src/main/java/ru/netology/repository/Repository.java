package ru.netology.repository;
import lombok.Data;
import ru.netology.Ticket;

public class Repository {

    private Ticket[] tickets = new Ticket[0];
    // добавить
    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length -1] = ticket;
        tickets = tmp;
    }
    // показать все
    public Ticket[] findAll() {
        return tickets;
    }
    // удалить
    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
                tickets = tmp;
            }

        }
    }



}
