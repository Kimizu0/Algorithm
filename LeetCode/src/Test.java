import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * @author WanJie
 * @since 2023-01-01 10:49
 */
public class Test<T extends Food & Serializable & Runnable & Callable<Integer>> {
    public static void main(String[] args) {
    }

}


class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}