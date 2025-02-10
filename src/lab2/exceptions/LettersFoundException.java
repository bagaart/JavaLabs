package lab2.exceptions;

public class LettersFoundException extends Exception {
  @Override
  public String getMessage() {
    return "В строке есть литеры";
  }
}
