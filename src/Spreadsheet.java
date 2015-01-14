public class Spreadsheet {
 
 // private fields
  private Cell[][] Spreadsheet;
  private static int row = 11;
  private static int col = 8;
  private static int colWidth = 12;
  private static int asciiOffset = 64;
  private String border;
  private String borderRow;
  
 // private methods
 private static int getCol(String location) {
  //TODO
   return (int) location.charAt(0) - asciiOffset;
 }
 
 private static int getRow(String location) {
  //TODO
   return Integer.parseInt(location.substring(1));
 }
 
 private static String padOrTruncateDisplayString(Cell cell) {
     // truncate string to length - 1 and display >
     String s = cell.getDisplayString();
     if (s.length() > colWidth) {
       s = s.substring(0, colWidth - 1) + ">";
     }
     // if length is odd pad end to even length
     if (s.length() % 2 == 1) {
       s += " ";
     }
     // justify pad to center in cell
     while (s.length() < colWidth) {
       s = " " + s + " ";
     }
     return s;
 }
 
 // constructor
 public Spreadsheet() {
  //TODO
   Spreadsheet = new Cell[row][col];
   Spreadsheet[0][0] = new CellString("");
   
   //Creating the border for the spreadsheet
   border = "";
   for (int i = 0; i < colWidth; i++) {
     border += "-";
   }
   borderRow = border + "+";
   
   for (int cols = 1; cols < col; cols++) {
     Spreadsheet[0][cols] = new CellString((asciiOffset + cols) + "");
     borderRow += border + "+";
   }
   
   for (int rows = 1; rows < row; rows ++) {
     Spreadsheet[rows][0] = new CellNumeric(rows + "");
   }
   
   for (int rows = 1; rows < row; rows++) {
     Spreadsheet[rows][0] = new CellString(rows + "");
     for (int cols = 1; cols < col; cols++) {
       Spreadsheet[rows][cols] = new CellString("");
     }
   }

 }
 
 // mutators
 public void setCell(String location, Cell cell) {
  //TODO
   Spreadsheet[getRow(location)][getCol(location)] = cell;
 }
 
 // accessors
 public Cell getCell(String location) {
  // TODO
   return Spreadsheet[getRow(location)][getCol(location)];
 }
 
 public void print() { //Print entire spreadsheet
  // TODO
   for (int rows = 0; rows < row; rows++) {
     for (int cols = 0; cols < col; cols++) {
       System.out.print(padOrTruncateDisplayString(Spreadsheet[rows][cols]));
       System.out.print("|");
     }
     System.out.println();
     System.out.println(borderRow);
   }
 }
}
