package validator;

import domain.TicketOrder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TicketOrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TicketOrder.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TicketOrder ticketOrder = (TicketOrder) target;
        if(ticketOrder.getVoetbalCode1() > ticketOrder.getVoetbalCode2()){
            errors.rejectValue("voetbalCode1", "voetbalcode1 moet kleiner zijn dan voetbalcode 2","voetbalcode1 moet kleiner zijn dan voetbalcode 2");
        }
       // if(ticketOrder.getAantalTickets() == ticketOrder.getBeschikbareTickets()){
           // errors.rejectValue("aantalTickets", "Je kocht meer tickets dan er beschikbaar waren", "Je kocht meer tickets dan er beschikbaar waren");
        //}
    }
}
