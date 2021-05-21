package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FsElement{

    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.addSubDir(this);
        }

    }

    LinkedList<FsElement> children = new LinkedList<FsElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();

    public LinkedList<FsElement> getChildren(){
        return this.children;
    }

    public void addChild(FsElement child ){
        this.children.add(child);
    }

    public int getChildCount(){
        return children.size();
    }

    public void  addSubDir(Directory sb){
        this.directory.add(sb);
    }

    public LinkedList<Directory> getSubDirs(){
        return this.directory;
    }

    public void addFile(File f){
        this.file.add(f);
    }

    public LinkedList<File> getFiles(){
        return this.file;
    }

    public int getTotalsize(){
        FsElement dir= this;
        Directory d=(Directory) dir;
        int i;
        int total_size=0;
        for(i=0;i<d.getChildren().size();i++){
            total_size = total_size +d.getChildren().get(i).getSize();
        }
        return total_size;
    }

}