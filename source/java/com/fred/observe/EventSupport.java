package com.fred.observe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/23 09:36
 */
public class EventSupport {

    private List<EventListener> listeners;

    public EventSupport() {
        this.listeners = new ArrayList<>();
    }

    public void addEventListener(EventListener listener) {
        listeners.add(listener);
    }

    public void rmEventListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void fireData(int id, int type) {
        Data data = new Data(id, type);
        listeners.parallelStream().forEach(listener -> listener.handle(data));
    }
}
