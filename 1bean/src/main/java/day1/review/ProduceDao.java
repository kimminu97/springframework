package day1.review;

public class ProduceDao {
	
	private int cnt;
	
	public ProduceDao() {
		System.out.println("ProduceDao 기본 생성자***");
	}
	public void setCnt(int cnt) {	
		this.cnt = cnt;
	}
	
	public void produce() {
		System.out.println("dao prodcue()~~~");
		System.out.println("상품을"+cnt+"개 수량으로 생산합니다/");
	}
}
