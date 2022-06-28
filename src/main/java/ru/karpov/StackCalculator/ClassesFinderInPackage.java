package ru.karpov.StackCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public final class ClassesFinderInPackage {
    public final Set<Class<?>> findAllClassesUsingClassLoader(final String packageName) throws IOException {
        final InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        stream.close();
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class<?> getClass(final String className, final String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
