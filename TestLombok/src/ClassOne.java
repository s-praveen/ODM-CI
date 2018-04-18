import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import lombok.Data;
import lombok.SneakyThrows;


public @Data abstract class ClassOne {
private int intOne;
private String stringOne;
private Boolean booOne;

//function
public abstract <T> T  newInstance(Class<?> c) throws Exception;
public abstract String getString(String s) throws IOException;

private static class InnerClass implements Serializable {

    private static final long serialVersionUID = 1L;
    

}
@SneakyThrows
private void serializeInnerClass() {
    File file = new File("C:/Users/psharan1/test.txt");
    InnerClass inner = new InnerClass();
    
    new ObjectOutputStream(new FileOutputStream(file)).writeObject(inner);
}
/**
 * Check if the class can be instantiated by unsafe allocator. If the instance has interface or abstract modifiers
 * throw an {@link java.lang.UnsupportedOperationException}
 * @param c instance of the class to be checked
 */
private static void assertInstantiable(Class<?> c) {
  int modifiers = c.getModifiers();
  if (Modifier.isInterface(modifiers)) {
    throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + c.getName());
  }
  if (Modifier.isAbstract(modifiers)) {
    throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + c.getName());
  }
}
public static void main(String s[])
{
//ClassOne CO=new ClassOne();
//CO.serializeInnerClass();
//System.out.println(new ClassOne().toString());
//
//
Collections.sort(Arrays.asList(3, 2, 1), (o1, o2) -> o1.compareTo(o2));
//
//Stream.of("d", "Z", "b", "p", "n") 
//.map(String::toUpperCase)
//.sorted()
//.forEach(System.out::println); 
//

}
}