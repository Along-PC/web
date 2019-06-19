package common;

/**
 * 基本VO返回
 * @param <T>
 */
public class CommonVO<T> {


    private int status;


    private String message="weimo~~~";


    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return data;
    }

    public void setT(T t) {
        this.data = t;
    }
}
