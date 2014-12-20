// placeholder
public class Cell {
  private String value;

  public Cell() {
    value = "";
  }
  
  public Cell(String input) {
    value = input;
  }
  
  public String getValue() {
    return value;
  }
  
  public String toDisplay() {
    
    //truncate string to length - 1 and display >
    int columnWidth = 12;
    String output = value;
    if (output.length() > columnWidth) {
      output = output.substring(0, columnWidth - 1) + ">";
    }
    
    //if length is odd pad end to even lenth
    if(output.length() % 2 != 0) {
      output += " ";
    }
    
    //justify pad to center in cell
    while (output.length() < columnWidth) {
      output = " " + output + " ";
    }
    return output;
  }
  
  public String toString() {
    String result = getValue();
    if (result.length() == 0) {
      result = "<empty>";
    }
    return result;
  }
  
  public void setValue (String input) {
    value = input;
  }
}
