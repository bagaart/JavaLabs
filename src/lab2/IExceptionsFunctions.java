package lab2;

import lab2.exceptions.ArrayLengthException;
import lab2.exceptions.CharacterNotFoundException;
import lab2.exceptions.LettersFoundException;

public interface IExceptionsFunctions {
    void validateArrayLength(String[] str) throws ArrayLengthException;
    void validateStringContainsChar(String[] str) throws CharacterNotFoundException;
    void validateStringContainsLetters(String[] str) throws LettersFoundException;
}
