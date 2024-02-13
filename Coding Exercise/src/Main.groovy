import java.util.Scanner

static void main(String[] args) {
  // Using Scanner to read input from the console
  def scanner = new Scanner(System.in)

  TextFile file = new TextFile()

  try{
    // Get path of the directory to search
    print("Enter path: ")
    def path = scanner.nextLine()

    // Get text to search
    print("Enter Text To Search: ")
    def searchText = scanner.nextLine()

    // Get new value to replace
    print("Enter Text Value: ")
    def newTextValue = scanner.nextLine()

    print("Enter Log Path: ")
    def logPath = scanner.nextLine()

    // Invoke UpdateTextFile to search the original text
    file.UpdateTextFile(path,searchText,newTextValue,logPath)
  }catch (Exception ex){
    // Print specified error
    println("Error: ${ex}")
    println("Please enter correct input paths.")
  }

}