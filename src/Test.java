import java.util.Scanner;


public class Test {

	public static void main(String []args){
	
		RedBlackBST<Integer,String>rb= new RedBlackBST<Integer,String>();
		
		try {
			Scanner input=new Scanner(System.in);
			
			while(true){
				String []cmds= input.nextLine().split(" ");
				
				if(cmds[0].equals("put")){
					rb.put(Integer.parseInt(cmds[1]), cmds[2]);
				}
				else if(cmds[0].equals("get")){
					String ret=rb.get(Integer.parseInt(cmds[1]));
					if(ret==null) System.out.println("No such key");
					else System.out.println(ret);
				}
				else if(cmds[0].equals("root")){
					System.out.println(rb.getRoot());
				}
				else if(cmds[0].equals("quit")){
					break;
				}
			}
		} catch(NullPointerException n){
			n.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException a){
			a.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
