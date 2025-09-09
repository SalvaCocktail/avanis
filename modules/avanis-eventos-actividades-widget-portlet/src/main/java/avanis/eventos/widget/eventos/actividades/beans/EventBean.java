package avanis.eventos.widget.eventos.actividades.beans;

import com.liferay.calendar.model.CalendarBooking;
import avanis.calendarbooking.sb.model.BookingAgenda;
import avanis.calendarbooking.sb.model.Protagonist;

import java.util.List;

public class EventBean {

    CalendarBooking calendarBooking;
    List<BookingAgenda> bookingAgenda;
    Protagonist protagonist;


    public CalendarBooking getCalendarBooking() {
        return calendarBooking;
    }

    public void setCalendarBooking(CalendarBooking calendarBooking) {
        this.calendarBooking = calendarBooking;
    }

    public List<BookingAgenda> getBookingAgenda() {
        return bookingAgenda;
    }

    public void setBookingAgenda(List<BookingAgenda> bookingAgenda) {
        this.bookingAgenda = bookingAgenda;
    }


    public Protagonist getProtagonists() {
        return protagonist;
    }

    public void setProtagonist(Protagonist protagonist) {
        this.protagonist = protagonist;
    }

}
