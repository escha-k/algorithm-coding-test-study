import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐시 크기 == 0
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        // 캐시 크기 != 0
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        // cache hit
        for (String cityName:cities){
            String city = cityName.toLowerCase();
            
            if (cache.contains(city)){
                time += 1;
                cache.remove(city);
                cache.addLast(city);
            }
            // cache miss
            else {
                time += 5;
                if(cache.size()>=cacheSize){
                    cache.removeFirst();
                }
                cache.addLast(city);
            }
        }
        return time;
    }
}
