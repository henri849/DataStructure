public class Graph{
    static Edge[][] egs;
    int ec = 0;
    Vertex[] ver;
    int vc = 0;
    
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        int caught = 0;
        int lost = 0;
        Graph g = new Graph();
        for (int i = 0; i < 5; i++){
            g.addVertex(i);
        }
        if (g.ver[0].id == 0) pass++;else fail++;
        try{
            g.addVertex(5);
        }catch (RuntimeException a){
            if (a.getMessage().equals("VertexArrayFilled")){
                caught++;
            }else{
                lost++;
            }
        }
        if (g.getVertex(0).id == 0)pass++;else fail++;
        if (g.getVertex(5) == null)pass++;else fail++;
        
        g.addEdge(g.getVertex(0),g.getVertex(1),4);
        g.addEdge(g.getVertex(0),g.getVertex(2),3);
        g.addEdge(g.getVertex(1),g.getVertex(3),1);
        g.addEdge(g.getVertex(3),g.getVertex(4),0);
        g.addEdge(g.getVertex(3),g.getVertex(2),9);

        try{
            g.addEdge(g.getVertex(3), new Vertex(10),10);
        }catch (RuntimeException a){
            if (a.getMessage().equals("VertexNotInGraph")){
                caught++;
            }else{
                lost++;
            }
        }

        if (g.getEdge(g.getVertex(3),g.getVertex(2)).equals(egs[g.getVertex(3).cnt][g.getVertex(2).cnt]))pass++;else fail++;


        try{
            g.getEdge(g.getVertex(3), new Vertex(10));
        }catch (RuntimeException a){
            if (a.getMessage().equals("VertexNotInGraph")){
                caught++;
            }else{
                lost++;
            }
        }

        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);

    }

    public void addEdge(Vertex s, Vertex e, int w) throws RuntimeException{
        try{
            egs[s.cnt][e.cnt] = new Edge(s,e,w);
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("VertexNotInGraph"));
        }
    }

    public Edge getEdge(Vertex s, Vertex e) throws RuntimeException{
        try{
            return egs[s.cnt][e.cnt];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("VertexNotInGraph"));
        }
    }

    public void addVertex(int id) throws RuntimeException{
        try{
            ver[vc] = new Vertex(id);
            vc++;
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("VertexArrayFilled"));
        }
    }
    public Vertex getVertex(int id){
        for (int i = 0; i < vc ; i++){
            if (ver[i].id == id) return ver[i];
        }
        
        return null;
    }
    public Graph(){
        egs = new Edge[5][5];
        ver = new Vertex[5];
    }
}

class Vertex{
	int id;
    static int scnt;
    int cnt;
	public Vertex(int _id){id=_id;cnt=scnt++;}
}
class Edge{
	Vertex start;
	Vertex end; //For directed graph
    int weight;
	public Edge(Vertex s, Vertex e, int w){start = s; end = e; weight = w;}
}
