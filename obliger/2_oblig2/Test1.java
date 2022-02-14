public class Test1{
    public static void main(String[] args){
        Vanlig aspirin = new Vanlig("Aspirin", 10, 5);
        String test = aspirin.toString();
        System.out.println(test);
     
        Vanlig ibux = new Vanlig("Ibux", 10, 5);
        String test2 = ibux.toString();
        System.out.println(test2);

        Vanedannende morfium = new Vanedannende("Morfium", 100, 50, 10);
        String test3 = morfium.toString();
        System.out.println(test3);
    }

}    

