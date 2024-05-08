package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class TicketCrudServise  {

    private final SessionFactory sessionFactory;

    public TicketCrudServise(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket saveTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ticket);
        return ticket;
    }

    public Ticket getTicketById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }
    public List<Ticket> getAllTickets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Ticket", Ticket.class).list();
    }

    public void deleteTicket(Long id){
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = session.load(Ticket.class, id);
        session.delete(ticket);
    }

}
