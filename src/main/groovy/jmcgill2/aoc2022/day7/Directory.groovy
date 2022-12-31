package jmcgill2.aoc2022.day7

class Directory {

    ArrayList<Directory> lowerDirectories = []

    String directoryName

    Directory previousDirecotry

    ArrayList<DirectoryFile> files = []

    public Directory () {

    }

    public Directory (String directoryName) {
        this.directoryName = directoryName
    }

    public Directory (String directoryName, Directory previousDirectory) {
        this.directoryName = directoryName
        this.previousDirecotry = previousDirectory
    }

    def calculateDirectorySize() {
        int size = 0
        size += files.sum{it.fileSize}
        lowerDirectories.each{dir ->
            size += dir.calculateDirectorySize()
        }
        return size
    }
}
