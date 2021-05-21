package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;

class DirectoryTest {
    public static String[] dir_info(Directory d){

        String dirInfo[] = {
                Boolean.toString(d.isFile()), d.getName(), Integer.toString(d.getSize()),
                                 Integer.toString(d.countChildren()),
                                 Integer.toString(d.getTotalsize()), d.getTime()};
        int i;

        for(i=0; i<dirInfo.length; i++)
        {
            System.out.println(dirInfo[i]);
        }
        return dirInfo;
    }

    LocalDateTime creationtime=LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
    String time=creationtime.format(formatter);

    LocalDateTime creationtime1=LocalDateTime.now();
    Directory root=new Directory(null,"Root",0,creationtime );


    LocalDateTime creationtime2=LocalDateTime.now();
    Directory home=new Directory(root,"home",0,creationtime1 );
    Directory system=new Directory(root,"system",0,creationtime1 );
    Directory images=new Directory(home,"images",0,creationtime1 );
    File file_d=new File(home,"file:f1",1,creationtime2 );
    File file_a=new File(system,"file:f2",1,creationtime2 );
    File file_b=new File(system,"file:f3",1,creationtime2 );
    File file_c=new File(system,"file:f4",1,creationtime2 );
    File file_e=new File(images,"file:f5",1,creationtime2 );
    File file_f=new File(images,"file:f6",1,creationtime2 );


    @Test
    public void VerifyDirinfoRoot() {
        String[] expected={"false", "Root", "4", "2", "6", time};

        assertArrayEquals(expected,dir_info(root));
    }

    @Test
    public void VerifyDirinfoSystem() {
        String[] expected={"false","system","3","3","3", time};

        assertArrayEquals(expected,dir_info(system));
    }

    @Test
    public void VerifyDirinfoHome() {
        String[] expected={"false","home","3","2","3", time};

        assertArrayEquals(expected,dir_info(home));
    }
}