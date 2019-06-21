package Model;

public class Poll {

	//atributes
	private String[] question;
	private int[] answer;
	//builder
	public Poll(int resp1,int resp2,int resp3) {
		question=new String[3];
		question[0]="El servicio prestado";
		question[1]="El tiempo de respuestaDado";
		question[2]="La relacion costo/beneficio del servicio adquirido";
		answer=new int[3];
		answer[0]=resp1;
		answer[1]=resp2;
		answer[2]=resp3;
	}
	//getters and setters
	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
	}

	public int[] getAnswer() {
		return answer;
	}

	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
	
	
}
