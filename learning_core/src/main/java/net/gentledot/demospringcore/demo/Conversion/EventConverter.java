package net.gentledot.demospringcore.demo.Conversion;

import net.gentledot.demospringcore.demo.book.Event;
import org.springframework.core.convert.converter.Converter;

public class EventConverter {

    public static class StringToEventConverter implements Converter<String, Event> {

        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

    public static class EventToStringConverter implements Converter<Event, String> {

        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }
}
