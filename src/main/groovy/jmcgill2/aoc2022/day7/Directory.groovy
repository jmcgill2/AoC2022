package jmcgill2.aoc2022.day7

class Directory {

    String directoryName

    Directory previousDirectory

    ArrayList<Directory> lowerDirectories = []

    ArrayList<DirectoryFile> files = []

    public Directory () {

    }

    public Directory (String directoryName) {
        this.directoryName = directoryName
    }

    public Directory (String directoryName, Directory previousDirectory) {
        this.directoryName = directoryName
        this.previousDirectory = previousDirectory
    }

    def calculateDirectorySize() {
        int size = 0
        if (files.size() > 0) {
            size += files.sum { it.fileSize }
        }
        lowerDirectories.each{dir ->
//            println "processing directory ${dir.directoryName}"
            size += dir.calculateDirectorySize()
//            println "size = $size"
        }
        return size
    }
}
