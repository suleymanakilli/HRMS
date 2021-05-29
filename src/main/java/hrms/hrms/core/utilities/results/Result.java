package hrms.hrms.core.utilities.results;

public class Result {
    private boolean isSuccessful;
    private String message;

    public Result(boolean isSuccessful){
        this.isSuccessful=isSuccessful;
    }
    public Result(boolean isSuccessful,String message){
        this.isSuccessful=isSuccessful;
        this.message=message;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public String getMessage() {
        return message;
    }
}
