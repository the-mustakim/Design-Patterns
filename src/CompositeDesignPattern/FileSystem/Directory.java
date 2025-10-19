package CompositeDesignPattern.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    private String name;
    private List<FileSystem> fileSystemList = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    public void addInFileSystem(FileSystem fileSystem){
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + name);
        for(FileSystem fileSystem: fileSystemList){
            fileSystem.ls();
        }
    }
}
