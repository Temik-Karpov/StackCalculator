import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.ClassesFinderInPackage;

import java.io.IOException;
import java.util.Set;

public class ClassesFinderInPackageTest {
    @Test
    void twoClassesInPackageTest() throws IOException {
        final ClassesFinderInPackage classesFinderInPackage = new ClassesFinderInPackage();
        final Set<Class<?>> classes = classesFinderInPackage.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.stackExtraOperations");
        Assertions.assertEquals(classes.size(), 2);
    }

    @Test
    void sixClassesInPackageTest() throws IOException {
        final ClassesFinderInPackage classesFinderInPackage = new ClassesFinderInPackage();
        final Set<Class<?>> classes = classesFinderInPackage.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.arithmeticOperations");
        Assertions.assertEquals(classes.size(), 5);
    }
}
