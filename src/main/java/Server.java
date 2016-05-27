import route.OutputController;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class Server {
    public static void main(String[] args) throws Exception {

        ClassReload.setJar("/Users/dbasak/ServerClassReload/target/ServerClassReload-1.0-SNAPSHOT.jar");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return ClassReload.response(OutputController.class.getCanonicalName());
            }
        });

        Spark.get("/test", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return ClassReload.response("route.NewOutputController");
            }
        });

    }

}
