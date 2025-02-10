package lab2;

import lab2.exceptions.ArrayLengthException;
import lab2.exceptions.CharacterNotFoundException;
import lab2.exceptions.LettersFoundException;

public class Validator implements IConsts, IExceptionsFunctions{
    public boolean ex = false;

    @Override
    public void validateArrayLength(String[] str) throws ArrayLengthException {
        if (str.length < IConsts.size){
            ex = true;
            throw new ArrayLengthException();
        }
    }

    @Override
    public void validateStringContainsChar(String[] str) throws CharacterNotFoundException {
        boolean found = false;
        for (String s : str) {
            if (s.contains(IConsts.symbol)) {
                found  = true;
                break;
            }
        }
        if (!found) {
            ex = true;
            throw new CharacterNotFoundException();
        }
    }

    @Override
    public void validateStringContainsLetters(String[] str) throws LettersFoundException {
        for (String s : str) {
            if (s.matches(".*[a-zA-Zа-яА-Я].*")){
                ex = true;
                throw new LettersFoundException();
            }
        }
    }
}
