/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/16 14:26
 */
public class Foo {

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> foo = Class.forName("Foo");
        Object o = foo.newInstance();
        ((Foo) o).read();
    }

    public void read() {
        System.out.println("-----");
    }
}
