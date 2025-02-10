package lab2.exceptions;

public class ArrayLengthException extends Exception {
  @Override
  public String getMessage() {
    return "В массиве число элементов меньше указанного";
  }
}
