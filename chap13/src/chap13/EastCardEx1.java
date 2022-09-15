package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * EastCard 클래스 구현하기
 * 	 멤버 변수 : int num, boolean iskwang;
 *   생성자 : 멤버값들을 입력받아 객체 생성
 *   		매개변수가 없는 경우 num=1, isKwang=true인 객체 생성
 *   멤버 메서드 : toString() 오버라이딩
 */

class EastCard{
	int num;
	boolean isKwang;
	
	EastCard(int num, boolean isKwang){
		this.num=num;
		this.isKwang=isKwang;
	}
	EastCard(){
		num = 1;
		isKwang=true;
	}
	
	public String toString() {
		
		return num+(isKwang?"K":"");
	}
}
/*
 * CardDeck 클래스 구현하기
 *   멤버 변수 : List<EastCard> cards;
 *             static Map<String,Integer> jokbo;
 *   생성자 : 매개변수 없음.
 *          EastCard 20장을 cards List 객체에 저장
 *          1~10의 숫자를 가진 카드가 각각 2장씩.
 *          숫자값이 1,3,8인 카드 중 한장은 isKwang이 true임.
 *   메서드 : EastCard pick(int idx) : idx번쨰 카드를 제거하여 리턴.
 *   		EastCard pick() : 임의의숫자번째 카드를 제거하여 리턴.
 *          void shuffle() :  cards 섞어 주는 기능.  
 *          				  Collections.shuffle 메서드 이용  
 */

class CardDeck{
	List<EastCard> cards;
	static Map<String, Integer> jokbo;
	static {
		jokbo = new HashMap<>();
		jokbo.put("KK", 4000);
		for(int i=1;i<=10;i++) {
			jokbo.put(""+i+i, 3000+(i*10));
		}
		jokbo.put("12", 2060);jokbo.put("21", 2060);
		jokbo.put("14", 2050);jokbo.put("41", 2050);
		jokbo.put("19", 2040);jokbo.put("91", 2040);
		jokbo.put("110", 2030);jokbo.put("101", 2030);
		jokbo.put("410", 2020);jokbo.put("104", 2020);
		jokbo.put("64", 2010);jokbo.put("46", 2010);		
	}
	CardDeck(){
		cards = new ArrayList<>();
		for(int i=0;i<20;i++) {	//1~10까지의 카드를 2장씩 전체 20카드 저장
			cards.add(new EastCard(i%10+1, ((i==0||i==2||i==7)?true:false)));
		}
	}
	EastCard pick() {
		return cards.remove((int)(Math.random()*cards.size()));
	}
	EastCard pick(int idx) {
		return cards.remove(idx);
	}
	void shuffle() {
		Collections.shuffle(cards);
	}
	@Override
	public String toString() {
		return cards.toString();
	}
}

/*
 * Player 클래스
 *   멤버 변수 : String name
 *            EastCard c1,c2
 *   생성자 : 멤버변수값을 입력받아 객체 생성. 
 *   멤버변수 :
 *    int getScore() : c1,c2 카드의 점수 리턴
 *              c1,c2 카드가 jokbo에 있는 경우 jokbo 점수 리턴
 *              jokbo에 없는 경우 (c1.num + c2.num)%10 리턴         
 *    String toString 오버라이딩
 *              이름과 카드2장을 문자열로 리턴        
 */
class Player{
	String name;
	EastCard c1, c2;
	
	CardDeck c;
	Player(String name, EastCard c1, EastCard c2){
		this.name=name;
		this.c1=c1;
		this.c2=c2;
	}
	
	int getScore() {
		Integer score =0;
		if(c1.isKwang && c2.isKwang)
			score = c.jokbo.get("KK");
		else{
			score = c.jokbo.get(""+c1.num+c2.num);
			if(score==null) {
				score=(c1.num+c2.num)%10;
			}
		}
		return score;
	}

	public String toString() {
		return name+"("+ c1 + "," + c2 + "):" + getScore();
	}
	
	
}

public class EastCardEx1 {

	public static void main(String[] args) {
		System.out.println(new EastCard());
		System.out.println(new EastCard(9,false));
		CardDeck deck = new CardDeck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		
		List<Player> list = new ArrayList<>();
		list.add(new Player("홍길동",deck.pick(0),deck.pick(0)));
		list.add(new Player("김삿갓",deck.pick(0),deck.pick(0)));
		list.add(new Player("이몽룡",deck.pick(0),deck.pick(0)));
		
		System.out.println(list);
		System.out.println("Deck에 남은 카드 갯수:"+ deck.cards.size());
		System.out.println("남은 카드:"+deck.cards);
		/*
		 * Player 중 가장 높은 점수를 가진 Player의 이름 출력
		 * 1등 2등 점수가 같으면 (홍길동,김삿갓) 비김처림
		 */
		Collections.sort(list,(p1,p2)->p2.getScore() - p1.getScore());
		System.out.println(list);
		if(list.get(0).getScore()== list.get(1).getScore())
			System.out.println(list.get(0).name+","+list.get(1).name+" : 비김");
		else
			System.out.println(list.get(0).name + " : 승리");
	}

}
