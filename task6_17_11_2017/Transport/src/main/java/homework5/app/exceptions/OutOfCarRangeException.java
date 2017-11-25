package homework5.app.exceptions;


public class OutOfCarRangeException extends Exception{
        public OutOfCarRangeException() {
            super();
        }
        public OutOfCarRangeException(String message) {
            super(message);
        }
}
