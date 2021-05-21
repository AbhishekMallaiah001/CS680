package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ApfsDirectoryTest{
    FileSystem fs = FileSystem.getInstance();
    static Date d1 = new Date();
    static Date m1 = new Date();

    private String[] dirinfoinstring(ApfsDirectory d){
        String[] dirInfo = {
                String.valueOf(d.isLeaf()), d.getName(),
                d.getParent().getName(),
                String.valueOf(d.getSize()),
                String.valueOf(d.getTotalSize())
        };
        return dirInfo;
    }
    private String[] rootinfoinstring(ApfsDirectory d){
        String[] dirInfo = {
                String.valueOf(d.isLeaf()), d.getName(),
                String.valueOf(d.getParent()),
                String.valueOf(d.getSize()),
                String.valueOf(d.getTotalSize())
        };
        return dirInfo;
    }
    @Test
    public void TestApfsDirectoryRoot (){
        String[] expected = {"false", "RootDir", "null", "0", "0"};
        ApfsDirectory actual = new ApfsDirectory(null, "RootDir", 0, d1, "Azamk", m1);
        assertArrayEquals(expected, rootinfoinstring(actual) );
    }

    @Test
    public void TestApfsDirectoryHome ()
    {
        String[] expected = {"false", "home", "RootDir", "0", "0"};
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d1, "Azamk", m1);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Azamk", m1);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d1, "Azamk", m1);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        assertArrayEquals(expected, dirinfoinstring(home) );
    }
    @Test
    public void TestApfsDirectorySize ()
    {
        String[] expected = {"false", "pictures", "home", "0", "2000"};
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d1, "Azamk", m1);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Azamk", m1);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d1, "Azamk", m1);
        ApfsDirectory actual = new ApfsDirectory(root, "Home", 0, d1, "Azamk", m1);
        ApfsFile f1 = new ApfsFile(pictures, "OOP", 2000, d1, "Azamk", m1);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(root, actual);
        fs.AddChild(pictures, f1);
        assertArrayEquals(expected, dirinfoinstring(pictures) );
    }
}