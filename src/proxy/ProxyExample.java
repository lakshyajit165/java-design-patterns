package proxy;
interface IQueryExecutor{
    public void executeQuery(String queryType) throws Exception;
}
class QueryExecutorImpl implements IQueryExecutor {

    @Override
    public void executeQuery(String queryType) throws Exception {
        System.out.println("Executing " + queryType + " query...");
    }
}
class QueryExecutorProxy implements IQueryExecutor {
    boolean isAdmin;
    QueryExecutorImpl queryExecutor;

    public QueryExecutorProxy(String username, String password) {
        if(username.equals("admin") && password.equals("abc123")){
            isAdmin = true;
        }
        queryExecutor = new QueryExecutorImpl();
    }

    @Override
    public void executeQuery(String queryType) throws Exception {
        if(isAdmin){
            queryExecutor.executeQuery(queryType);
        }else{
            if(queryType.equals("delete")){
                throw new Exception("Delete query not allowed for non-admin users");
            }else{
                queryExecutor.executeQuery(queryType);
            }
        }
    }
}
public class ProxyExample {
    public static void main(String[] args) throws Exception {
        try {
            QueryExecutorProxy queryExecutorProxy = new QueryExecutorProxy("Non admin", "12345");
            queryExecutorProxy.executeQuery("delete");
//            QueryExecutorProxy adminExecutor = new QueryExecutorProxy("admin", "abc123");
//            adminExecutor.executeQuery("delete");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
