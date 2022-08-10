import org.junit.jupiter.api.Test;

import ru.netology.Ticket;
import ru.netology.TicketsManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketsManagerTest {

    Repository repository = new Repository();
    TicketsManager manager = new TicketsManager(repository);
    Ticket ticket1 = new Ticket(1,18000, "SVO","SSH", 280);
    Ticket ticket2 = new Ticket(2,45000, "DME","BHN", 360);
    Ticket ticket3 = new Ticket(3,42000, "LED","DXB", 350);
    Ticket ticket4 = new Ticket(4,5000, "SVO","SVX", 150);
    Ticket ticket5 = new Ticket(5,16000, "SVO","SSH", 280);


    //найти все
    @Test
    public void shouldFindAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);

    }


    //поиск и сортировка
    @Test
    public void shouldFindAndSortTickets(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findTickets("SVO","SSH");
        Ticket[] expected = {ticket5, ticket1};

        assertArrayEquals(expected, actual);

    }

    //удаление
    @Test
    public void shouldRemoveByID(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.removeByID(3);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};

        assertArrayEquals(expected, actual);


    }
}
