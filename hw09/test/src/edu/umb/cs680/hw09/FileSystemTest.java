package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileSystemTest {

    @Test
    public void SingletonFileSystemTest() {
        FileSystem fileSystem1 = FileSystem.getInstance();
        FileSystem fileSystem2 = FileSystem.getInstance();

        assertEquals(fileSystem1.hashCode(), (fileSystem2.hashCode()));
    }

    @Test
    public void SingletonRootTest() {
        FileSystem fileSystem = FileSystem.getInstance();
        ApfsDirectory root = fileSystem.getRootDir();
        ApfsDirectory expected = root.getParent();
        ApfsDirectory actual = null;
        assertEquals(actual, (expected));
    }


}