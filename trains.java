import java.util.HashMap;
import java.util.Map;


class UndergroundSystem {
    private Map<Integer,String> idOnStation; 
    private Map<Integer,Integer> idInStationTime ; 
    private Map<String,Double> averageTime; 
    private Map<String,Integer> averageCount; 
    public UndergroundSystem() {
        this.idOnStation=new HashMap<>();
        this.idInStationTime =new HashMap<>();
        this.averageTime=new HashMap<>();
        this.averageCount=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
     idOnStation.put(id,stationName);
     idInStationTime.put(id,t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int in_t = idInStationTime.get(id);
        String s_in = idOnStation.get(id);
        
        String start2endName=s_in+"#"+stationName;
        
        if(averageTime.containsKey(start2endName)){
            double preavrage=averageTime.get(start2endName);
            int count=averageCount.get(start2endName);
            averageTime.put(start2endName,(preavrage*count+t-in_t)/(count+1));
            averageCount.put(start2endName,count+1);
        }else{
            averageTime.put(start2endName,Double.valueOf(t-in_t));
            averageCount.put(start2endName,1);
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
            return this.averageTime.get(startStation+"#"+endStation);
    }
}
