package hrms.hrms.core.utilities.results;

public class DataResult<T> extends Result {

    private T data;
    public DataResult(T data, boolean isSuccessful, String message) {
        super(isSuccessful, message);
        this.data = data;
    }
    public DataResult(T data, boolean isSuccessful) {
        super(isSuccessful);
        this.data = data;
    }
    public T getData() {
        return this.data;
    }
}
