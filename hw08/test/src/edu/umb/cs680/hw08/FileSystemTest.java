package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;

public class FileSystemTest {
    public static String[] dir_info(Link L){

        String LinkInfo[] = {
                Boolean.toString(L.isLink()), L.getName(), Integer.toString(L.getSize()),
                                 L.getTarget().getName(),
                                 Integer.toString(L.getTargetSize()),
                                 Integer.toString(L.getTarget().getSize()), L.getTime()};
        int i;

        for(i=0;i<LinkInfo.length;i++)
        {
            System.out.println(LinkInfo[i]);
        }
        return LinkInfo;
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
    Link l1=new Link(home,"link:l1",0,creationtime1,system);
    Link l2=new Link(images,"link:l2",0,creationtime1,file_e);

    @Test
    public void verifyEqualityLink_l1() {
        String[] expected={"true","link:l1","0","system","3","3", time};
        assertArrayEquals(expected,dir_info(l1));
    }

    @Test
    public void verifyEqualityLink_l2() {
        String[] expected={"true","link:l2","0","file:f5","1","1", time};
        assertArrayEquals(expected,dir_info(l2));
    }
}
