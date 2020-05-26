import jdk.internal.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static class OOMobject{

    }

    public static void main(String[] args) {
        List<OOMobject> list = new ArrayList<>();
        while (true){
            list.add(new OOMobject());
        }
//        System.out.println("test");
    }
}
