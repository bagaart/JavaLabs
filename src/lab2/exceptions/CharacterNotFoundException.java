package lab2.exceptions;

public class CharacterNotFoundException extends Exception {
  @Override
  public String getMessage() {
    return "В строке отсутствует какой-то символ";
  }
}
