package chap13_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * EastCard, CardDeck, Player를 이용하여 다음 구동 클래스를 완성하시오
 * [결과]
 * [1k, 2, 3k, 4 ,5 ,6 ,7 ,8k, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * shuffle => 리스트 출력
 * 
 * 게임할 인원수를 입력하세요(최대:10)
 * 5
 * 1등:2번(5,4):9
 * 1등:4번(9,10):9
 * 3등:5번(2,3):5
 * 4등:1번(6,7):3
 * 4등:3번(5,8):3
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




public class Test3 {

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("게임할 인원수를 입력하세요(최대:10)");
		int n = scan.nextInt();
		List<Player> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String p = (i+1)+"번";
			list.add(new Player(p, deck.pick(0), deck.pick(0)));
		}
		Collections.sort(list,(p1,p2)->p2.getScore() - p1.getScore());
		int rank=1;
		int rank2=0;
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			try {
				if(list.get(i+1).getScore() == list.get(i).getScore() && i < list.size()) {
					System.out.println(rank+"등:"+list.get(i)+"여기왔었음");
					rank++;
					rank2=0;
				} else {
					System.out.println(rank+"등:"+list.get(i)+"여기왔었음");
					rank++;
					rank2=0;
				}
			} catch (IndexOutOfBoundsException e) {
				if(list.get(i).getScore() == list.get(i-1).getScore() && i < list.size()) {
					System.out.println(i+"등:"+list.get(i));
				} else {
					System.out.println(rank+"등:"+list.get(i));
					rank=i+1;
				}
			}
		}
		

	}

}
