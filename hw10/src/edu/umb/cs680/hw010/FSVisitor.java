package edu.umb.cs680.hw010;

import java.util.Date;

public interface FSVisitor {
    public void visit(ApfsLink link);
    public void visit(ApfsDirectory dir);
    public void visit(ApfsFile file);
}



