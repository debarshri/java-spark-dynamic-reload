package route;

import spark.Request;
import spark.Response;
import spark.Route;

public class TestRoute implements Route {
    public Object handle(Request request, Response response) throws Exception {
        return "asdasdasd";
    }

    public String get()
    {
        return "asdasd";
    }
}
