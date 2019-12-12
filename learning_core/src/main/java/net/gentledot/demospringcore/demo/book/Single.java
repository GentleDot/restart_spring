package net.gentledot.demospringcore.demo.book;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {
/*
    @Autowired
    Proto proto;

    public Proto getProto() {
        return proto;
    }
*/
    @Autowired
    private ObjectProvider<Proto> proto;

    public Proto getProto() {
        return proto.getIfAvailable();
    }
}
