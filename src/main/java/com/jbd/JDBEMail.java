package com.jbd;

public class JDBEMail {
    public static void main(String[] args) {
        PathGetter pG = new PathGetter();
        //don't tell anyone it's a secret -> click on "Run" window on bottom (default layout) to type input
        pG.createFileListFromPath(pG.askUserAboutInputPath());
        System.out.println(pG.getFileList()); //delete this line
    }
}
