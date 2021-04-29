package sample;
public class Place {
    String name;
    int id;
    int type;
    int jetons;
    int[] connectedTo;
    int[] connectedBy;
    public Place(int id, String name, int jetons, int[] connectedBy, int[] connectedTo,int type){
        this.name = name;
        this.type = type;
        this.id = id;
        this.jetons = jetons;
        this.connectedBy = connectedBy;
        this.connectedTo = connectedTo;
    }
    public void activate(int type){
        if((jetons==1 ) && this.type==type) System.out.println(this.name + "  -----  "+this.jetons);
        if(this.name.equals("Salle examen Disponible")&& jetons>0) System.out.println(this.name+ "  -----  "+this.jetons);
    }
}
