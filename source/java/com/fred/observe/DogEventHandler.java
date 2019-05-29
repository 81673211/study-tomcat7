package com.fred.observe;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/23 09:34
 */
public class DogEventHandler implements EventListener {

    @Override
    public void handle(Data data) {
        System.out.println(DogEventHandler.class.getName() + "-" + data.toString());
    }
}
