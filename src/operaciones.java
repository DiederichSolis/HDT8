public class operaciones implements Asimiliar<operaciones> {
    long startTime = System.currentTimeMillis();
  
    public int pp;
    public String user;
    String name;
    private int n;
    public operaciones(String name, String user, int n) {
        this.name = name;
        this.user = user;
        this.n=n;
        this.pp = ppp();
    }
        

    
    public int grtpp() {
        return pp;
    }
    
    public String getuser() {
        return user;
    }
    
    public int getn() {
        return n;
    }
    
    public void setn(int n) {
        this.pp = ppp();
        this.n = n;
        
    }
    
    private int ppp() {
        int dato = (int) Math.floor((this.n + 20) / 2.0);
        return 139 - (dato * 2);
    }
    public String getname() {
        return name;
    }
    @Override
    public int cc(operaciones operacioness) {
        return Integer.compare(this.pp, operacioness.pp);
    }   

 
    
}
