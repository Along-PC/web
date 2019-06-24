package common;

import lombok.Data;

@Data
public class ResultDTO<T> {

    private  Integer code;

    private  String message;

    public  T data;

}
