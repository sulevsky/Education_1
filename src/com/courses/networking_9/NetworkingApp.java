package com.courses.networking_9;

/**
 * Created by VSulevskiy on 10.06.2015.
 */
public class NetworkingApp {
    public static void main(String[] args) {
//        URL url = null;
//        try{
//           url = new URL("http://google.com");
//            Reader reader =  new URLReader(url);
//            char[] target = new char[1000];
//            reader.read(target);
//            System.out.print(target);
//            for(char ch : target){
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(calculateDensity(2000000));
    }
    private  static int calculateDensity( int population)
    {
    	        int density = 0;
	            double featureArea = 0.0000000000000000000001/1000000000000000000L;
        System.out.println(featureArea);
        int resultFeatureArea = (int) Math.round(featureArea)/1000000;
    	            density = resultFeatureArea > 0 ? population / resultFeatureArea : density;
    	        return density;
    	    }
}
