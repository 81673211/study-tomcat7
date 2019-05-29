package com.fred.observe;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/23 09:30
 */
public class Main {

    public static void main(String[] args) {
        EventSupport support = new EventSupport();
        support.addEventListener(new CatEventHandler());
        DogEventHandler listener = new DogEventHandler();
        support.addEventListener(listener);
        support.fireData(1, 10);
        support.rmEventListener(listener);
        support.fireData(2, 20);
    }
}
