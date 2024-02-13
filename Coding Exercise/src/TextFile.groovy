class TextFile {
    def UpdateTextFile(String path,String searchText,String newText, String logPath){

        File curDirectory = new File(path)
        def pathList = []

        // This is the interesting part. I can check each file from the directory to every subdirectories
        curDirectory.eachFileRecurse { file ->
            // Verify if its file with the .txt format
            if (file.isFile() && file.name.endsWith('.txt')) {
                if (file.text.contains(searchText)) {

                    // Print file path for log purpose
                    println "Text found in file: ${file.absolutePath}"

                    backupOriginalFiles(path,file)

                    // Change the content of the file
                    def newContent = file.text.replaceAll(searchText,newText)

                    file.text = newContent

                    // Add path fo the file that was modified to list of array
                    pathList.add(file.absolutePath)
                }else{
                    println("Text not found")
                }
            }
        }

        loggingPath(logPath,pathList)
    }

    void backupOriginalFiles(String path, File file){
        File destinationFolder = new File(path + "/backup")

        if(!destinationFolder.exists()){
            destinationFolder.mkdirs()
            println("Destination folder created: '${destinationFolder.absolutePath}' for the backup")

        }
        def newFile = new File(destinationFolder, file.name)
        newFile.text = file.text
    }

    // Log information to the specified log file
    void loggingPath(String logPath,ArrayList[] pathList){
        // Create a Log Path if provided
        if (logPath) {
            def logFile = new File("${logPath}logging.txt")
            logFile.text = pathList.join('\n')
            println "Log file created at: ${logFile.absolutePath}"
        }
    }
}
