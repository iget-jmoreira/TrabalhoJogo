package TrabalhoJogo;

public class Moviment implements Runnable {
	public int y = 0;
	public Moviment(){
		System.out.println(this.y);
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.y += 1;
	}
}
