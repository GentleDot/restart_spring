package net.gentledot.demospringcore.demo.Conversion;

import net.gentledot.demospringcore.demo.book.Event;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class EventFommter implements Formatter<Event> {

//    @Autowired
//    MessageSource messageSource;

    @Override
    public Event parse(String text, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(text));
    }

    @Override
    public String print(Event object, Locale locale) {
//        messageSource.getMessage("title", locale)
        return object.getId().toString();
    }
}
