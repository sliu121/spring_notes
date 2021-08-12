import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class use_interface_lambda {
    public static void main(String[] args){
        Predicate_demo<String> length_greater_three = s -> s.length() > 3;
        System.out.println(length_greater_three.test("hello"));
        String[] str = {"sadf","s","hlilasdfjlk","hah","hellosdf"};
        Stream<String> stream = Arrays.stream(str);
        stream.filter(a -> length_greater_three.test(a))
                .forEach(ab -> System.out.println(ab));
    }
}
