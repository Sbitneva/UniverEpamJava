package exceptions;


public class OutOfCarRangeException extends Exception{
        public OutOfCarRangeException() {
            super();
        }
        public OutOfCarRangeException(String message) {
            super(message);
        }
}
