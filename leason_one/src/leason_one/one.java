package leason_one;

public class one {

	static int num_of_prison = 100;
	static int counterMan = (int)(Math.random()*num_of_prison);
	
	public static void main(String[] args) {
		prison_known();
		prison_unkown();
	}
	public static void prison_known(){
		boolean[] enter = new boolean[num_of_prison];
		for (int i = 0; i < enter.length; i++) {
			enter[i]=false;
		}
		boolean firstTime = true;
		int count = 0;
		int step=0;
		boolean light = true;
		while(count<num_of_prison){
			step++;
			int k = (int)(Math.random()*num_of_prison);
			if(k==counterMan){
				if(firstTime){
					count++;
					enter[k]=true;
					firstTime=false;
				}
				if(!light){
					light=true;
					count++;
				}
			}
			else{
				if(!enter[k]&&light){
					enter[k]=true;
					light=false;
				}
			}
		}
		for (int i = 0; i < enter.length; i++) {
			if(!enter[i]){
				System.out.println("Fail!");
				return;
			}
		}
		System.out.println("count: "+count);
		System.out.println("step: "+step);
		System.out.println("freedom!!");
	}
	
	public static void prison_unkown(){
		int[] enter = new int[num_of_prison];
		boolean firstTime= true;
		boolean light = (int)(Math.random()*2)==0?false:true;
		int count=0;
		int step=0;
		while(count<2*num_of_prison){
			step++;
			int k = (int)(Math.random()*num_of_prison);
			if(k==counterMan){
				enter[k]++;
				if(firstTime){
					count=count+2;
					firstTime=false;
				}
				if(light){
					light=false;
					count++;
				}
			}
			else{
				if(!light&&enter[k]<2){
					light=true;
					enter[k]++;
				}
			}
		}
		for (int i = 0; i < enter.length; i++) {
			if(enter[i]==0){
				System.out.println("fail!");
				return;
			}
		}
		System.out.println("count: "+count);
		System.out.println("step: "+step);
		System.out.println("freedom!!");
	}
}
