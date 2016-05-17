package xie.shu.exception;

@SuppressWarnings("serial")
public class UnknowException extends Exception{
	 //异常信息
    public String message;

    public UnknowException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
